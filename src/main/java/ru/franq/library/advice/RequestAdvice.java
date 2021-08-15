package ru.franq.library.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.franq.library.dto.ErrorDTO;
import ru.franq.library.exception.NotEnoughParamsException;

@RestControllerAdvice
public class RequestAdvice {

    @ExceptionHandler(NotEnoughParamsException.class)
    public ResponseEntity<ErrorDTO> handleNotEnoughParamsException(NotEnoughParamsException e) {
        return new ResponseEntity<>(new ErrorDTO(e.getMessage(),
                HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

}
