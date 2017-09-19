package com.botfactory.factory.controllers.user;

import com.botfactory.factory.BotFactory;
import com.botfactory.factory.controllers.AbstractRestControllerTest;
import com.botfactory.factory.model.User;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AdminRestControllerTest extends AbstractRestControllerTest {

    RestTemplate restTemplate = new RestTemplate();

//    @Test
//    public void contextLoads() {
//    }

    @Test
    public void anotherGetAllTest() throws Exception {
        mockMvc.perform(get(AdminRestController.REST_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getAllTest() throws Exception {
        mockMvc.perform(get(AdminRestController.REST_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));


        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange("http://localhost:8080/rest/admin/users", HttpMethod.GET,
                        null, new ParameterizedTypeReference<List<User>>() {
                        });
        List<User> actualList = responseEntity.getBody();
        assertThat(actualList.size(), is(2));
    }

}