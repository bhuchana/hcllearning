package com.learning.batch.springbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.batch.springbatch.model.EmiDetail;

@Repository
public interface EMIRepository extends JpaRepository<EmiDetail, Long> {

}
