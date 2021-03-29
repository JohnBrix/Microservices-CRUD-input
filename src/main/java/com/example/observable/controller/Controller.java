package com.example.observable.controller;

import com.example.observable.dto.Dto;
import com.example.observable.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fetch")
@CrossOrigin(origins = {"http://localhost:6969",}, maxAge = 3000)
public class Controller {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpHeaders headers;
   /* @Autowired
    private String uri;*/
    @Autowired
    private PersonMapper personMapper;
  /*  @Autowired
    private String uriDelete;*/

    @GetMapping("/getPersons")
    public List<Dto> getPersons() {
        return this.restTemplate.getForObject("http://localhost:8081/api/person", List.class);
    }
    @PostMapping("/createPerson")
    public Dto createPerson(@RequestBody @Valid Dto dto) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        var model = personMapper.dtoToDtoSave(dto);

        //HttpEntity<Map<String, Object>> entity
        var entity = new HttpEntity(model, headers);
        //ResponseEntity<Dto>
        var response = this.restTemplate.postForEntity("http://localhost:8081/api/person", entity, Dto.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @PutMapping("/updatePerson")
    public Map updatePerson(@RequestBody @Valid Dto dto) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        //Map model
        var model = personMapper.dtoToDtoUpdate(dto);
        //HttpEntity<Map<String, Object>>
        var entity = new HttpEntity(model, headers);
        this.restTemplate.put("http://localhost:8081/api/person", entity, dto.getId());
        return model;
    }

    //actual:
    /*"http://localhost:8081/api/person?id="+id;*/
    @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity deletePerson(@PathVariable Integer id) {
        this.restTemplate.delete("http://localhost:8081/api/person/"+id);
        return new ResponseEntity("Successfully deleted Id: " + id, HttpStatus.OK);
    }


}
