package com.shep.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class deleteController {

    @Autowired
    public PersonRepository personRepository;

    @PostMapping("/delete")
    public String deleted(@ModelAttribute Person person){
        personRepository.deleteById(person.getPpsNo());
        return "deleted";
    }
}
