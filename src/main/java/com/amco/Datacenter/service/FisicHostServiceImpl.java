package com.amco.Datacenter.service;

import com.amco.Datacenter.dao.CredentialDao;
import com.amco.Datacenter.dao.FisicHostDao;
import com.amco.Datacenter.model.FisicHost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FisicHostServiceImpl implements FisicHostService {

    @Autowired
    private FisicHostDao fisicHostDao;

    @Override
    public List<FisicHost> getAllFisicHosts() {
        return fisicHostDao.getAllFisicHosts();
    }

    @Override
    public FisicHost getFisicHostByName(String name) {
        return fisicHostDao.getFisicHostByName(name);
    }

    @Override
    public FisicHost getFisicHostById(int id) {
        return fisicHostDao.getFisicHostById(id);
    }

    @Override
    public FisicHost getFisicHostByIp(String ip) {
        return fisicHostDao.getFisicHostByIp(ip);
    }

    @Override
    public void save(FisicHost fisicHost) {
        fisicHostDao.save(fisicHost);
    }

    @Override
    public void update(FisicHost fisicHost) {
        fisicHostDao.update(fisicHost);
    }

    @Override
    public void delete(FisicHost fisicHost) {
        fisicHostDao.delete(fisicHost);
    }

    @Override
    public void deleteAllCredentialsByFisicHost(FisicHost fisicHost) {
        fisicHostDao.deleteAllCredentialsByFisicHost(fisicHost);
    }

}
