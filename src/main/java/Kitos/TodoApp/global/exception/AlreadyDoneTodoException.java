package Kitos.TodoApp.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AlreadyDoneTodoException extends ResponseStatusException {
    public AlreadyDoneTodoException() {
        super(HttpStatus.CONFLICT, "already done todo.");
    }
}
