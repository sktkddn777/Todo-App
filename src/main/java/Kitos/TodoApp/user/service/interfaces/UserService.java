package Kitos.TodoApp.user.service.interfaces;

import Kitos.TodoApp.user.dto.request.SignUpDto;
import Kitos.TodoApp.user.dto.response.UserResDto;

public interface UserService {
    UserResDto create(SignUpDto dto);
}
