package com.project.xml2Json;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "x2j", schema = "data")
public class data {
    
    @Id
    private String SrNo;
    private String name;
    private String d;

    

    public data() {
        SrNo=UUID.randomUUID().toString();
        name="null";
        d="null";
    }
    public data(String srNo, String name, String d) {
        SrNo = srNo;
        this.name = name;
        this.d = d;
    }
    public String getSrNo() {
        return SrNo;
    }
    public void setSrNo(String srNo) {
        SrNo = srNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getD() {
        return d;
    }
    public void setD(String d) {
        this.d = d;
    }

    
}
