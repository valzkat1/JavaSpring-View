package org.fundacionview.SGSST.models;

public enum Roles {

	Admin("Role_Admin"),
	Auxiliar("R"),
	Consultas("");
	
	private String nameRol;
	
	Roles(String nameRole){
		this.nameRol = nameRole;
	}
	
	public String getRoleName() {
		return this.nameRol;
	}
}
