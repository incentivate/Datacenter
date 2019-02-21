package com.amco.Datacenter.dao;

import com.amco.Datacenter.model.Datacenter;

import java.util.List;

public interface DatacenterDao {

    List<Datacenter> getAllDatacenters();
    Datacenter getDatacenterByName(String name);
    Datacenter getDatacenterById(int id);
    void save(Datacenter datacenter);
    void update(Datacenter datacenter);
    void delete(Datacenter datacenter);
}
