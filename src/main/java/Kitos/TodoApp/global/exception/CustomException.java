package Kitos.TodoApp.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{

    private ErrorCode errorCode;

    public CustomException(ErrorCode errorCode, String errorMessage) {
        super(errorMessage); // 기존 에러의 메시지를 상위 객체에 넘겨주는걸까요?
        this.errorCode = errorCode;
    }
}
