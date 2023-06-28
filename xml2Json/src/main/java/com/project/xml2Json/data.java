package com.project.xml2Json;

import java.time.OffsetDateTime;
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
    private OffsetDateTime creating_Date_Time;


    public data() {
        SrNo=UUID.randomUUID().toString();
        name="null";
        d="null";
        creating_Date_Time=OffsetDateTime.now();
    }
    public data(String srNo, String name, String d,OffsetDateTime cOffsetDateTime) {
        SrNo = srNo;
        this.name = name;
        this.d = d;
        this.creating_Date_Time=cOffsetDateTime;
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
    public OffsetDateTime getCreating_Date_Time() {
        return creating_Date_Time;
    }
    public void setCreating_Date_Time(OffsetDateTime creating_Date_Time) {
        this.creating_Date_Time = creating_Date_Time;
    }
    
}
