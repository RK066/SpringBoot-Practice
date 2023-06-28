package com.project.xml2Json;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@RestController
public class converter {

    @Autowired
    private dataRepo dRepo;

    @PostMapping("/ex/conv")
    public void convert(){
        try{
            Stream<Path> stream=Files.list(Paths.get(".\\Files\\"));
            stream.filter(file->!Files.isDirectory(file)).map(Path::getFileName).map(Path::toString).forEach(t -> xtoj(t.replace(".xml", "")));
            stream.close();
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    @GetMapping("/ex/show")
    public Iterable<data> gData(){
        final var d=dRepo.findAll();
        return d;
    }

    @GetMapping("/ex/show/{name}")
    public data gData(@PathVariable String name){
        return dRepo.findByName(name+".xml");
    }

    @GetMapping("/ex/show/count")
    public Long gCount(){
        return dRepo.count();
    }

    @DeleteMapping("/ex/del/{name}")
    public void delData(@PathVariable String name){
        dRepo.deleteById(dRepo.findByName(name).getSrNo());
    }

    @DeleteMapping("/ex/del")
    public void delAll(){
        dRepo.deleteAll();
    }

    public void xtoj(String f){
        try{
            File file=new File(".\\Files\\"+f+".xml");
            String s=new String(Files.readAllBytes(Paths.get(file.toString())));
            JsonNode node =new XmlMapper().readTree(s.getBytes());
            String d= new ObjectMapper().writeValueAsString(node);
            data a;
            if(dRepo.existsByName(f))   {a=new data(dRepo.findByName(f).getSrNo(), f, d,dRepo.findByName(f).getCreating_Date_Time());}
            else                        {a=new data(UUID.randomUUID().toString(), f, d,OffsetDateTime.now());}

            dRepo.save(a);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}



