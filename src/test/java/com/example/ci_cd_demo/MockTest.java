package com.example.ci_cd_demo;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class MockTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGreetingEndPoint() throws Exception {
        String name = "Harsh";
        mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,"/greetings/{name}",name))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello " + name + "CI / CD course"));
    }

}
