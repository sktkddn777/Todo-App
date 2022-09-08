package Kitos.TodoApp.todo.service;

import Kitos.TodoApp.global.exception.NotFoundException;
import Kitos.TodoApp.todo.domain.repository.TodoRepository;
import Kitos.TodoApp.todo.service.interfaces.TodoService;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TodoServiceDoneTodoTest {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;

    // TODO : 엔티티 로직 테스트도 서비스에서 하는게 맞는지?
    @Test
    public void id에_해당하는_Todo가_없다면_NotFoundException_발생(){
        // given
        Long testId = 1L;

        // when
        todoService.doneTodo(testId);
        NotFoundException e = assertThrows(NotFoundException.class, () ->
                todoService.doneTodo(testId)
                );

        // then
        assertThat(e.getClass()).isExactlyInstanceOf(NotFoundException.class);
        assertThat(e.getMessage()).isEqualTo("not exists todo id : " + testId);
    }

}