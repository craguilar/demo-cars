package com.cmymesh.service.demo.cars.commons.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cmymesh.service.demo.cars.model.pojo.Error;

/**
 * This class is used as an Exception Handling Mechanism for SAPI (CSA Service
 * API Template project) based on common HTTP Exceptions. For more information
 * please visit this
 * <a href= "https://confluence.oraclecorp.com/confluence/x/nAXTPg"> link</a>
 * 
 * @author caruruiz
 *
 */
@ControllerAdvice
public class ApiExceptionHandler {

  private Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<Error> handleException(BadRequestException ex) {
    return buildResponseEntity("400", ex.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(InternalServerErrorException.class)
  public ResponseEntity<Error> handleException(InternalServerErrorException ex) {
    return buildResponseEntity("500", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Error> handleException(NotFoundException ex) {
    return buildResponseEntity("404", ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ResourceConflictException.class)
  public ResponseEntity<Error> handleException(ResourceConflictException ex) {
    return buildResponseEntity("409", ex.getMessage(), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<Error> handleException(UnauthorizedException ex) {
    return buildResponseEntity("401", ex.getMessage(), HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler({ Exception.class })
  public ResponseEntity<Error> handleAll(Exception ex) {
    log.error("", ex);
    return buildResponseEntity("500", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ResponseEntity<Error> buildResponseEntity(String code, String message, HttpStatus status) {
    Error error = new Error();
    error.setCode(code);
    error.setMessage(message);
    return new ResponseEntity<>(error, status);
  }
}