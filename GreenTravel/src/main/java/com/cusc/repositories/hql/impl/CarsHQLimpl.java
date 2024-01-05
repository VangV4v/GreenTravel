/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.repositories.hql.impl;

import com.cusc.entities.Cars;
import com.cusc.entities.Customers;
import com.cusc.repositories.hql.CarsHQL;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kyqua
 */
@Repository
public class CarsHQLimpl implements CarsHQL {

    EntityManagerFactory emf;
    EntityManager em;

    public CarsHQLimpl() {
        emf = Persistence.createEntityManagerFactory("GreenTravel");
        em = emf.createEntityManager();
    }

    @Override
    public long getCountByCarName(String carname) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Cars.class);
        cq.select(cb.count(root.get("carName")));
        cq.where(cb.equal(root.get("carName"), carname));
        Query query = em.createQuery(cq);
        return (long) query.getSingleResult();
    }

    @Override
    public List<Cars> findAllByTypeIDAndModelID(int typeid, int modelid) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Cars.class);
        cq.select(root);
        cq.where(cb.or(cb.equal(root.get("carModelID").get("carModelID"), modelid), cb.equal(root.get("carTypeID").get("carTypeID"), typeid)));
        Query query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Cars> findAllByCarName(String string) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Cars.class);
        cq.select(root);
        cq.where(cb.like(root.get("carName"), "%" + string + "%"));
        Query query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Cars> findAllCarNew() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Cars.class);
        cq.orderBy(cb.desc(root.get("carID")));
        cq.select(root);
        Query query = em.createQuery(cq);
        return (List<Cars>) query.getResultList();
    }

}
