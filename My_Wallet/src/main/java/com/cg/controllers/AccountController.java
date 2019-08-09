package com.cg.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Account;
import com.cg.exception.InsuffecientFundException;
import com.cg.service.AccountServiceImpl;
@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/account")
public class AccountController {
	
@Autowired AccountServiceImpl service;

	@PutMapping(value="/add", consumes= {"application/json"})
	public String create(@RequestBody Account ob) {
	service.addAccount(ob);
	return "Account created!!";
	}
	
	@PutMapping(value="/update/{mobile}", consumes= {"application/json"})
	public String update(@RequestBody Account ob) {
		
		//Account ac = service.findAccount(mobile);
		System.out.println(ob);
	service.updateAccount(ob);
	return "Account updated!!";
	}
	@DeleteMapping(value="/delete/{mobile}")
	public String delete(@PathVariable long mobile) {
		service.deleteAccount(mobile);
		return "Account deleted";
	}
	@GetMapping(value="/all")
	public  List<Account> find() {
		List<Account> li = new ArrayList<Account>();
				service.getAllAccount().forEach(li::add);
		return li;
		//return "Product found";	
	}
	
	
	@GetMapping(value="/{mobileno}")
	public Account findbyId(@PathVariable long mobileno){
	
		Account acc =  service.findAccount(mobileno);
		
		return acc;
	}
	
	
	@PostMapping(value="/amount/mobile/{mobile}/mobile/{mobile}/amount/{amount}")
public String TransferMoney(@PathVariable long  from, long to,double amount) throws  InsuffecientFundException {
		Account acc1 =  service.findAccount(from);
		Account acc2 =  service.findAccount(to);
		service.TransferMoney(acc1,acc2,amount);
		return "Money transferred";
	}
	@PostMapping(value="/withdraw/mobile/{mobile}/amount/{amount}")
	public String withdraw(@PathVariable long mobile, double amount)  throws InsuffecientFundException{
		Account acc =  service.findAccount(mobile);
		System.out.println(acc);
		service.withdraw(acc, amount);
		return "Withdraw your Amount";
}
	

}













