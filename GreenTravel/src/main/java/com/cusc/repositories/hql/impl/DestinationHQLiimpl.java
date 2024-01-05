/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.repositories.hql.impl;

import com.cusc.entities.Destinations;
import com.cusc.repositories.hql.DestinationHQL;
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
public class DestinationHQLiimpl implements  DestinationHQL{
    
     EntityManagerFactory emf;
    EntityManager em;

    public DestinationHQLiimpl() {
        emf = Persistence.createEntityManagerFactory("GreenTravel");
        em = emf.createEntityManager();
    }

    @Override
    public List<Destinations> searchDestination(String keyword) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Destinations.class);
        cq.select(root);
       
            cq.where(cb.like(root.get("name"), "%" + keyword + "%"));
        
        Query query = em.createQuery(cq);
        return (List<Destinations>) query.getResultList();
    }
    
}
