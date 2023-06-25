package com.practice.internship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InfoService {
    private ArrayList<Students> arrayList=new ArrayList<>(Arrays.asList(
            new Students("1", "First", "not decided", "Someone"),
            new Students("2", "Second", "will be decided", "Anotherone"),
            new Students("3", "Third", "Forgetten", "Nevermind"),
            new Students("4", "Fourth", "Not Again", "error")));

    public List<Students> getStudents() {
        return arrayList;
    }

    public Students getstudent(String id) {
        return arrayList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addStudent(Students body) {
        arrayList.add(body);
    }

    public Students delStudent(String id) {
        Students temp=arrayList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        arrayList.remove(temp);
        return temp;
    }

    public Students uStudent(Students s) {
        Students temp=arrayList.stream().filter(t -> t.getId().equals(s.getId())).findFirst().get();
        arrayList.set(arrayList.indexOf(temp), s);
        return temp;
    }
}
