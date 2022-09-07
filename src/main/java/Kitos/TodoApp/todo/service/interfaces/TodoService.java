package Kitos.TodoApp.todo.service.interfaces;

import Kitos.TodoApp.todo.domain.Todo;
import Kitos.TodoApp.todo.dto.request.CreateTodoReqDto;
import Kitos.TodoApp.todo.dto.response.TodoResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TodoService {

  TodoResDto createTodo(CreateTodoReqDto dto);

  Optional<Page<Todo>> getAllTodo(Pageable pageable);

  TodoResDto doneTodo(Long id);
}
