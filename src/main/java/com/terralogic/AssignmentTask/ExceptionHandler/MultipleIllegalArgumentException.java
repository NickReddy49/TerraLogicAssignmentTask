package com.terralogic.AssignmentTask.ExceptionHandler;

import java.util.List;

public class MultipleIllegalArgumentException extends RuntimeException {
    private final List<String> errors;

    public MultipleIllegalArgumentException(List<String> errors) {
        super("Multiple validation errors occurred");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
