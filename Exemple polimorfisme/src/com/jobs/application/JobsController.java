package com.jobs.application;
/**
 * @autor Enric Comes
 */

import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;

import com.jobs.persistence.EmployeeRepository;
import com.jobs.domain.Volunteer;

public class JobsController {

	private EmployeeRepository repository;
	
	private List llistaEmpleats;
	String empleats="", classe="";
	AbsStaffMember empleatBuit;
	Volunteer voluntariBuit;
	
	public JobsController(){
		repository = new EmployeeRepository();
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
		
	}

	public void createVolunteer(String string, String string2, String string3) throws Exception {
		Volunteer volunteer = new Volunteer(string, string2, string3);
		repository.addMember(volunteer);
		
	}

	//Mètode per aplicar el pagament real als treballadors no voluntaris	
	public void payAllEmployeers() {
	
		//Obtenir un llistat d'empleats amb el mètode del repository
		llistaEmpleats = repository.getAllMembers();
	
		//Es recorra la llista per aplicar pagament en cada membre
		for(int i=0; i<llistaEmpleats.size(); i++) {
			empleatBuit = (AbsStaffMember)llistaEmpleats.get(i);
			empleatBuit.pay();	
		}
		
	}

	/**
	 * Mètode per a obtenir tots els treballadors, inclòs voluntaris
	 * @return String amb totes les dades ben formatejades
	 */
	public String getAllEmployees() {
		
		//S'aprofita el llistat ja creat 		
		empleats = llistaEmpleats.toString();
		return empleats;
	}
	
}
