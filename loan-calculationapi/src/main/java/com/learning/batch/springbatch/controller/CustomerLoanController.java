package com.learning.batch.springbatch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.batch.springbatch.dto.LoanDetailInfo;
import com.learning.batch.springbatch.dto.LoanRequest;
import com.learning.batch.springbatch.service.LoanService;

@RestController
@RequestMapping("/customers")
public class CustomerLoanController {
	
	@Autowired
	LoanService loanService;

   @PostMapping("/{customerId}/loan")
   public ResponseEntity<LoanDetailInfo> applyLoan(@Valid @RequestBody LoanRequest loanRequest, @PathVariable String customerId ){
	   
	   LoanDetailInfo loanDetailInfo = loanService.applyLoan(loanRequest,customerId);
	   return new ResponseEntity<LoanDetailInfo>(loanDetailInfo, HttpStatus.CREATED);
	   
	   
   }
	
}
