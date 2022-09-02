package Kitos.TodoApp.todo.domain;

import Kitos.TodoApp.global.BaseTimeEntity;
import Kitos.TodoApp.user.domain.User;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@Entity
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

    @NotNull
    private boolean isTodo;

    @NotNull
    private boolean isActive;

    public Todo(String content) {
        this.content = content;
    }
}