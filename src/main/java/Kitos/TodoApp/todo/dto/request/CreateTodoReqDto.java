package Kitos.TodoApp.todo.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateTodoReqDto {
  private String content;
}
