package Kitos.TodoApp.todo.controller.apiController;

import Kitos.TodoApp.todo.dto.request.CreateTodoReqDto;
import Kitos.TodoApp.todo.service.interfaces.TodoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@MockBean(JpaMetamodelMappingContext.class)
@WebMvcTest(TodoApiController.class)
class TodoApiControllerTest {

    @Autowired
    private Validator validator;

    @MockBean
    private TodoService todoService;

    @Test
    @DisplayName("Create TODO 유효성 검사")
    void CreateTodoException() throws Exception {
        //given
        CreateTodoReqDto dto = new CreateTodoReqDto("");
        String errorMessage = "빈 값이 들어가면 안됩니다";

        // when
        Set<ConstraintViolation<CreateTodoReqDto>> violations = validator.validate(dto);

        Iterator<ConstraintViolation<CreateTodoReqDto>> iterator = violations.iterator();
        List<String> messages = new ArrayList<>();
        while (iterator.hasNext()) {
            ConstraintViolation<CreateTodoReqDto> next = iterator.next();
            messages.add(next.getMessage());
        }

        // then
        Assertions.assertThat(messages).contains(errorMessage);
    }
}