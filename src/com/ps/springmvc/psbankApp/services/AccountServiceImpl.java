package com.ps.springmvc.psbankApp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ps.springmvc.psbankApp.DAO.AccountDAO;
import com.ps.springmvc.psbankApp.model.Account;

@Service
public class AccountServiceImpl implements AccountService {
	// no need for creating a new intance of accountDAO
	@Autowired
	AccountDAO accountDAO;
	
	// * the persistence context
	// * the database transaction	
	@Override
	@Transactional
	public boolean saveAccount(Account account) {
		return accountDAO.saveAccount(account);
	}

	@Override
	@Transactional
	public List<Account> getAccounts() {
		List<Account> list = accountDAO.getAccounts();
		return list;
	}

	@Override
	@Transactional
	public Account getAccount(Integer accountNo) {
		return accountDAO.getAccount(accountNo);
	}

	@Override
	@Transactional
	public boolean deleteAccount(int accountNo) {
		System.out.println("hit service");
		return accountDAO.deleteAccount(accountNo);
	}

	
}
