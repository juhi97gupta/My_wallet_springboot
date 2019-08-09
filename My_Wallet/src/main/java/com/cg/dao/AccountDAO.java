package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bean.Account;


public interface AccountDAO extends JpaRepository<Account,Long>{

}
