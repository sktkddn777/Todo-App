package Kitos.TodoApp.todo.domain;

import Kitos.TodoApp.global.exception.CustomException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static Kitos.TodoApp.global.exception.ErrorCode.ALREADY_DONE_TODO;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TodoTest {

    @Test
    public void 미완료_Todo라면_완료처리(){
        //given
        Todo todo = Todo.builder()
                .isDone(false)
                .content("테스트")
                .build();

        //when
        todo.doneTodo();

        //then
        assertThat(todo.isDone()).isEqualTo(true);
    }

    @Test
    public void 이미_완료된_Todo라면_예외발생(){
        //given
        Todo todo = Todo.builder()
                .isDone(true)
                .content("테스트")
                .build();

        //when
        CustomException e = assertThrows(CustomException.class, () -> todo.doneTodo());

        //then
        assertThat(e.getErrorCode()).isEqualTo(ALREADY_DONE_TODO);
    }
}


