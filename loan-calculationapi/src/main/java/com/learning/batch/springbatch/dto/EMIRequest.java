package com.learning.batch.springbatch.dto;

import javax.validation.constraints.NotNull;

public class EMIRequest {
	
	@NotNull
	private Double amiAmount;

	public Double getAmiAmount() {
		return amiAmount;
	}

	public void setAmiAmount(Double amiAmount) {
		this.amiAmount = amiAmount;
	}

}
