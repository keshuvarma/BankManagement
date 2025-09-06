package com.example.BankManagement.repositatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankManagement.bean.Account;

@Repository
public interface BankRepositatory  extends JpaRepository<Account, Long>{

}
