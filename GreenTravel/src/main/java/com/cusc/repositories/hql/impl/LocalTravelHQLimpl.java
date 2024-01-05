/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.repositories.hql.impl;

import com.cusc.entities.LocalTravels;
import com.cusc.repositories.hql.LocalTravelHQL;
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
public class LocalTravelHQLimpl implements LocalTravelHQL{

      EntityManagerFactory emf;
    EntityManager em;

    public LocalTravelHQLimpl() {
        emf = Persistence.createEntityManagerFactory("GreenTravel");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<LocalTravels> filterLocalTravel(String keyword, Integer destinationID) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(LocalTravels.class);
        cq.select(root);
        if (!keyword.isEmpty()) {
            cq.where(cb.or(cb.equal(root.get("destinationID").get("destinationID"), destinationID), (cb.like(root.get("name"), "%" + keyword + "%"))));
        } else {
            cq.where((cb.equal(root.get("destinationID").get("destinationID"), destinationID)));
        }
        Query query = em.createQuery(cq);
        return (List<LocalTravels>) query.getResultList();
    }
    
}
