package com.learning.batch.springbatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.learning.batch.springbatch.service.ScheduledJobService;

@Component
public class LoanScheduledTask {
	
	@Autowired
	ScheduledJobService loanService;
	
	@Scheduled(fixedRate = 50000)
	public void performEMIMonthly(){
		System.out.println("runnung");
		loanService.performEmiJob();
	}

}
