package com.ps.springmvc.psbankApp.DAO;

import java.util.List;

import com.ps.springmvc.psbankApp.model.Account;

public interface AccountDAO {
	public boolean saveAccount(Account account);
	public List<Account> getAccounts();
	public Account getAccount(Integer accountNo);
	public boolean deleteAccount(int accountNo);
}
