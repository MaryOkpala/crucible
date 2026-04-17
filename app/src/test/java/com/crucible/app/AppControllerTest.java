package com.crucible.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homeEndpointReturnsOperational() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.project").value("Crucible"))
               .andExpect(jsonPath("$.status").value("operational"));
    }

    @Test
    public void pipelineEndpointReturnsActive() throws Exception {
        mockMvc.perform(get("/pipeline"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.pipeline").value("active"));
    }
}
