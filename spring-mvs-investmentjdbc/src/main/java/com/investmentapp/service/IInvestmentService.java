package com.investmentapp.service;

import java.util.List;

import com.investmentapp.exceptions.PlanNotFoundException;
import com.investmentapp.model.Investment;

public interface IInvestmentService {

	void addInvestment(Investment investment);
	void updateInvestment(int planId,double amount) throws PlanNotFoundException;
	void deleteInvestment(int planId);
	
	List<Investment> getByRiskAndTerm(String risk,int term);
	List<Investment> getByType(String type);
	List<Investment> getByPurpose(String type);
	List<Investment> getAll();
	
	double calculateMaturity(Investment investment);
	Investment getById(int planId) throws PlanNotFoundException;
}
