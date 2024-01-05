/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.repositories.hql.impl;

import com.cusc.entities.Hotels;
import com.cusc.repositories.hql.HotelsHQL;
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
public class HotelsHQLimpl implements HotelsHQL {

    EntityManagerFactory emf;
    EntityManager em;

    public HotelsHQLimpl() {
        emf = Persistence.createEntityManagerFactory("GreenTravel");
        em = emf.createEntityManager();
    }

    @Override
    public List<Hotels> filterHotel(Integer destinationID, String keyword, Integer rateStar) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Hotels.class);
        cq.select(root);
        if (!keyword.isEmpty()) {
            cq.where(cb.or((cb.equal(root.get("destinationID").get("destinationID"), destinationID)), (cb.like(root.get("name"), "%" + keyword + "%")), (cb.equal(root.get("rateStar"), rateStar))));
        } else {
            cq.where(cb.or((cb.equal(root.get("destinationID").get("destinationID"), destinationID)), (cb.equal(root.get("rateStar"), rateStar))));
        }
        Query query = em.createQuery(cq);
        return (List<Hotels>) query.getResultList();
    }

   

}
