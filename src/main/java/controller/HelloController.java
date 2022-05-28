package controller;

import Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/")
    public String fufu(){
        System.out.println(itemRepository.findAll());
        return ("<h1>Welcome home</h1>");
    }


    @GetMapping("/hello")
    public String admin(){
        System.out.println(itemRepository.findAll());
        System.out.println("Howle Raj");
        return ("<h1>Welcome admin</h1>");
    }

}
