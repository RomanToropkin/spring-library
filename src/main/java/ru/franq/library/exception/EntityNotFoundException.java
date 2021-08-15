package ru.franq.library.exception;

import java.util.function.Supplier;

public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
