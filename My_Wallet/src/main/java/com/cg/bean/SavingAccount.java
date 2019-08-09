package com.cg.bean;

public class SavingAccount {
	private double interest;
	private final double min_balance=1000.00;
	
	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SavingAccount(double interest) {
		super();
		this.interest = interest;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public double getMin_balance() {
		return min_balance;
	}
	@Override
	public String toString() {
		return "SavingAccount [interest=" + interest + ", min_balance=" + min_balance + "]";
	}

}
