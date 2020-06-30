package com.techelevator.tenmo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.AccountsDAO;
import com.techelevator.tenmo.dao.AccountsSqlDAO;
import com.techelevator.tenmo.model.Accounts;

@RestController
public class AccountController {

	private AccountsDAO accountDAO;
	private JdbcTemplate jdbcTemplate;
	
	public AccountController(AccountsDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	@RequestMapping(path = "accounts", method = RequestMethod.GET)
    public Accounts[] list() {
        return accountDAO.list();
    }
}
