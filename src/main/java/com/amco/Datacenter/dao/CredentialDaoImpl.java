package com.amco.Datacenter.dao;

import com.amco.Datacenter.model.Credential;
import com.amco.Datacenter.model.FisicHost;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CredentialDaoImpl implements CredentialDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Credential> getAllCredentialsByFisicHost(FisicHost fisicHost) {
        // Open a session
        Session session = sessionFactory.openSession();

        Criteria c = session.createCriteria(Credential.class).add(Restrictions.eq("fisicHost.id", fisicHost.getId()));

        List<Credential> allCredentials = c.list();

        // Close the session
        session.close();

        return allCredentials;
    }

    @Override
    public Credential getCredentialByUser(String user) {
        Session session = sessionFactory.openSession();
        Credential credential = session.get(Credential.class, user);
        session.close();
        return credential;
    }

    @Override
    public Credential getCredentialById(int id) {
        Session session = sessionFactory.openSession();
        Credential credential = session.get(Credential.class, id);
        session.close();
        return credential;
    }

    @Override
    public void save(Credential credential) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(credential);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Credential credential) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(credential);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Credential credential) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(credential);
        session.getTransaction().commit();
        session.close();
    }
}
