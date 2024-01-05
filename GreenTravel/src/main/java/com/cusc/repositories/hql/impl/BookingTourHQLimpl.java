/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.repositories.hql.impl;

import com.cusc.entities.BookingTours;
import com.cusc.repositories.hql.BookingTourHQL;
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
public class BookingTourHQLimpl implements BookingTourHQL {

    EntityManagerFactory emf;
    EntityManager em;

    public BookingTourHQLimpl() {
//        emf = Persistence.createEntityManagerFactory("GreenTravel");
//        em = emf.createEntityManager();
    }

    @Override
    public List<BookingTours> findAllBookingTourConfirm(Long empID) {
        emf = Persistence.createEntityManagerFactory("GreenTravel");
        em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(BookingTours.class);
        cq.select(root);
        cq.where(cb.and((cb.equal(root.get("status"), 1)),(cb.equal(root.get("employeeID").get("employeeID"), empID))));
        Query query = em.createQuery(cq);
        return (List<BookingTours>) query.getResultList();
    }

    @Override
    public List<BookingTours> findAllBookingTour() {
        emf = Persistence.createEntityManagerFactory("GreenTravel");
        em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(BookingTours.class);
        cq.select(root);
        cq.where(cb.or((cb.equal(root.get("status"), 2)), (cb.equal(root.get("status"), 3)), (cb.equal(root.get("status"), -1))));
        Query query = em.createQuery(cq);
        return (List<BookingTours>) query.getResultList();
    }

    @Override
    public List<BookingTours> findAllBookingTourCustomer(Long customerID) {
        emf = Persistence.createEntityManagerFactory("GreenTravel");
        em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(BookingTours.class);
        cq.select(root);
        cq.where(cb.equal(root.get("customerID").get("customerID"),customerID));
        Query query = em.createQuery(cq);
        return (List<BookingTours>) query.getResultList();
    }
}
