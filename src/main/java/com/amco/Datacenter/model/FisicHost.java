package com.amco.Datacenter.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Transactional
public class FisicHost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch=FetchType.EAGER)
    private Datacenter datacenter;

    @OneToMany(mappedBy = "fisicHost")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Credential> credentials;

    private String name;
    private String ip;
    private String operatingSystem;
    private String notes;

    public FisicHost(){

    }

    public FisicHost(int id, Datacenter datacenter, List<Credential> credentials, String name, String ip, String operatingSystem, String notes) {
        this.id = id;
        this.datacenter = datacenter;
        this.credentials = credentials;
        this.name = name;
        this.ip = ip;
        this.operatingSystem = operatingSystem;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Datacenter getDatacenter() {
        return datacenter;
    }

    public void setDatacenter(Datacenter datacenter) {
        this.datacenter = datacenter;
    }

    public List<Credential> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<Credential> credentials) {
        this.credentials = credentials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }




}
