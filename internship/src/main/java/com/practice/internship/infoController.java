package com.practice.internship;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class infoController {

    private InfoService infoService=new InfoService();
    
    @RequestMapping("/allinfo")
    public List<Students> getStudents(){
        return infoService.getStudents();
    }

    @RequestMapping("/allinfo/{id}")
    public Students getStudent(@PathVariable String id){
        return infoService.getstudent(id);
    }

    @PostMapping("/allinfo/add")
    public void addStudent(@RequestBody Students serverRequest){
        try {
            infoService.addStudent(serverRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/allinfo/del/{id}")
    public Students delStudent(@PathVariable String id){
        return infoService.delStudent(id);
    }

    @PutMapping("/allinfo/update")
    public Students uStudent(@RequestBody Students s){
        return infoService.uStudent(s);
    }
}
