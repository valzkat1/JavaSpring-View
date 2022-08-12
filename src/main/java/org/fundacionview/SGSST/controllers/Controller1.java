package org.fundacionview.SGSST.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.fundacionview.SGSST.models.CIE10;
import org.fundacionview.SGSST.models.Employee;
import org.fundacionview.SGSST.models.LoginFields;
import org.fundacionview.SGSST.models.User;
import org.fundacionview.SGSST.models.WorkIncapacity;
import org.fundacionview.SGSST.models.WorkIncapacity.typeOfDisability;
import org.fundacionview.SGSST.repositories.RepositoryCIE10;
import org.fundacionview.SGSST.repositories.RepositoryEmployee;
import org.fundacionview.SGSST.repositories.RepositoryPermissions;
import org.fundacionview.SGSST.repositories.RepositoryUser;
import org.fundacionview.SGSST.repositories.RepositoryWorkIncapacity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller1 {

	@Autowired
	RepositoryUser userRepo;

	@Autowired
	RepositoryEmployee employeeRepo;

	@Autowired
	RepositoryWorkIncapacity wiRepo;

	@Autowired
	RepositoryPermissions permissionRepo;

	@Autowired
	RepositoryCIE10 cie10Repo;

	@GetMapping("/")
	public String index(Model mod) {

		mod.addAttribute("user", new User());
		return "index";
	}

	@PostMapping("/login")
	public String login(Model mod, @Validated(LoginFields.class) @ModelAttribute("user") User u, BindingResult br,
			HttpSession access) {
		if (br.hasErrors()) {
			return "index";
		} else {
			return "redirect:/";
		}
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

//	Error Date 
	@InitBinder
	public void bindeFechas(WebDataBinder date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		date.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}

	// create employee
	@GetMapping("/employeeForm")
	public String createEmployee(Model mod) {
		mod.addAttribute("employee", new Employee());

		return "EmployeeForm";
	}

	@PostMapping()
	public String processEmployeeForm(Model mod, @Valid @ModelAttribute("employee") Employee e, BindingResult rv) {
		if (rv.hasErrors()) {
			return "employeeForm";
		} else {
			employeeRepo.save(e);

			return "redirect:/home";
		}
	}

//	list employee
	@GetMapping("/employeeList")
	public String listEmployees(Model mod) {

		mod.addAttribute("employeeList",employeeRepo.findAll());

		return "employeeList";
	}

//	Update employee
	@GetMapping("/update_employee")
	public String updateEmployee(Model mod, @RequestParam("id") int id) {
		mod.addAttribute("employee", employeeRepo.getById(id));

		return "updateEmployee";
	}
	
	//Delete employee
	@GetMapping("/delete_employee")
	public String deleteEmployee(Model mod, @RequestParam("id")int id) {
		employeeRepo.deleteById(id);
		
		return "redirect:/employeeList";
	}

	// Create User
	@GetMapping("/create_user")
	public String createUser(Model mod, @RequestParam("id") int id) {
		User checkUser = userRepo.checkUserExistence(id);

		if (checkUser != null) {

			mod.addAttribute("user", checkUser);
			mod.addAttribute("update", true);
			mod.addAttribute("title", "Editar Usuario del Empleado: " + id);
			return "UserForm";
		} else {
			User u = new User();
			u.setEmployee(employeeRepo.getById(id));
			mod.addAttribute("user", u);
			mod.addAttribute("update", false);
			mod.addAttribute("title", "Crear Usuario del Empleado: " + id);
			return "UserForm";
		}
	}

	@PostMapping("/userForm")
	public String createUs(@Valid @ModelAttribute("user") User u, Model mod, BindingResult br) {
		if (br.hasErrors()) {
			return "userForm";
		} else {
			userRepo.save(u);
			return "employeeList";
		}
	}

	// list user
	@GetMapping("/userlist")
	public String userList(Model mod) {
		mod.addAttribute(userRepo.findAll());

		return "userList";
	}

	@GetMapping("/update_user")
	public String updateUser(Model mod, @RequestParam("id") int id) {

		mod.addAttribute("user", userRepo.getById(id));
		mod.addAttribute("update", true);
		mod.addAttribute("title", "Editar Usuario del Empleado: " + id);

		return "userForm";
	}

	// delete user
	@GetMapping("/delete_user")
	public String deleteUser(Model mod, @RequestParam("id") int id) {
		userRepo.deleteById(id);

		return "redirect:/userList";
	}

	// work incapacity forms
	@GetMapping("/wi_form")
	public String workIncapacityForm(Model mod) {
		mod.addAttribute("incapacity", new WorkIncapacity());

		return "WorkIncapacityForm";
	}

	@PostMapping("/wi_form")
	public String processWorkIncapacityForm(Model mod, @Valid @ModelAttribute("incapacity")WorkIncapacity wi, BindingResult rv,@RequestParam("dataDiagnosti")String dataDiagnosti) {
		
		if(rv.hasErrors()) {
			return "WorkIncapacityForm";
		}else {
			
			Employee e = employeeRepo.queryById((wi.getIdEmployee()));
			
			//wi.setDocType(e.gettI());
			//wi.setAreaTrabajo(e.getAreaEmpleado());
			wi.setLastName(e.getlastName());
			wi.setDiagnosis(cie10Repo.getDiagnosis(dataDiagnosti.toLowerCase()));
			
			double valorInca = wi.getTotalDays() * wi.getSalaryPerDay();
			wi.setDisabilityValue(valorInca);
			
			double calculos[] = calculatePayingEntity(wi.getTypeOfDisability(), wi.getTotalDays(), wi.getSalaryPerDay());
			wi.setEPSTotal(calculos[1]);
			wi.setARLTotal(calculos[3]);
			wi.setPensionsTotal(calculos[2]);
			wi.setValueForTheCompany(calculos[0]);
			//a.setFechaReg(new Date());
			
			wiRepo.save(wi);
			
			return "redirect:/WorkIncapacityList";
		}
	}

	public double[] calculatePayingEntity(typeOfDisability typeOfDisability, int totalDays, double salarioPerDay) {

		double totalPagar[] = new double[4]; // 0=Empleador, 1=EPS, 2=Fondo Pension,3= ARL
		if (typeOfDisability.equals("Enfermedad Comun")) {
			if (totalDays < 3) {
				totalPagar[0] = totalDays * salarioPerDay;
				totalPagar[1] = 0.0;
				totalPagar[2] = 0.0;
				totalPagar[3] = 0.0;
			} else if (totalDays <= 180) {
				totalPagar[0] = (2 * salarioPerDay);
				totalPagar[1] = ((totalDays - 2) * salarioPerDay) * 0.6667;
				totalPagar[2] = 0.0;
				totalPagar[3] = 0.0;
			} else if (totalDays <= 540) {
				totalPagar[0] = (2 * salarioPerDay);
				totalPagar[1] = ((178) * salarioPerDay) * 0.6667;
				totalPagar[2] = (totalDays - 180) * salarioPerDay * 0.5;
				totalPagar[3] = 0.0;
			} else {
				totalPagar[0] = (2 * salarioPerDay);
				totalPagar[1] = ((178) * salarioPerDay) * 0.6667;
				totalPagar[2] = (totalDays - 180) * salarioPerDay * 0.5;
				totalPagar[3] = 0.0;
			}
		} else if (typeOfDisability.equals("Licencia Maternidad")) {
			totalPagar[0] = 0.0;
			totalPagar[1] = totalDays * salarioPerDay;
			totalPagar[2] = 0.0;
			totalPagar[3] = 0.0;
		} else if (typeOfDisability.equals("Licencia Paternidad")) {
			totalPagar[0] = 0.0;
			totalPagar[1] = totalDays * salarioPerDay;
			totalPagar[2] = 0.0;
			totalPagar[3] = 0.0;

		} else if (typeOfDisability.equals("Accidente de Trabajo")
				|| typeOfDisability.equals("Enfermedad Laboral")) {
			totalPagar[0] = 0.0;
			totalPagar[1] = 0.0;
			totalPagar[2] = 0.0;
			totalPagar[3] = totalDays * salarioPerDay;

		} else if (typeOfDisability.equals("Fondo Pensiones")) {
		} else if (typeOfDisability.equals("Accidente de Transito")) {

			if (totalDays < 3) {
				totalPagar[0] = totalDays * salarioPerDay;
				totalPagar[1] = 0.0;
				totalPagar[2] = 0.0;
				totalPagar[3] = 0.0;
			} else {
				totalPagar[0] = 2 * salarioPerDay;
				totalPagar[1] = 0.0;
				totalPagar[2] = 0.0;
				totalPagar[3] = (totalDays - 2) * salarioPerDay * 0.67;
			}
		}

		return totalPagar;
	}

	// incapacity list
	@GetMapping("/listDisabilities")
	public String listDisabilities(Model mod) {

		mod.addAttribute("listdisability", wiRepo.findAll());

		return "WorkIncapacityList";
	}
	
	@GetMapping("/update_disability")
	public String updateDisability(Model mod, @RequestParam("id")int id) {
		mod.addAttribute("incapacity", wiRepo.getById(id));
		
		return "update_disability";
	}
}
