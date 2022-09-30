package Kitos.TodoApp.user.domain;

import Kitos.TodoApp.global.BaseTimeEntity;
import Kitos.TodoApp.todo.domain.Todo;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column(length = 20)
    private String name;

    private String email;

    private String password;

    @NotNull
    @Enumerated(EnumType.STRING) // enum 이름을 DB에 저장
    private Provider providerType;

    @NotNull
    //@Column(unique = true)
    private String providerId;

    @OneToMany(mappedBy = "user")
    private List<Todo> todos = new ArrayList<>();
}