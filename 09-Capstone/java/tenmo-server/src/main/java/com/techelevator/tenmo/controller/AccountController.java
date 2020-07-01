package com.techelevator.tenmo.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.techelevator.tenmo.dao.AccountsDAO;
import com.techelevator.tenmo.model.Accounts;

@RestController
public class AccountController {

	private AccountsDAO accountDAO;
	private JdbcTemplate jdbcTemplate;
	
	public AccountController(AccountsDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	@RequestMapping(path = "accounts", method = RequestMethod.GET)
    public List<Accounts> list() {
        return accountDAO.list();
    }
	
	@RequestMapping(path = "accounts/{id}/balance", method = RequestMethod.GET)
    public BigDecimal getBalance(@PathVariable int id) throws AccountNotFoundException{
		return accountDAO.getBalance(id);
    }
}
