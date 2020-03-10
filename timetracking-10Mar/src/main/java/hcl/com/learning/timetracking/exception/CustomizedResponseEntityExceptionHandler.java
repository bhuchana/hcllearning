package hcl.com.learning.timetracking.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	private String BAD_REQUEST = "BAD_REQUEST";
	
	 @ExceptionHandler(Exception.class)
	  public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),ex.getLocalizedMessage());
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }

	  @ExceptionHandler(EmployeeNotFoundException.class)
	  public final ResponseEntity<ExceptionResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),ex.getLocalizedMessage());
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	  }
	 
	  @Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
		  ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
	        ex.getMessage());
	    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	  } 
	  
	  

}
