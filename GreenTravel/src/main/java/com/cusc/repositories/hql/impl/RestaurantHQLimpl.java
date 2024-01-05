/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.repositories.hql.impl;

import com.cusc.entities.Restaurants;
import com.cusc.repositories.hql.RestaurantHQL;
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
public class RestaurantHQLimpl implements RestaurantHQL {

    EntityManagerFactory emf;
    EntityManager em;

    public RestaurantHQLimpl() {
        emf = Persistence.createEntityManagerFactory("GreenTravel");
        em = emf.createEntityManager();
    }

    @Override
    public List<Restaurants> findAllRestaurantByDestinationIDandRateStar(Integer destinationID, String keyword, Integer rateStar) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Restaurants.class);
        cq.select(root);
        if (!keyword.isEmpty()) {
            cq.where(cb.or((cb.equal(root.get("destinationID").get("destinationID"), destinationID)), (cb.like(root.get("name"), "%" + keyword + "%")), (cb.equal(root.get("rateStar"), rateStar))));
        } else {
            cq.where(cb.or((cb.equal(root.get("destinationID").get("destinationID"), destinationID)), (cb.equal(root.get("rateStar"), rateStar))));
        }
        Query query = em.createQuery(cq);
        return (List<Restaurants>) query.getResultList();
    }

}
