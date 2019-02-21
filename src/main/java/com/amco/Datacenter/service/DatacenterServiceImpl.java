package com.amco.Datacenter.service;

import com.amco.Datacenter.dao.DatacenterDao;
import com.amco.Datacenter.model.Datacenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatacenterServiceImpl implements DatacenterService {

    @Autowired
    private DatacenterDao datacenterDao;

    @Override
    public List<Datacenter> getAllDatacenters() {
        return datacenterDao.getAllDatacenters();
    }

    @Override
    public Datacenter getDatacenterByName(String name) {
        return datacenterDao.getDatacenterByName(name);
    }

    @Override
    public Datacenter getDatacenterById(int id) {
        return datacenterDao.getDatacenterById(id);
    }

    @Override
    public void save(Datacenter datacenter) {
        datacenterDao.save(datacenter);
    }

    @Override
    public void update(Datacenter datacenter) {
        datacenterDao.update(datacenter);
    }

    @Override
    public void delete(Datacenter datacenter) {
        datacenterDao.delete(datacenter);
    }



}
