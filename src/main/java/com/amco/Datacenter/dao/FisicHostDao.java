package com.amco.Datacenter.dao;

import com.amco.Datacenter.model.FisicHost;

import java.util.List;

public interface FisicHostDao {

    List<FisicHost> getAllFisicHosts();
    FisicHost findById(int id);
    FisicHost getFisicHostByName(String name);
    FisicHost getFisicHostById(int id);
    FisicHost getFisicHostByIp(String ip);
    void save(FisicHost fisicHost);
    void update(FisicHost fisicHost);
    void delete(FisicHost fisicHost);
    void deleteAllCredentialsByFisicHost(FisicHost fisicHost);
}
