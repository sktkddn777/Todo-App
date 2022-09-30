package Kitos.TodoApp.user.service;

import Kitos.TodoApp.global.exception.CustomException;
import Kitos.TodoApp.user.domain.User;
import Kitos.TodoApp.user.domain.repository.UserRepository;
import Kitos.TodoApp.user.dto.request.SignUpDto;
import Kitos.TodoApp.user.dto.response.UserResDto;
import Kitos.TodoApp.user.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static Kitos.TodoApp.global.exception.ErrorCode.ALREADY_EXISTS_EMAIL;
import static Kitos.TodoApp.global.exception.ErrorCode.ALREADY_EXISTS_NAME;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResDto create(SignUpDto dto) {
        //TODO: 비밀번호, 비밀번호 확인 일치하는지 로직
        User user = SignUpDto.toEntity(dto);

        Optional<User> foundUserByName = userRepository.findByName(user.getName());
        if(foundUserByName.isPresent())
            throw new CustomException(ALREADY_EXISTS_NAME);

        Optional<User> foundUserByEmail = userRepository.findByEmail(user.getEmail());
        if(foundUserByEmail.isPresent())
            throw new CustomException(ALREADY_EXISTS_EMAIL);

        //TODO: 비밀번호 암호화
        User newUser = userRepository.save(user);

        return new UserResDto(newUser);
    }
}
