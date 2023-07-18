package com.edstem.book.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter

public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String details;
	
	public ErrorDetails(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}


	

}
