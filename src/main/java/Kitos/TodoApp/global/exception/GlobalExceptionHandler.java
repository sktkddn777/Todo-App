package Kitos.TodoApp.global.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(value = { CustomException.class })
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected MethodError methodException(MethodArgumentNotValidException e) {
        log.error("methodException throw MethodArgumentNotValidException");
        return new MethodError(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @Data
    @AllArgsConstructor
    class MethodError {
        private String message;
    }
}
