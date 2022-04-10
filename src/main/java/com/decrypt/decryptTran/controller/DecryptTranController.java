package com.decrypt.decryptTran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decrypt.decryptTran.entity.Transaction;
import com.decrypt.decryptTran.service.DecryptTranService;

@RestController
@RequestMapping("transaction")
public class DecryptTranController {

	@Autowired
	private DecryptTranService decryptTranService;
	
	@PostMapping
	public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction)
	{	
		Transaction response = decryptTranService.saveTransaction(transaction);
		if(response!=null)
		{
			return new ResponseEntity<Transaction>(response, HttpStatus.CREATED);
		}
		return new ResponseEntity<Transaction>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
