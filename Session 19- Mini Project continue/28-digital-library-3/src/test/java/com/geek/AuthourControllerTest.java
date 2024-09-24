package com.geek;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geek.entity.Authour;
import com.geek.service.BookService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(AuthourControllerTest.class)
public class AuthourControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    private Authour authour;

    @BeforeEach
    void setUp() {
        authour = new Authour();
        authour.setName("John Doe");
       // authour.setNationality("American");
        // set other fields as needed
    }

    @Test
    void testAddNewAuthour() throws Exception {
        // Mock the behavior of the service
        when(bookService.addAuthour(any(Authour.class))).thenReturn(authour);

        // Perform the POST request and verify the response
        mockMvc.perform(post("/api/books/authour")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(authour)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(authour)));
    }
}