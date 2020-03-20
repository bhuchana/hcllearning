package com.learning.batch.springbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.batch.springbatch.model.CustomerLoan;

@Repository
public interface LoanRepository extends JpaRepository<CustomerLoan, Long> {

}
