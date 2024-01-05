/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.repositories.hql.impl;

import com.cusc.entities.Customers;
import com.cusc.entities.Employees;
import com.cusc.repositories.hql.EmployeesHQL;
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
public class EmployeesHQLimpl implements EmployeesHQL {

    EntityManagerFactory emf;
    EntityManager em;

    public EmployeesHQLimpl() {
        emf = Persistence.createEntityManagerFactory("GreenTravel");
        em = emf.createEntityManager();
    }

    @Override
    public long getCountByUsername(String username) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Employees.class);
        cq.select(cb.count(root.get("username")));
        cq.where(cb.equal(root.get("username"), username));
        Query query = em.createQuery(cq);
        return (long) query.getSingleResult();
    }

    @Override
    public long getCountByEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Employees.class);
        cq.select(cb.count(root.get("email")));
        cq.where(cb.equal(root.get("email"), email));
        Query query = em.createQuery(cq);
        return (long) query.getSingleResult();
    }

    @Override
    public Employees loadByUsername(String string) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Employees.class);
        cq.select(root);
        cq.where(cb.equal(root.get("username"), string));
        Query query = em.createQuery(cq);
        return (Employees) query.getSingleResult();
    }

}
