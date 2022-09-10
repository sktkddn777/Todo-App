package Kitos.TodoApp.todo.controller.apiController;


import Kitos.TodoApp.todo.domain.Todo;
import Kitos.TodoApp.todo.dto.request.CreateTodoReqDto;
import Kitos.TodoApp.todo.dto.response.TodoResDto;
import Kitos.TodoApp.todo.service.interfaces.TodoService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoApiController {

  private final TodoService todoService;

  @PostMapping // TODO: 유효성검사, 인가
  public ResponseEntity<TodoResDto> createTodo(@RequestBody CreateTodoReqDto dto) {
    TodoResDto todo = todoService.createTodo(dto);

    // new ResponseEntity(todo, HttpStatus.CREATED)도 가능
    return ResponseEntity.status(HttpStatus.CREATED).body(todo);
  }

  @GetMapping
  public Page<Todo> getAllTodo(Pageable pageable) {
//    return StandardResponse.builder()
//            .message("get All done")
//            .data(Map.of("todos", todoService.getAllTodo(pageable).orElseThrow()))
//            .build();
    return todoService.getAllTodo(pageable).orElseThrow();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<TodoResDto> doneTodo(@PathVariable Long id) {
    TodoResDto todo = todoService.doneTodo(id);
    return ResponseEntity.ok().body(todo);
  }
}
