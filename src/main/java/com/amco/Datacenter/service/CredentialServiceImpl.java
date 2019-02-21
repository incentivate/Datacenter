package com.amco.Datacenter.service;

import com.amco.Datacenter.dao.CredentialDao;
import com.amco.Datacenter.model.Credential;
import com.amco.Datacenter.model.FisicHost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialServiceImpl implements CredentialService {

    @Autowired
    private CredentialDao credentialDao;

    @Override
    public List<Credential> getAllCredentialsByFisicHost(FisicHost fisicHost) {
        return credentialDao.getAllCredentialsByFisicHost(fisicHost);
    }

    @Override
    public Credential getCredentialByUser(String user) {
        return credentialDao.getCredentialByUser(user);
    }

    @Override
    public Credential getCredentialById(int id) {
        return credentialDao.getCredentialById(id);
    }

    @Override
    public void save(Credential credential) {
        credentialDao.save(credential);
    }

    @Override
    public void update(Credential credential) {
        credentialDao.update(credential);
    }

    @Override
    public void delete(Credential credential) {
        credentialDao.delete(credential);
    }

}
