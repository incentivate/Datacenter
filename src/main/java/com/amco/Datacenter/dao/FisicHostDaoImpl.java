package com.amco.Datacenter.dao;

import com.amco.Datacenter.model.Credential;
import com.amco.Datacenter.model.FisicHost;
import com.amco.Datacenter.service.CredentialService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FisicHostDaoImpl implements FisicHostDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    CredentialService credentialService;

    @Override
    public List<FisicHost> getAllFisicHosts() {
        // Open a session
        Session session = sessionFactory.openSession();

        // Get all FisicHost's with a "Hibernate Criteria Object"
        List<FisicHost> allGustos = session.createCriteria(FisicHost.class).list();

        // Close the session
        session.close();

        return allGustos;
    }

    @Override
    public FisicHost getFisicHostByName(String name) {
        Session session = sessionFactory.openSession();
        FisicHost fisicHost = session.get(FisicHost.class, name);
        session.close();
        return fisicHost;
    }

    @Override
    public FisicHost getFisicHostById(int id) {
        Session session = sessionFactory.openSession();
        FisicHost fisicHost = session.get(FisicHost.class, id);
        session.close();
        return fisicHost;
    }

    @Override
    public FisicHost getFisicHostByIp(String ip) {
        Session session = sessionFactory.openSession();
        FisicHost fisicHost = session.get(FisicHost.class, ip);
        session.close();
        return fisicHost;
    }

    @Override
    public void save(FisicHost fisicHost) {
        Session session = sessionFactory.openSession();
        session.save(fisicHost);
        session.close();
    }

    @Override
    public void update(FisicHost fisicHost) {
        Session session = sessionFactory.openSession();
        session.update(fisicHost);
        session.close();
    }

    @Override
    public void delete(FisicHost fisicHost) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(fisicHost);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public FisicHost findById(int id) {
        // Open a session
        Session session = sessionFactory.openSession();

        FisicHost fisicHost = session.get(FisicHost.class, id);

        // Close the session
        session.close();

        return fisicHost;
    }

    @Override
    public void deleteAllCredentialsByFisicHost(FisicHost fisicHost) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for(Credential credential : fisicHost.getCredentials()){
            session.beginTransaction();
            credentialService.delete(credential);
        }
        session.getTransaction().commit();
        session.close();
    }

}
