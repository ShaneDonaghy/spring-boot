package com.shep.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class readController {

    @Autowired
    public PersonRepository personRepository;

    Optional<Person> result;

    @PostMapping("/read")
    public String readFromDb(@ModelAttribute Person person, Model model){
        result = personRepository.findById(person.getPpsNo());
        model.addAttribute(result);
        return "read";
    }
}
