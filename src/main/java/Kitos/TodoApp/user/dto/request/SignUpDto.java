package Kitos.TodoApp.user.dto.request;

import Kitos.TodoApp.user.domain.Provider;
import Kitos.TodoApp.user.domain.User;
import lombok.Getter;

@Getter
public class SignUpDto {
    private String name;
    private String email;
    private String password;

    public static User toEntity(SignUpDto dto){
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .providerType(Provider.NORMAL)
                .providerId("NORMAL")
                .build();
    }
}
