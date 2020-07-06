package com.jobs.domain;
/**
 * @autor Enric Comes
 */
public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();

		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
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
	
	public double getSalaryPerMonth() {
		return salaryPerMonth;
	}



	public void setSalaryPerMonth(double salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}



	public IPaymentRate getPaymentRate() {
		return paymentRate;
	}



	public void setPaymentRate(IPaymentRate paymentRate) {
		this.paymentRate = paymentRate;
	}



	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}
	
	/*
	 * Mètode per a obtenir el salari ja corregit segons l'ofici
	 * @return propietat totalPaid
	 */
	public double getTotalPaid() {
		return totalPaid;
	}
	
	public String toString() {
		
		String resposta = "\nNom: " + getName()
						+ " - Adreça: " + getAddress()
						+ " - Telèfon: " + getPhone()
						+ " - Salari: " + getSalaryPerMonth()
						+ " - Cobrament Real: " + (double)Math.round(getTotalPaid()*100d)/100d;
		
		return resposta;
	}
	

}
