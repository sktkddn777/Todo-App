package Kitos.TodoApp.global.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
public class StandardResponse {
    String message;
    Map<String, Object> data;
}
