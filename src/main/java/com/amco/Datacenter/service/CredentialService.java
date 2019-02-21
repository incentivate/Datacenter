package com.amco.Datacenter.service;

import com.amco.Datacenter.model.Credential;
import com.amco.Datacenter.model.FisicHost;

import java.util.List;

public interface CredentialService {

    List<Credential> getAllCredentialsByFisicHost(FisicHost fisicHost);
    Credential getCredentialByUser(String user);
    Credential getCredentialById(int id);
    void save(Credential credential);
    void update(Credential credential);
    void delete(Credential credential);
}
