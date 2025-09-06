package com.example.BankManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankManagement.bean.Account;
import com.example.BankManagement.service.BankService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	BankService service;
	
	@PostMapping("/createaccount")
	public ResponseEntity<String> createaccount(@RequestBody Account acc) {
		Account created= service.createAccount(acc);
		return ResponseEntity.status(HttpStatus.CREATED).body("Account created for "+ created);
	}
	
	@GetMapping("/allAccounts")
	public List<Account> allAccounts() {
		List<Account> allaccounts =service.allaccounts();
		return allaccounts;
	}
	
	@GetMapping("/getaccount/{id}")
	public Account getaccount (@PathVariable Long id) {
		Account getaccount= service.getaccount(id);
		return getaccount;
	}
	
	@PutMapping("/deposit/{accountnumber}/{money}")
	public Account depositBalance( @PathVariable long accountnumber,@PathVariable long money)
	{
		Account getaccountafterdeposit= service.depositBalance(accountnumber,money);
		return getaccountafterdeposit;
	}
	
	@PutMapping("/withDrawBalance/{accountnumber}/{money}")
	public Account withDrawBalance( @PathVariable long accountnumber,@PathVariable long money)
	{
		Account getaccountafterdeposit= service.withDrawBalance(accountnumber,money);
		return getaccountafterdeposit;
	}
	
	@DeleteMapping("/closeaccount/{accountnumber}")
	public ResponseEntity<String> closeaccount( @PathVariable long accountnumber)
	{
		service.closeaccount(accountnumber);
		return ResponseEntity.status(HttpStatus.ACCEPTED
				).body("account closed");
	}
	
	
}
