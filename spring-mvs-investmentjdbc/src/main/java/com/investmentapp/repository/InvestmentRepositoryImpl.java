package com.investmentapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.investmentapp.model.Investment;
import com.investmentapp.util.DBQueries;
@Repository
public class InvestmentRepositoryImpl implements IInvestmentRepository {

	private JdbcTemplate jdbcTemplet;
	@Autowired
	public void setJdbcTemplet(JdbcTemplate jdbcTemplet) {
		this.jdbcTemplet = jdbcTemplet;
	}

	@Override
	public void addInvestment(Investment investment) {

//		String sql=DBQueries.INSERTQUERY;
		Object[] investmentArray= {
				investment.getPlanName(),investment.getEntryAge(),investment.getType(),investment.getAmount(),investment.getPurpose(),investment.getRisk(),investment.getNominee(),investment.getTerm()
		};
		jdbcTemplet.update(DBQueries.INSERTQUERY,investmentArray);
	}

	@Override
	public void updateInvestment(int planId, double amount) {

		String sql=DBQueries.UPDATEQUERY;
		jdbcTemplet.update(sql, amount,planId);
	}

	@Override
	public void deleteInvestment(int planId) {

		jdbcTemplet.update(DBQueries.DELETEQUERY,planId);
	}

	@Override
	public List<Investment> findByRiskAndTerm(String risk, int term) {
		return jdbcTemplet.query(DBQueries.SELECTBYRISKTERM, (rs,rowNum)->{
			Investment investment=new Investment();
			investment.setAmount(rs.getInt("amount"));
			investment.setEntryAge(rs.getInt("entry_age"));
			investment.setNominee(rs.getString("nominee"));
			investment.setPlanName(rs.getString("planName"));
			investment.setType(rs.getString("type"));
			investment.setPurpose(rs.getString("purpose"));
			investment.setTerm(rs.getInt("term"));
			investment.setRisk(rs.getString("risk"));
			investment.setPlanId(rs.getInt("plan_id"));
			return investment;
		}, risk,term);
	}

	@Override
	public List<Investment> findByType(String type) {

		 return jdbcTemplet.query(DBQueries.SELECTBYTYPE, (rs,rowNum)->{
			Investment investment=new Investment();
			investment.setAmount(rs.getInt("amount"));
			investment.setEntryAge(rs.getInt("entry_age"));
			investment.setNominee(rs.getString("nominee"));
			investment.setPlanName(rs.getString("planName"));
			investment.setType(rs.getString("type"));
			investment.setPurpose(rs.getString("purpose"));
			investment.setTerm(rs.getInt("term"));
			investment.setRisk(rs.getString("risk"));
			investment.setPlanId(rs.getInt("plan_id"));
			return investment;
		}, type);
	}

	@Override
	public List<Investment> findByPurpose(String purpose) {

		return jdbcTemplet.query(DBQueries.SELECTBYPURPOSE, (rs,rowNum)->{
			Investment investment=new Investment();
			investment.setAmount(rs.getInt("amount"));
			investment.setEntryAge(rs.getInt("entry_age"));
			investment.setNominee(rs.getString("nominee"));
			investment.setPlanName(rs.getString("planName"));
			investment.setType(rs.getString("type"));
			investment.setPurpose(rs.getString("purpose"));
			investment.setTerm(rs.getInt("term"));
			investment.setRisk(rs.getString("risk"));
			investment.setPlanId(rs.getInt("plan_id"));
			return investment;
		}, purpose);
	}

	@Override
	public List<Investment> findAll() {

		RowMapper<Investment> investmentMapper=new InvestmentMapper();
		List<Investment> investments=jdbcTemplet.query(DBQueries.SELECTQUERY,investmentMapper );
		return investments;
	}

	@Override
	public Investment findById(int planId) {
		Investment investment1= jdbcTemplet.queryForObject(DBQueries.SELECTBYID, (rs,rowNum)->{
			Investment investment=new Investment();
			investment.setAmount(rs.getInt("amount"));
			investment.setEntryAge(rs.getInt("entry_age"));
			investment.setNominee(rs.getString("nominee"));
			investment.setPlanName(rs.getString("planName"));
			investment.setType(rs.getString("type"));
			investment.setPurpose(rs.getString("purpose"));
			investment.setTerm(rs.getInt("term"));
			investment.setRisk(rs.getString("risk"));
			investment.setPlanId(rs.getInt("plan_id"));
			return investment;
		}, planId);
		return investment1;
	}

}
