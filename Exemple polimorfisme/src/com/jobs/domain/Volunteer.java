package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	

	public Volunteer(String name, String address, String phone) throws Exception {
		super(name, address, phone);
		
		//TODO
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	@Override
	public void pay() {
		//TODO
		
	}
	
	public String toString() {
		
		String resposta = "\nNom: " + getName()
						+ " - Adreça: " + getAddress()
						+ " - Telèfon: " + getPhone();
		
		return resposta;
	}

}
