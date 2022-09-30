package Kitos.TodoApp.todo.controller.apiController;

import Kitos.TodoApp.global.exception.CustomException;
import Kitos.TodoApp.todo.dto.request.CreateTodoReqDto;
import Kitos.TodoApp.todo.service.interfaces.TodoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MockBean(JpaMetamodelMappingContext.class)
@WebMvcTest(TodoApiController.class)
class TodoApiControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private TodoService todoService;

    @Test
    @DisplayName("Create TODO 유효성 검사")
    void CreateTodoException() throws Exception {
        //given
        String emptyContent = "{\"content\":\"\"}";
        // when
        MockHttpServletRequestBuilder request = post("/api/todos")
                .accept(MediaType.APPLICATION_JSON)
                .content(emptyContent)
                .contentType(MediaType.APPLICATION_JSON);
        // then
        mvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));
    }
}