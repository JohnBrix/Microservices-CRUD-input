package com.example.observable.mapper;

import com.example.observable.dto.Dto;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class PersonMapper {


    public Map dtoToDtoSave(Dto dto){
        Map<String, Object> map = new HashMap<>();
        map.put("firstName", dto.getFirstName());
        map.put("lastName", dto.getLastName());
        map.put("birthDate", dto.getBirthDate());
        map.put("age", dto.getAge());
        map.put("address", dto.getAddress());
        map.put("dateCreated", new Date(System.currentTimeMillis()));
        return map;
    }
    public Map dtoToDtoUpdate(Dto dto){
        Map<String, Object> map = new HashMap<>();
        map.put("id",dto.getId());
        map.put("firstName", dto.getFirstName());
        map.put("lastName", dto.getLastName());
        map.put("birthDate", dto.getBirthDate());
        map.put("age", dto.getAge());
        map.put("address", dto.getAddress());
        return map;
    }
}
