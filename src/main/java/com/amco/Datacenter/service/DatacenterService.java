package com.amco.Datacenter.service;

import com.amco.Datacenter.model.Datacenter;
import com.amco.Datacenter.model.FisicHost;

import java.util.List;

public interface DatacenterService {

    List<Datacenter> getAllDatacenters();
    Datacenter getDatacenterByName(String name);
    Datacenter getDatacenterById(int id);
    void save(Datacenter datacenter);
    void update(Datacenter datacenter);
    void delete(Datacenter datacenter);

}
