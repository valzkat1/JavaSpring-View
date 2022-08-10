package org.fundacionview.SGSST.models;

import org.springframework.stereotype.Component;

@Component
public class AccountReports {

	private double EPS;
	private double ARL;
	private double pensions;
	private double company;

	public AccountReports() {
		super();
	}

	public double getEPS() {
		return EPS;
	}

	public void setEPS(double ePS) {
		EPS = ePS;
	}

	public double getARL() {
		return ARL;
	}

	public void setARL(double aRL) {
		ARL = aRL;
	}

	public double getPensions() {
		return pensions;
	}

	public void setPensions(double pensions) {
		this.pensions = pensions;
	}

	public double getCompany() {
		return company;
	}

	public void setCompany(double company) {
		this.company = company;
	} 
	
	
	
	
}
