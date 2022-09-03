package Kitos.TodoApp.todo.dto.response;

import Kitos.TodoApp.todo.domain.Todo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class TodoResDto {
  private Long id;
  private String content;
  private Boolean isDone; // boolean 타입 사용하면 jackson 라이브러리 때문에 done으로 바뀜

  private LocalDateTime createdAt;

  public TodoResDto (Todo entity) {
    this.id = entity.getId();
    this.content = entity.getContent();
    this.isDone = entity.isDone();
    this.createdAt = entity.getCreatedAt();
  }
}
