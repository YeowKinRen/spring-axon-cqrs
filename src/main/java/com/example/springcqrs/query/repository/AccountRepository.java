package com.example.springcqrs.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springcqrs.query.entity.Account;

/**
 * @author 
 **/
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}