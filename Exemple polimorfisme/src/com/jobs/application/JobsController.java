package com.jobs.application;
/**
 * @autor Enric Comes
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.IPaymentRate;
import com.jobs.persistence.EmployeeRepository;
import com.jobs.domain.Volunteer;

public class JobsController {

	private EmployeeRepository repository;
	
	private List llistaEmpleats;
	String empleats="", classe="";
	Employee empleatBuit;
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
		double resultat;
		
		/* Es recorra la llista, si la classe és Employee, 
		* es fa un objecte Employee i s'aplica el pagament
		*/
		for(int i=0; i<llistaEmpleats.size(); i++) {
			
			classe = llistaEmpleats.get(i).getClass().toString();
			
			if(classe.equals("class com.jobs.domain.Employee")){
				empleatBuit = (Employee)llistaEmpleats.get(i);
				empleatBuit.pay();	
			}
		}
		
	}

	/**
	 * Mètode per a obtenir tots els treballadors, inclòs voluntaris
	 * @return String amb totes les dades ben formatejades
	 */
	public String getAllEmployees() {
		
		//S'aprofita el llistat ja creat i es torna a recòrrer		
		for(int i=0; i<llistaEmpleats.size(); i++) {
			
			classe = llistaEmpleats.get(i).getClass().toString();
			
			/* Si és un Employee, s'afegeix salari i cobrament real del totalPaid,
			* que és de la classe abstracta a la que pertany Employee
			*/
			if(classe.equals("class com.jobs.domain.Employee")){
				empleatBuit = (Employee)llistaEmpleats.get(i);				
				empleats = empleats +"\nNom: " + empleatBuit.getName()
									+ " - Adreça: " + empleatBuit.getAddress()
									+ " - Telèfon: " + empleatBuit.getPhone()
									+ " - Salari: " + empleatBuit.getSalaryPerMonth()
									+ " - Cobrament Real: " + empleatBuit.getTotalPaid(); 
				
			
			}
			/**
			 * Si no, serà del tipus Volunteer i sols es mostraran menys dades,
			 * sense salari i el cobrament a 0
			 */
			else if(classe.equals("class com.jobs.domain.Volunteer")){
				voluntariBuit = (Volunteer)llistaEmpleats.get(i);
				empleats = empleats +"\nNom: " + voluntariBuit.getName() 
									+" - Adreça: " + voluntariBuit.getAddress()
									+" - Telèfon: " + voluntariBuit.getPhone()
									+" - Cobrament: 0";
			}
		}
		
		return empleats;
	}
	
}
