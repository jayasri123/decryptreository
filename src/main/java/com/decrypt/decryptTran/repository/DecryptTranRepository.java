package com.decrypt.decryptTran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decrypt.decryptTran.entity.Transaction;

public interface DecryptTranRepository extends JpaRepository<Transaction,String>{

}
