package com.techelevator.tenmo.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.tenmo.model.Transfer;

public class TransferSqlDAO implements TransferDAO{

	private JdbcTemplate jdbcTemplate;
	
	public TransferSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;		
	}
	
	@Override
	public Transfer insertTransfer(Transfer transfer) {
		String sql = "INSERT INTO transfers (transfer_type_id, transfer_status_id,account_from,account_to,amount) VALUES (?,?,?,?,?);";
		jdbcTemplate.update(sql, transfer.getTransfer_type(), transfer.getTransfer_status_id(),transfer.getAccount_from(),transfer.getAccount_to(),transfer.getAmount());
		return transfer;
	}
}
