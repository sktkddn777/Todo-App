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

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoApiController {

  private final TodoService todoService;

  @PostMapping // TODO: 인가
  public ResponseEntity<TodoResDto> createTodo(@RequestBody @Valid CreateTodoReqDto dto) {
    TodoResDto todo = todoService.createTodo(dto);

    // new ResponseEntity(todo, HttpStatus.CREATED)도 가능
    return ResponseEntity.status(HttpStatus.CREATED).body(todo);
  }

  @GetMapping
  public Page<Todo> getAllTodo(Pageable pageable) {
    return todoService.getAllTodo(pageable);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TodoResDto> getDetailTodo(@PathVariable Long id) {
    TodoResDto todo = todoService.getDetailTodo(id);
    return ResponseEntity.ok().body(todo);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<TodoResDto> doneTodo(@PathVariable Long id) {
    TodoResDto todo = todoService.doneTodo(id);
    return ResponseEntity.ok().body(todo);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
    todoService.deleteTodo(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
