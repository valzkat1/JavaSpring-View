package org.fundacionview.SGSST.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Campo necesario", groups = { GeneralFields.class, LoginFields.class })
	@Size(min = 5)
	private String username;

	@NotEmpty(message = "Campo necesario")
	@Size(min = 6, message = "No cuenta con el número requerido de caracteres")
	private String pass;

	// RELACION ENTRE USUARIOS Y EMPLEADOS -> FOREING KEY
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_employee", referencedColumnName = "id")
	private Employee employee;

	/*
	 * private int id_employee;
	 * 
	 * public int getid_employee() { return id_employee; }
	 * 
	 * public void setid_employee(int id_employee) { this.id_employee = id_employee;
	 * }
	 */

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
