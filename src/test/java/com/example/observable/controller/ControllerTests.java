package com.example.observable.controller;

import com.example.observable.dto.Dto;
import com.example.observable.mapper.PersonMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*@RunWith(SpringRunner.class)
@WebMvcTest(value = Controller.class)
*//*@WithMockUser*/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTests {

    @LocalServerPort
    int randomServerPort;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void testGetPersonListExpect200() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:8081/api/person";
        URI uri = new URI(baseUrl);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        System.out.println("resultList: " + result.getBody());
        System.out.println("status code: " + result.getStatusCode());
    }

    @Test
    public void testSavePerson() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8081/api/person";
        URI uri = new URI(baseUrl);
        Dto dto = new Dto();
        dto.setFirstName("Unit mo");
        dto.setLastName("UnitTest");
        dto.setAge(1);
        var cal = Calendar.getInstance();
        cal.set(1999, Calendar.FEBRUARY, 17);
        dto.setBirthDate(cal.getTime());
        dto.setAddress("dadda");
        dto.setDateCreated(new Date(System.currentTimeMillis()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Dto> request = new HttpEntity<>(dto, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        System.out.println("status code: " + result.getStatusCode());
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    @Rollback(false)
    public void testUpdatePerson() {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8081/api/person";

        //dto
        Dto dto = new Dto();
        Integer id = 1;
        dto.setId(id);
        dto.setFirstName("abdul");
        dto.setLastName("as");
        dto.setAge(1);
        var cal = Calendar.getInstance();
        cal.set(1999, Calendar.FEBRUARY, 17);
        dto.setBirthDate(cal.getTime());
        dto.setAddress("dadda");
        dto.setDateCreated(new Date(System.currentTimeMillis()));

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Dto> request = new HttpEntity<>(dto, headers);

        ResponseEntity update = restTemplate.exchange(baseUrl, HttpMethod.PUT, request, Dto.class);
        System.out.println("status code: "+update.getStatusCode());
        assertEquals(200,update.getStatusCodeValue());
    }
    @Test
    public void testDeletePerson() {
        RestTemplate restTemplate = new RestTemplate();
        final String deleteUrl = "http://localhost:8081/api/person/";
        Dto dto = new Dto();
        dto.setId(1);
        restTemplate.delete(deleteUrl+dto.getId());
        assertEquals(HttpStatus.OK, HttpStatus.OK);

    }


}

