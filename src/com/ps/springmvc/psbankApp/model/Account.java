package com.ps.springmvc.psbankApp.model;


import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.ps.springmvc.psbankApp.validations.PSCode;

public class Account {
	@NotNull
	private Integer accountNo;
	
	
	@NotNull
	@Size(min=2,max=50, message="invalid length for Account Holder name")
	@Pattern(regexp="[A-Za-z(\\s)]+", message="Invalid")
	private String accountHolderName;
	
	@NotNull(message="balance cannot be blank")
	@Min(value=500, message="not enough")
	private Integer balance;
	
	@NotNull(message="acc type cannot be blank")
	private String accountType;
	
	@NotNull(message="DOB cannot be blank")
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Past(message="Invalid DOB")
	private Date dateOfBirth;
	
	@NotNull(message="PS cannot be blank")
	@PSCode(value="PSUSA", message="Security code should start with PSUSA")
	private String psCode;
	
	
	public Account() {
		accountNo = 0;
		accountHolderName = "";
		balance = 0;
	}
	
	public Account(Integer accNo, String holderName, Integer balance) {
		this.accountNo = accNo;
		this.accountHolderName = holderName;
		this.balance = balance;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getPsCode() {
		return psCode;
	}

	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}

	public @NotNull(message = "DOB cannot be blank") @Past(message = "can't be possible") Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(@NotNull(message = "DOB cannot be blank") @Past(message = "can't be possible") Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
