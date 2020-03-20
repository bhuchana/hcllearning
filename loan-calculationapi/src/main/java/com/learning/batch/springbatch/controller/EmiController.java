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

import com.learning.batch.springbatch.dto.EMIRequest;
import com.learning.batch.springbatch.service.EMIService;

@RestController
@RequestMapping("/customers")
public class EmiController {

	@Autowired
	EMIService emiService;
	
	@PostMapping("/{customerId}/emi")
	public ResponseEntity<String> payMonthlyEMi(@Valid @RequestBody EMIRequest  emiRequest,@PathVariable String customerId  ) {
		return new ResponseEntity<String>(emiService.payMonthlyEMi(emiRequest, customerId), HttpStatus.OK) ;
	}
}
