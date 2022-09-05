package Kitos.TodoApp.todo.service.interfaces;

import Kitos.TodoApp.todo.dto.request.CreateTodoReqDto;
import Kitos.TodoApp.todo.dto.response.TodoResDto;

public interface TodoService {

  TodoResDto createTodo(CreateTodoReqDto dto);

}
