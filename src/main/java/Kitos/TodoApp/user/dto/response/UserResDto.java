package Kitos.TodoApp.user.dto.response;

import Kitos.TodoApp.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserResDto {
    Long id;
    String name;

    public UserResDto (User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
