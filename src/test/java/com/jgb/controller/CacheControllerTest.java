package com.jgb.controller;

import com.jgb.domain.books.stephenKing.StephenKingBook;
import com.jgb.usecase.GetStephenKingBooksUsecase;
import com.jgb.usecase.RefreshStephenKingBooksUsecase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CacheController.class)
public class CacheControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetStephenKingBooksUsecase getStephenKingBooksUsecase;
    @MockBean
    private RefreshStephenKingBooksUsecase refreshStephenKingBooksUsecase;

    @Test
    void tryToGetBooks_whenWrongHttpMethod_thenReturnNotFound() throws Exception {
        mockMvc.perform(post("/books"))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    void tryToGetBooks_whenValidHttpMethod_thenReturnBooks() throws Exception {

        List<StephenKingBook> books = Collections.emptyList();

        when(getStephenKingBooksUsecase.execute()).thenReturn(books);

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}
