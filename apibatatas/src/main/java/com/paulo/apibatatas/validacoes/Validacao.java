package com.paulo.apibatatas.validacoes;

//Importar Map e HashMap
import java.util.HashMap;
import java.util.Map;

//Importar http, validation, bind, context e servlet
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//fornece um feedback mais interessante e legível às bad requests.

@ControllerAdvice
public class Validacao extends ResponseEntityExceptionHandler{
 
 @Override
 protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
     Map<String, String> errors = new HashMap<>();
     
     ex.getBindingResult().getAllErrors().forEach((error) ->{
         
         String fieldName = ((FieldError) error).getField();
         String message = error.getDefaultMessage();
         errors.put(fieldName, message);
     });
     
     //retorna uma lista de erros contendo a mensagem de aviso para cada.
     return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
 }

}
