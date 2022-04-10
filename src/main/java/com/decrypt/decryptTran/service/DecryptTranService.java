package com.decrypt.decryptTran.service;

import java.util.Base64;
import java.util.Base64.Decoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decrypt.decryptTran.entity.Transaction;
import com.decrypt.decryptTran.repository.DecryptTranRepository;

@Service
public class DecryptTranService {

	@Autowired
	private DecryptTranRepository decryptTranRepository;
	
	public Transaction saveTransaction(Transaction transaction) {
		return decryptTranRepository.saveAndFlush(decryptTran(transaction));
	}
	private static Transaction decryptTran(Transaction transaction) {
		Transaction decryptedTransaction = new Transaction();
		Decoder decoder = Base64.getDecoder();
		byte[] decodedBytes = decoder.decode(transaction.getAccountNumber());
		decryptedTransaction.setAccountNumber(new String(decodedBytes));
		decodedBytes = decoder.decode(transaction.getType());
		decryptedTransaction.setType(new String(decodedBytes));
		decodedBytes = decoder.decode(transaction.getAmount());
		decryptedTransaction.setAmount(new String(decodedBytes));
		decodedBytes = decoder.decode(transaction.getCurrency());
		decryptedTransaction.setCurrency(new String(decodedBytes));
		decodedBytes = decoder.decode(transaction.getAccountFrom());
		decryptedTransaction.setAccountFrom(new String(decodedBytes));
		return decryptedTransaction;
	}
}
