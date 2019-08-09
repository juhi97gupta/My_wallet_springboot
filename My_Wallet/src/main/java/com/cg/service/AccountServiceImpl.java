package com.cg.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Account;
import com.cg.dao.AccountDAO;
import com.cg.exception.ApplicationException;
import com.cg.exception.InsuffecientFundException;


@Service
@Transactional
public class AccountServiceImpl implements AccountOperation {
	@Autowired AccountDAO dao;
	
	

	@Transactional(propagation=Propagation.REQUIRED)
	public void addAccount(Account ob) {
		// TODO Auto-generated method stub
		Optional<Account> temp=dao.findById(ob.getMobile());
		if(!temp.isPresent()) {
			dao.save(ob);
			
		}
		else
			throw new ApplicationException("Account "+ob.getId()+ " already exists!");
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public Account findAccount(Long Mobileno) {
		Optional<Account> acc= dao.findById(Mobileno);
		if(acc.isPresent()) {
		return acc.get();
			
		}
		else
			throw new ApplicationException("Account "+Mobileno+ " does-not exists!");
	}

@Transactional(propagation=Propagation.REQUIRED)
	public void updateAccount(Account ob) {
		// TODO Auto-generated method stub
		Optional<Account> temp = dao.findById(ob.getMobile());
		if(temp.isPresent()) {
		
			dao.save(ob);
		}
			else
				throw new ApplicationException("Account "+ob.getMobile()+" didn't exists!");
		}

@Transactional(propagation=Propagation.REQUIRED)
	public void deleteAccount(long mobile) {
		Optional<Account> temp = dao.findById(mobile);
		if(temp.isPresent()) {
			dao.deleteById(mobile);
		}
		else
			System.out.println("Account does-not exists");
	}


	
@Transactional(readOnly=true)
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
	List<Account> acc= dao.findAll();
	return acc;
	}


@Transactional(propagation=Propagation.REQUIRED)
public void TransferMoney(Account from, Account to, double amount) throws InsuffecientFundException {
	// TODO Auto-generated method stub
	double new_balance=from.getBalance()-amount;
	double new_balance1=to.getBalance()+amount;
	if(new_balance<1000.00 && amount>0) {
		new_balance=from.getBalance();
		new_balance1=to.getBalance();
		}
	from.setBalance(new_balance);
	to.setBalance(new_balance1);
	updateAccount(from);
	updateAccount(to);
}

@Transactional(propagation=Propagation.REQUIRED)
public void withdraw(Account ob, double amount) throws InsuffecientFundException {
	double new_balance=ob.getBalance()-amount;
	if(new_balance<1000.0)
	{
		new_balance=ob.getBalance();
		
		throw new InsuffecientFundException("Insufficient Fund. It will effect minium balance",new_balance);
	}
	ob.setBalance(new_balance);
	updateAccount(ob);
	
}
}
