package Kitos.TodoApp.user.domain;

import Kitos.TodoApp.global.BaseTimeEntity;
import Kitos.TodoApp.todo.domain.Todo;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column(length = 20)
    private String name;

    @NotNull
    private String providerType; //TODO: Enum

    @NotNull
    @Column(unique = true)
    private String providerId;

    @OneToMany(mappedBy = "user")
    private List<Todo> todos = new ArrayList<>();
}