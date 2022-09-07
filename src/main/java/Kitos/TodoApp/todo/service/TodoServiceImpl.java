package Kitos.TodoApp.todo.service;

import Kitos.TodoApp.todo.domain.Todo;
import Kitos.TodoApp.todo.domain.repository.TodoRepository;
import Kitos.TodoApp.todo.dto.request.CreateTodoReqDto;
import Kitos.TodoApp.todo.dto.response.TodoResDto;
import Kitos.TodoApp.todo.service.interfaces.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

  public Optional<Page<Todo>> getAllTodo(Pageable pageable) {

    return Optional.of(todoRepository.findAll(pageable));
  }
}