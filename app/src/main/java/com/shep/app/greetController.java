package com.shep.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class greetController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/greet")
    public String greetPage(Model model){
        model.addAttribute("person", new Person());
        return "greet";
    }

    /*
    @PostMapping("/greet")
    public String getNames(@ModelAttribute Person person){
        return "greetings";
    }
     */

    @PostMapping("/greet")
    public void writePersonToDb(@ModelAttribute Person person){
        personRepository.save(person);
    }

    @DeleteMapping("/greet")
    public void deletePersonFromDb(@ModelAttribute Person person){
        personRepository.deleteById(person.getPpsNo());
    }

}
