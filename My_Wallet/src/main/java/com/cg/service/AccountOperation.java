package com.cg.service;

import java.util.List;
import java.util.Map;

import com.cg.bean.Account;
import com.cg.exception.InsuffecientFundException;

public interface AccountOperation {
	 public void addAccount(Account ob);
		
		
		
		public void deleteAccount(long mobile);
		
		public Account findAccount(Long Mobileno);
		
		public void updateAccount(Account ob);
		public void withdraw(Account ob, double amount)  throws InsuffecientFundException ;
		
		public List<Account> getAllAccount();
		public void TransferMoney(Account from, Account to,double amount) throws InsuffecientFundException;
		

	
}
