package Kitos.TodoApp.todo.domain;

import Kitos.TodoApp.global.BaseTimeEntity;
import Kitos.TodoApp.global.exception.AlreadyDoneTodoException;
import Kitos.TodoApp.user.domain.User;

import com.sun.istack.NotNull;

import lombok.*;

import javax.persistence.*;

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
        if(this.isDone)
            throw new AlreadyDoneTodoException();
        this.isDone = true;
    }
}
