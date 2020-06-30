package com.techelevator.tenmo.dao;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
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
        return jdbcTemplate.queryForObject("select balance from accounts where user_id = ?", BigDecimal.class, userId);
    }
    
    @Override
    public Accounts[] list() {
        return jdbcTemplate.queryForObject("select * from accounts", Accounts[].class);
    }

}
