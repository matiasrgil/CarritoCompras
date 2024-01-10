package com.matias.CarritoCompras.Exceptions;

import com.matias.CarritoCompras.Exceptions.Users.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(UserMailDuplicated.class)
    public ResponseEntity<String> handleUserMailDuplicated(UserMailDuplicated exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(PassInvalid.class)
    public ResponseEntity<String> handlePassInvalid(PassInvalid exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(NameInvalid.class)
    public ResponseEntity<String> handleNameInvalid(NameInvalid exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(postal_CodeInvalid.class)
    public ResponseEntity<String> handlepostal_CodeInvalid(postal_CodeInvalid exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(EmailInvalid.class)
    public ResponseEntity<String> handleEmailInvalid(EmailInvalid exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(TelephoneInvalid.class)
    public ResponseEntity<String> handlePhoneInvalid(TelephoneInvalid exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(AgeInvalid.class)
    public ResponseEntity<String> handleAgeInvalid(AgeInvalid exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }


}