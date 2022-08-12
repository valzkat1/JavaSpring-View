package org.fundacionview.SGSST.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "empleados")
public class Employee {

	public enum typeId {
		cc, ce, pp
	}

	public enum workArea {
		direccion, administracion, produccion, contabilidad, sistemas, sg
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Min(value = 1000000, message = "Solo números de cédula válidos")
	@NotEmpty(message = "Campo necesario", groups = { GeneralFields.class })
	private Long dni;

	@NotEmpty(message = "Campo necesario", groups = { GeneralFields.class })
	private String name;

	@NotEmpty(message = "Campo necesario", groups = { GeneralFields.class })
	private String lastName;
	
	private Double salary;
	
	private String position;
	
	private String EPS;
	
	private String AFP;
	
	private String ARL;
	
	private Date birthDate;

	@Enumerated(EnumType.ORDINAL)
	private typeId tI;

	@Enumerated(EnumType.ORDINAL)
	private workArea aT;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getposition() {
		return position;
	}

	public void setposition(String position) {
		this.position = position;
	}

	public String getEPS() {
		return EPS;
	}

	public void setEPS(String ePS) {
		EPS = ePS;
	}

	public String getAFP() {
		return AFP;
	}

	public void setAFP(String aFP) {
		AFP = aFP;
	}

	public String getARL() {
		return ARL;
	}

	public void setARL(String aRL) {
		ARL = aRL;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public typeId gettI() {
		return tI;
	}

	public void settI(typeId tI) {
		this.tI = tI;
	}

	public workArea getaT() {
		return aT;
	}

	public void setaT(workArea aT) {
		this.aT = aT;
	}

}
