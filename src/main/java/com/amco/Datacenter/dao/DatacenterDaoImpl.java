package com.amco.Datacenter.dao;

import com.amco.Datacenter.model.Datacenter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DatacenterDaoImpl implements DatacenterDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Datacenter> getAllDatacenters() {
        // Open a session
        Session session = sessionFactory.openSession();

        // Get all Datacenters with a "Hibernate Criteria Object"
        List<Datacenter> allDatacenters = session.createCriteria(Datacenter.class).list();

        // Close the session
        session.close();

        return allDatacenters;

    }

    @Override
    public Datacenter getDatacenterByName(String name) {
        Session session = sessionFactory.openSession();
        Datacenter datacenter = session.get(Datacenter.class, name);
        session.close();
        return datacenter;
    }

    @Override
    public Datacenter getDatacenterById(int id) {
        Session session = sessionFactory.openSession();
        Datacenter datacenter = session.get(Datacenter.class, id);
        session.close();
        return datacenter;
    }

    @Override
    public void save(Datacenter datacenter) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(datacenter);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void update(Datacenter datacenter) {
        Session session = sessionFactory.openSession();
        session.update(datacenter);
        session.close();

    }

    @Override
    public void delete(Datacenter datacenter) {
        Session session = sessionFactory.openSession();
        session.delete(datacenter);
        session.close();
    }



}
