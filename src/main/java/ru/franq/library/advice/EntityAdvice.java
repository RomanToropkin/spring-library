package ru.franq.library.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.franq.library.dto.ErrorDTO;
import ru.franq.library.exception.DuplicateEntryException;
import ru.franq.library.exception.EntityNotFoundException;

@RestControllerAdvice
public class EntityAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>(new ErrorDTO(e.getMessage(),
                HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<ErrorDTO> handleDuplicateException(DuplicateEntryException e) {
        return new ResponseEntity<>(new ErrorDTO(e.getMessage(),
                HttpStatus.NOT_ACCEPTABLE.value()), HttpStatus.NOT_ACCEPTABLE);
    }

}
