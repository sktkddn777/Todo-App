package Kitos.TodoApp.todo.domain;

import Kitos.TodoApp.global.BaseTimeEntity;
import Kitos.TodoApp.global.exception.CustomException;
import Kitos.TodoApp.user.domain.User;

import com.sun.istack.NotNull;

import lombok.*;

import javax.persistence.*;

import static Kitos.TodoApp.global.exception.ErrorCode.ALREADY_DONE_TODO;
import static Kitos.TodoApp.global.exception.ErrorCode.TODO_NOT_FOUND;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Todo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private String content;

    @NotNull
    private boolean isDone;

    @NotNull
    private boolean isActive;

    public void doneTodo() {
        if(!this.isActive)
            throw new CustomException(TODO_NOT_FOUND);
        if(this.isDone)
            throw new CustomException(ALREADY_DONE_TODO);
        this.isDone = true;
    }

    public void disabledTodo(){
        if(!this.isActive)
            throw new CustomException(TODO_NOT_FOUND);
        this.isActive = false;
    }
}
