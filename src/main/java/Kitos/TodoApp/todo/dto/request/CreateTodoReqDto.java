package Kitos.TodoApp.todo.dto.request;

import Kitos.TodoApp.todo.domain.Todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTodoReqDto {

  @NotBlank(message = "빈 값이 들어가면 안됩니다")
  private String content;

  public static Todo toEntity(CreateTodoReqDto dto){
    return Todo.builder()
            .content(dto.getContent())
            .isDone(false) // TODO : 컬럼 default 값 vs 코드상 설정
            .isActive(true)
            .build();
  }
}
