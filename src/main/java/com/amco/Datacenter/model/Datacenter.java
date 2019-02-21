package com.amco.Datacenter.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Transactional
public class Datacenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "datacenter")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<FisicHost> fisicHostList;

    public Datacenter(){

    }

    public Datacenter(int id, String name, List<FisicHost> fisicHostList) {
        this.id = id;
        this.name = name;
        this.fisicHostList = fisicHostList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FisicHost> getFisicHostList() {
        return fisicHostList;
    }

    public void setFisicHostList(List<FisicHost> fisicHostList) {
        this.fisicHostList = fisicHostList;
    }
}
