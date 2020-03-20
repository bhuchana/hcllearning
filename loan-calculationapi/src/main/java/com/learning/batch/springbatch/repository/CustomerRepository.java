package com.learning.batch.springbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.batch.springbatch.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
