package Kitos.TodoApp.user.controller.apiController;


import Kitos.TodoApp.user.dto.request.SignUpDto;
import Kitos.TodoApp.user.dto.response.UserResDto;
import Kitos.TodoApp.user.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserApiController {

    private final UserService userService;

    @PostMapping("/") //TODO: 유효성검사
    public ResponseEntity<UserResDto> signUp(@RequestBody SignUpDto dto){
        UserResDto user = userService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
