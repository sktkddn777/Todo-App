package Kitos.TodoApp.global.exception;

public class AlreadyDoneTodoException extends RuntimeException {
    public AlreadyDoneTodoException(String message) {
        super(message);
    }
}
