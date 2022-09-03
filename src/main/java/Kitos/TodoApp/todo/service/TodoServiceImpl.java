package Kitos.TodoApp.todo.service;

import Kitos.TodoApp.todo.domain.Todo;
import Kitos.TodoApp.todo.domain.repository.TodoRepository;
import Kitos.TodoApp.todo.dto.request.CreateTodoReqDto;
import Kitos.TodoApp.todo.dto.response.TodoResDto;
import Kitos.TodoApp.todo.service.interfaces.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoServiceImpl implements TodoService {

  private final TodoRepository todoRepository;

  @Transactional
  public TodoResDto createTodo(CreateTodoReqDto dto) {

    Todo todo = CreateTodoReqDto.toEntity(dto);

    Todo newTodo = todoRepository.save(todo);

    return new TodoResDto(newTodo);
  }
}
