package com.techelevator.tenmo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.tenmo.model.Accounts;

@Component
public class AccountsSqlDAO implements AccountsDAO{

	private JdbcTemplate jdbcTemplate;
	
    public AccountsSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public BigDecimal getBalance(int userId) {
        return jdbcTemplate.queryForObject("select balance from accounts where user_id = ?;", BigDecimal.class, userId);
    }
    
    @Override
    public List<Accounts> list() {
    	List<Accounts> accountsList = new ArrayList<Accounts>();
    	String sql = "select * from accounts;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
        	Accounts account = mapRowToAccount(results);
        	accountsList.add(account);
        }
        return accountsList;
    }
    
    @Override
    public void updateBalance(Accounts account) {
    	String sql = "UPDATE accounts SET balance = ? WHERE user_id = ?;";
    	jdbcTemplate.update(sql,account.getBalance(),account.getUserId());
    }
    
    private Accounts mapRowToAccount(SqlRowSet results) {
    	Accounts account = new Accounts();
		account.setUserId(results.getInt("user_id"));
		account.setAccountId(results.getInt("account_id"));
		account.setBalance(results.getBigDecimal("balance"));
		return account;
    }

}
