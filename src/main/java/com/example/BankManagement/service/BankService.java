package com.example.BankManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankManagement.bean.Account;
import com.example.BankManagement.repositatory.BankRepositatory;

@Service
public class BankService {

	@Autowired
	BankRepositatory repo;
	
	public Account createAccount(Account acc) {
		Account accountcreated= repo.save(acc);
		return accountcreated;
	}
	
	public List<Account> allaccounts(){
		List<Account> all=	repo.findAll();
		return all;
	}
	
	public Account getaccount (Long id) {
		Optional<Account>  getaccount = repo.findById(id);
		if (getaccount.isEmpty()) {
			throw new RuntimeException ("account is not found");
		}
		else
		{
		Account accountfound=	getaccount.get();
		return accountfound;
		}
	}
	
	public Account depositBalance (long accountnumber,long money) {
		Optional<Account>  getaccount = repo.findById(accountnumber);
		if (getaccount.isEmpty()) {
			throw new RuntimeException ("account is not found");
		}
		else
		{
		Account accountfound = getaccount.get();
		long deposit = accountfound.getBalance() + money; 
		accountfound.setBalance(deposit);
		repo.save(accountfound);
		return accountfound;
		}
		
	}
	
	public Account withDrawBalance (long accountnumber,long money) {
		Optional<Account>  getaccount = repo.findById(accountnumber);
		if (getaccount.isEmpty()) {
			throw new RuntimeException ("account is not found");
		}
		else
		{
		Account accountfound = getaccount.get();
		long deposit = accountfound.getBalance() -money; 
		accountfound.setBalance(deposit);
		repo.save(accountfound);
		return accountfound;
		}
	}
	
	public Account closeaccount(long accountNumber) {
		Optional<Account>  getaccount = repo.findById(accountNumber);
		if (getaccount.isEmpty()) {
			throw new RuntimeException ("account is not found");
		}
		else
		{
		Account accountfound = getaccount.get();
		repo.deleteById(accountfound.getAccountNumber());
		return accountfound;
		}
	}
}
