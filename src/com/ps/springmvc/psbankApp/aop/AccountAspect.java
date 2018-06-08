package com.ps.springmvc.psbankApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.ps.springmvc.psbankApp.DAO.*;
import com.ps.springmvc.psbankApp.model.Account;

@Aspect
@Component
public class AccountAspect {

	@Before("execution(* com.ps.springmvc.psbankApp.DAO.AccountDAOImpl.saveAccount(..))")
	public void validateAccount(JoinPoint joinPoint) {
		System.out.println("Method: ValidateAccount is being processed.");
		Object []args = joinPoint.getArgs();
		Account account = (Account)args[0];
		AccountDAO accountDAO = (AccountDAO) joinPoint.getTarget();
		int accountNo = account.getAccountNo();
		if(accountDAO.getAccount(accountNo) != null) {
			throw new RuntimeException("Account with Account Number " + accountNo + " is already exists");
		}
	}
}
