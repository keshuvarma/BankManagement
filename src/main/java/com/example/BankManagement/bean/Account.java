package com.example.BankManagement.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountNumber;
	private String accountname;
	private long balance;

	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public long getBalance() {
		return balance;
	}
	@Override
	public String toString() {
		return "Bank [accountNumber=" + accountNumber + ", accountname=" + accountname + ", balance=" + balance + "]";
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public Account(long accountNumber, String accountname, long balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountname = accountname;
		this.balance = balance;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
