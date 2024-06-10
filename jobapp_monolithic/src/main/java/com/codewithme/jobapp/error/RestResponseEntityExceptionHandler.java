package com.codewithme.jobapp.error;

//import org.springdoc.api.ErrorMessage;
import com.codewithme.jobapp.Models.ErrorMessage;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<ErrorMessage> companyNotFoundMessage(CompanyNotFoundException companyNotFoundException, WebRequest request){
    ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,companyNotFoundException.getMessage());
     return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<ErrorMessage> reviewNotFoundMessage(ReviewNotFoundException reviewNotFoundException){
        ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,reviewNotFoundException.getMessage());
    return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
