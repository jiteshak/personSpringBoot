package com.te.springbootmockito.response;

import java.time.LocalDateTime;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.http.HttpStatus;

import com.te.springbootmockito.entity.dto.PersonDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GenralResponse {

	private HttpStatus status;
	private String error;
	private String message;
	private LocalDateTime timestamp = LocalDateTime.now();
	private Object object;
	
	public GenralResponse(HttpStatus status, String error, String message, Object object) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
		this.object = object;
	}
}
