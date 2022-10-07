package com.investmentapp.model;

public enum planType {

	mutual("Mutual Fund"),
	ppf("Public Provident Fund"),
	ulip("Unit Limited Investment Scheme"),
	fd("Fixed Deposite");
	
	public String type;
	
	private planType(String planType) {
		this.type=planType;
	}
}
