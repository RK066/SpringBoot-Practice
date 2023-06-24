package com.practice.internship;

public class Students {
    private String id;
    private String name;
    private String domain;
    private String guide;

    public Students(String id,String name,String domain,String guide){
        this.id=id;
        this.name=name;
        this.domain=domain;
        this.guide=guide;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    
}
