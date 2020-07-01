package com.jobs.application;
/**
 * @autor Enric Comes
 */
import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	/* Cada mètode té adaptat el cobrament real segons el que cobra de salari mensual
	* i el % que li correspon
	*/
	
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.5;
			}
		};
	}
	
	public static IPaymentRate createPaymentRateEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth/1.15;
			}
		};
	}
	
	public static IPaymentRate createPaymentRateManager() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.1;
			}
		};
	}
	
	
}
