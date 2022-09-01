package Kitos.TodoApp.todo.domain;

import Kitos.TodoApp.global.BaseTimeEntity;
import Kitos.TodoApp.user.domain.User;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
public class Todo extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "todo_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private String content;

    private boolean isTodo;

    @NotNull
    private boolean isActive;

    public Todo(String content) {
        this.content = content;
    }
}