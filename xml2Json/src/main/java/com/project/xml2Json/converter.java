package com.project.xml2Json;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@RestController
public class converter {

    @Autowired
    private dataRepo dRepo;

    // private String path="C:\\Users\\LENOVO\\Desktop\\Spring boot practice\\Files";

    @RequestMapping("/ex/conv")
    public void convert(){
        try{
            Stream<Path> stream=Files.list(Paths.get(".\\Files\\"));
            stream.filter(file->!Files.isDirectory(file)).map(Path::getFileName).map(Path::toString).forEach(t -> xtoj(t));
            stream.close();
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void xtoj(String f){
        try{
            File file=new File(".\\Files\\"+f);
            String s=new String(Files.readAllBytes(Paths.get(file.toString())));
            JsonNode node =new XmlMapper().readTree(s.getBytes());
            String d= new ObjectMapper().writeValueAsString(node);
            data a;
            if(dRepo.existsByName(f))   {a=new data(dRepo.findByName(f).getSrNo(), f, d);}
            else                        {a=new data(UUID.randomUUID().toString(), f, d);}

            dRepo.save(a);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}



