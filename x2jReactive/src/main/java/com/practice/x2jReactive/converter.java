package com.practice.x2jReactive;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
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

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
            System.out.println(e.getMessage());
        }

    }

    @GetMapping("/ex/show")
    public Flux<data> gData(){
        final var d=dRepo.findAll();
        return d;
    }

    @GetMapping("/ex/show/{name}")
    public Mono<data> gData(@PathVariable String name){
        return dRepo.findByName(name+".xml");
    }

    @GetMapping("/ex/show/count")
    public Mono<Long> gCount(){
        return dRepo.count();
    }

    @DeleteMapping("/ex/del/{name}")
    public void delData(@PathVariable String name){
        dRepo.findByName(name).subscribe(t -> dRepo.deleteById(t.getSrNo()));
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
            System.out.println(f);
            if(dRepo.existsByName(f).block().booleanValue())   {dRepo.findByName(f).subscribe(t -> sdata(new data(t.getSrNo(), f, d, t.getCreating_Date_Time())));}
            else                                {a=new data(UUID.randomUUID().toString(), f, d,LocalDateTime.now());sdata(a);}
            
            // a=new data(dRepo.findByName(f).getSrNo(), f, d,dRepo.findByName(f).getCreating_Date_Time());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void sdata(data d){
        try{
            dRepo.save(d);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}



