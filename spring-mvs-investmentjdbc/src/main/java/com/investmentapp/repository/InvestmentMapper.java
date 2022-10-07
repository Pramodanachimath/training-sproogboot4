package com.investmentapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.investmentapp.model.Investment;

public class InvestmentMapper implements RowMapper<Investment>{

	@Override
	public Investment mapRow(ResultSet rs, int rowNum) throws SQLException {

		String planName=rs.getString("planName");
		String purpose=rs.getString("purpose");
		String nominee=rs.getString("nominee");
		String planType=rs.getString("type");
		String risk=rs.getString("risk");
		int term=rs.getInt("term");
		int entryAge=rs.getInt("entry_age");
		int amount=rs.getInt("amount");
		int planId=rs.getInt("plan_id");
		
		
		Investment investment=new Investment();
		investment.setAmount(amount);
		investment.setEntryAge(entryAge);
		investment.setNominee(nominee);
		investment.setPlanName(planName);
		investment.setType(planType);
		investment.setPurpose(purpose);
		investment.setTerm(term);
		investment.setRisk(risk);
		investment.setPlanId(planId);
		return investment;
	}

}
