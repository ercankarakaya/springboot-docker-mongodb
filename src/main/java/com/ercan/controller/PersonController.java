package com.ercan.controller;

import com.ercan.model.Person;
import com.ercan.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping
    public List<Person> getPersons() {
        return personRepository.findAll();
    }
}
