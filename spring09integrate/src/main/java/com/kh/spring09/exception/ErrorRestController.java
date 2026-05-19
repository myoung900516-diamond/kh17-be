package com.kh.spring09.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice(basePackages = {"com.kh.spring09.restcontroller"})
//@Order(Ordered.HIGHEST_PRECEDENCE)//가장 높은 우선순위 부여
public class ErrorRestController {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> error(Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(500).build();
	}
	@ExceptionHandler(TargetNotfoundException.class)
	public ResponseEntity<String> notFound(Exception e) {
		return ResponseEntity.status(404).build();
//		return ResponseEntity.notFound().build(); //이것도 가능함
	}
	@ExceptionHandler(WhoAreYouException.class)
	public ResponseEntity<String> unauthorize(Exception e) {
		return ResponseEntity.status(401).build();
	}
	@ExceptionHandler(GetOutException.class)
	public ResponseEntity<String> forbidden(Exception e) {
		return ResponseEntity.status(403).build();
	}
}


















