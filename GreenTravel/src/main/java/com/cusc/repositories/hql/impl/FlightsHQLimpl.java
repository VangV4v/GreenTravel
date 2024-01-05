/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.repositories.hql.impl;

import com.cusc.entities.Flights;
import com.cusc.repositories.hql.FlightsHQL;
import java.sql.Date;
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
public class FlightsHQLimpl implements FlightsHQL {

    EntityManagerFactory emf;
    EntityManager em;

    public FlightsHQLimpl() {
        emf = Persistence.createEntityManagerFactory("GreenTravel");
        em = emf.createEntityManager();
    }

    @Override
    public List<Flights> filterFlight(Integer fromProvinceID, Integer toProvinceID) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Flights.class);
        cq.select(root);
        if (fromProvinceID == null || toProvinceID == null) {
            cq.where(cb.or((cb.equal(root.get("fromProvince").get("provinceID"), fromProvinceID)), (cb.equal(root.get("toProvince").get("provinceID"), toProvinceID))));
        } else {
            cq.where(cb.and((cb.equal(root.get("fromProvince").get("provinceID"), fromProvinceID)), (cb.equal(root.get("toProvince").get("provinceID"), toProvinceID))));
        }
        Query query = em.createQuery(cq);
        return (List<Flights>) query.getResultList();
    }

    @Override
    public List<Flights> searchFlightByDate(Date date) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Flights.class);
        cq.select(root);
        cq.where(cb.equal(root.get("departureDate"), date));
        Query query = em.createQuery(cq);
        return (List<Flights>) query.getResultList();
    }

    @Override
    public long getCountFlightCode(String flightCode) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Flights.class);
        cq.select(cb.count(root.get("flightCode")));
        cq.where(cb.equal(root.get("flightCode"), flightCode));
        Query query = em.createQuery(cq);
        return (long) query.getSingleResult();
    }

    @Override
    public List<Flights> getListFlightAvailable(Date date) {
       CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Flights.class);
        cq.select(root);
        cq.where((cb.greaterThan(root.get("departureDate"), date)));
        Query query = em.createQuery(cq);
        return (List<Flights>) query.getResultList();
    }

}
