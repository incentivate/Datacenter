package com.amco.Datacenter.service;

import com.amco.Datacenter.model.FisicHost;

import java.util.List;

public interface FisicHostService {

    List<FisicHost> getAllFisicHosts();
    FisicHost getFisicHostByName(String name);
    FisicHost getFisicHostById(int id);
    FisicHost getFisicHostByIp(String ip);
    void save(FisicHost fisicHost);
    void update(FisicHost fisicHost);
    void delete(FisicHost fisicHost);
    void deleteAllCredentialsByFisicHost(FisicHost fisicHost);
}
