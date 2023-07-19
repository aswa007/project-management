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
	

	}


	


