package org.fundacionview.SGSST.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ausentismos")
public class WorkIncapacity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/*@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_employee", referencedColumnName = "id")
	private Employee employee;*/
	
	//employee information
	private String name;
	private String lastName;
	private String docType;
	private Long idEmployee;
	private String position; 
	private String EPS; 
	private double salary;
	
	
	public enum typeOfDisability{
		ec, licm, licp, acct, el, fp, act
	}
	
	private typeOfDisability typeOfDisability;
	
	private Date startDate; 
	
	private Date endDate;
	
	private int totalDays; 
	
	private double salaryPerDay;
	
	public enum classification{
		ini, pro
	}
	
	private classification classification;
	
	private double disabilityValue; 
	
	private double valueForTheCompany;
	
	private double EPSTotal; 
	
	private double ARLTotal; 
	
	private double PensionsTotal; 
	
	//CIE10
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "", referencedColumnName = "")
	private CIE10 diagnosis;

	public WorkIncapacity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public Long getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEPS() {
		return EPS;
	}

	public void setEPS(String ePS) {
		EPS = ePS;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public typeOfDisability getTypeOfDisability() {
		return typeOfDisability;
	}

	public void setTypeOfDisability(typeOfDisability typeOfDisability) {
		this.typeOfDisability = typeOfDisability;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public double getSalaryPerDay() {
		return salaryPerDay;
	}

	public void setSalaryPerDay(double salaryPerDay) {
		this.salaryPerDay = salaryPerDay;
	}

	public classification getClassification() {
		return classification;
	}

	public void setClassification(classification classification) {
		this.classification = classification;
	}

	public double getDisabilityValue() {
		return disabilityValue;
	}

	public void setDisabilityValue(double disabilityValue) {
		this.disabilityValue = disabilityValue;
	}

	public double getValueForTheCompany() {
		return valueForTheCompany;
	}

	public void setValueForTheCompany(double valueForTheCompany) {
		this.valueForTheCompany = valueForTheCompany;
	}

	public double getEPSTotal() {
		return EPSTotal;
	}

	public void setEPSTotal(double ePSTotal) {
		EPSTotal = ePSTotal;
	}

	public double getARLTotal() {
		return ARLTotal;
	}

	public void setARLTotal(double aRLTotal) {
		ARLTotal = aRLTotal;
	}

	public double getPensionsTotal() {
		return PensionsTotal;
	}

	public void setPensionsTotal(double pensionsTotal) {
		PensionsTotal = pensionsTotal;
	}

	public CIE10 getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(CIE10 diagnosis) {
		this.diagnosis = diagnosis;
	}

	
	
	
	
	
}
