package com.sprint.saleshistory.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DuplicateRecordException extends RuntimeException{
	
	private String message;
}
