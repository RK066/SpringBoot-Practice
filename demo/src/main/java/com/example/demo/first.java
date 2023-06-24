package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class first {
    
    @RequestMapping("/greet/")
    public String greet(){
        for(int i=0;i<10;i++){
            System.out.println(i);
        }
        return "Hello";
    }

    @RequestMapping(value = "/ex/doThis/",method = RequestMethod.GET)
    public void greet2(){
        for(int i=0;i<10;i++){
            System.out.println("Hello");
        }
    }
}
