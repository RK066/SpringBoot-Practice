package com.practice.internship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InfoService {
    private List<Students> list=Arrays.asList(
            new Students("1", "First", "not decided", "Someone"),
            new Students("2", "Second", "will be decided", "Anotherone"),
            new Students("3", "Third", "Forgetten", "Nevermind"),
            new Students("4", "Fourth", "Not Again", "error"));
    private ArrayList<Students> arrayList=new ArrayList<>(list);

    public List<Students> getStudents() {
        return list;
    }

    public Students getstudent(String id) {
        return list.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addStudent(Students body) {
        arrayList.add(body);
        list=arrayList;
    }

    public void delStudent(String id) {
        arrayList.removeIf(t -> t.getId().equals(id));
    }
}
