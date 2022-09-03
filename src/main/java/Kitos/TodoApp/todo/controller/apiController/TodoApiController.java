package Kitos.TodoApp.todo.controller.apiController;


import Kitos.TodoApp.todo.dto.request.CreateTodoReqDto;
import Kitos.TodoApp.todo.dto.response.TodoResDto;
import Kitos.TodoApp.todo.service.interfaces.TodoService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoApiController {

  private final TodoService todoService;

  @PostMapping // TODO: 유효성검사, 인가
  public ResponseEntity<?> createTodo(@RequestBody CreateTodoReqDto dto) {
    TodoResDto todo = todoService.createTodo(dto);

    // new ResponseEntity(todo, HttpStatus.CREATED)도 가능
    return ResponseEntity.status(HttpStatus.CREATED).body(todo);
  }
}
