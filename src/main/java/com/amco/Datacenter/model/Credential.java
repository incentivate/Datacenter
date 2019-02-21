package com.amco.Datacenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    private FisicHost fisicHost;

    private String user;
    private String password;
    private String notes;
    private String role;

    public Credential(){

    }

    public Credential(int id, FisicHost fisicHost, String user, String password, String notes, String role) {
        this.id = id;
        this.fisicHost = fisicHost;
        this.user = user;
        this.password = password;
        this.notes = notes;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FisicHost getFisicHost() {
        return fisicHost;
    }

    public void setFisicHost(FisicHost fisicHost) {
        this.fisicHost = fisicHost;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
