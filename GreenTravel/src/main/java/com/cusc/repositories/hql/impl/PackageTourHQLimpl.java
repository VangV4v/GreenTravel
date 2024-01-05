/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.repositories.hql.impl;

import com.cusc.entities.Destinations;
import com.cusc.entities.Hotels;
import com.cusc.entities.LocalTravels;
import com.cusc.entities.PackageTours;
import com.cusc.entities.Restaurants;
import com.cusc.repositories.hql.PackageTourHQL;
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
public class PackageTourHQLimpl implements PackageTourHQL {

    EntityManagerFactory emf;
    EntityManager em;

    public PackageTourHQLimpl() {
        emf = Persistence.createEntityManagerFactory("GreenTravel");
        em = emf.createEntityManager();
    }

    @Override
    public List<Destinations> findAllDestinationByArea(int areaID) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Destinations.class);
        cq.select(root);
        cq.where(cb.equal(root.get("areaID"), areaID));
        Query query = em.createQuery(cq);
        return (List<Destinations>) query.getResultList();
    }

    @Override
    public List<Restaurants> findAllRestaurentByDestinationID(int destinationID) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Restaurants.class);
        cq.select(root);
        cq.where(cb.equal(root.get("destinationID").get("destinationID"), destinationID));
        Query query = em.createQuery(cq);
        return (List<Restaurants>) query.getResultList();
    }

    @Override
    public List<LocalTravels> findAllLocalTravelByDestinationID(int destinationID) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(LocalTravels.class);
        cq.select(root);
        cq.where(cb.equal(root.get("destinationID").get("destinationID"), destinationID));
        Query query = em.createQuery(cq);
        return (List<LocalTravels>) query.getResultList();
    }

    @Override
    public List<PackageTours> findAllPackageTourByFilter(Integer fromProvinceID, Integer toProvinceID, Date date, Date current) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(PackageTours.class);
        cq.select(root);
        if (fromProvinceID != null && toProvinceID == null && date != null) {
            cq.where(cb.and(cb.and(cb.and((cb.equal(root.get("fromProvinceID").get("provinceID"), fromProvinceID)), cb.and((cb.greaterThanOrEqualTo(root.get("dateEnd"), date)), (cb.lessThanOrEqualTo(root.get("dateStart"), date))), cb.equal(root.get("status"), 2))),cb.greaterThan(root.get("dateStart"), current)));
        } else if (fromProvinceID == null && toProvinceID != null && date != null) {
            cq.where(cb.and(cb.and(cb.and((cb.equal(root.get("toProvinceID").get("provinceID"), toProvinceID)), cb.and((cb.greaterThanOrEqualTo(root.get("dateEnd"), date)), (cb.lessThanOrEqualTo(root.get("dateStart"), date)))), cb.equal(root.get("status"), 2)),cb.greaterThan(root.get("dateStart"), current)));
        } else if (fromProvinceID == null && toProvinceID == null && date != null) {
            cq.where(cb.and(cb.and(cb.and((cb.greaterThanOrEqualTo(root.get("dateEnd"), date)), (cb.lessThanOrEqualTo(root.get("dateStart"), date))), cb.equal(root.get("status"), 2)),cb.greaterThan(root.get("dateStart"), current)));
        } else if (fromProvinceID != null && toProvinceID != null && date == null) {
            cq.where(cb.and(cb.and(cb.and((cb.equal(root.get("fromProvinceID").get("provinceID"), fromProvinceID)), (cb.equal(root.get("toProvinceID").get("provinceID"), toProvinceID))), cb.equal(root.get("status"), 2)),cb.greaterThan(root.get("dateStart"), current)));
        } else if (fromProvinceID != null && toProvinceID == null && date == null) {
            cq.where(cb.and(cb.and(cb.equal(root.get("fromProvinceID").get("provinceID"), fromProvinceID), cb.equal(root.get("status"), 2)),cb.greaterThan(root.get("dateStart"), current)));
        } else if (fromProvinceID == null && toProvinceID != null && date == null) {
            cq.where(cb.and(cb.and(cb.equal(root.get("toProvinceID").get("provinceID"), toProvinceID), cb.equal(root.get("status"), 2)),cb.greaterThan(root.get("dateStart"), current)));
        } else {
            cq.where(cb.and(cb.and(cb.and((cb.and((cb.equal(root.get("fromProvinceID").get("provinceID"), fromProvinceID)), cb.equal(root.get("toProvinceID").get("provinceID"), toProvinceID))), cb.and((cb.greaterThanOrEqualTo(root.get("dateEnd"), date)), (cb.lessThanOrEqualTo(root.get("dateStart"), date)))), cb.equal(root.get("status"), 2)),cb.greaterThan(root.get("dateStart"), current)));
        }

        Query query = em.createQuery(cq);
        return (List<PackageTours>) query.getResultList();
    }

    @Override
    public List<PackageTours> findAllPackageTourBySearch(String keyword, Date date) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(PackageTours.class);
        cq.select(root);
        cq.where(cb.and(cb.and(cb.and((cb.greaterThan(root.get("dateStart"), date)), cb.greaterThan(root.get("capacity"), 0)), cb.equal(root.get("status"), 2)),cb.like(root.get("name"), "%" + keyword + "%")));
        cq.where((cb.like(root.get("name"), "%" + keyword + "%")));
        Query query = em.createQuery(cq);
        return (List<PackageTours>) query.getResultList();
    }

    @Override
    public List<PackageTours> findAllPackageTourAvailable(Date date) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(PackageTours.class);
        cq.select(root);
        cq.where(cb.and(cb.and((cb.greaterThan(root.get("dateStart"), date)), cb.greaterThan(root.get("capacity"), 0)), cb.equal(root.get("status"), 2)));
        Query query = em.createQuery(cq);
        return (List<PackageTours>) query.getResultList();
    }

    @Override
    public List<PackageTours> findAllPackageTourNew(Date date) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(PackageTours.class);
        cq.where(cb.and(cb.and((cb.greaterThan(root.get("dateStart"), date)), cb.greaterThan(root.get("capacity"), 0)), cb.equal(root.get("status"), 2)));
        cq.orderBy(cb.desc(root.get("packageTourID")));
        cq.select(root);
        Query query = em.createQuery(cq);
        return (List<PackageTours>) query.getResultList();
    }

    @Override
    public List<PackageTours> findAllPackageTourLimitDate(Date date) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(PackageTours.class);
        cq.where(cb.and(cb.and((cb.greaterThan(root.get("dateStart"), date)), cb.greaterThan(root.get("capacity"), 0)), cb.equal(root.get("status"), 2)));
        cq.orderBy(cb.asc(root.get("dateStart")));
        cq.select(root);
        Query query = em.createQuery(cq);
        return (List<PackageTours>) query.getResultList();
    }

    @Override
    public List<PackageTours> findAllPackageTourHot(Date date) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(PackageTours.class);
        cq.where(cb.and(cb.and((cb.greaterThan(root.get("dateStart"), date)), cb.greaterThan(root.get("capacity"), 0)), cb.equal(root.get("status"), 2)));
        cq.orderBy(cb.asc(root.get("capacity")));
        cq.select(root);
        Query query = em.createQuery(cq);
        return (List<PackageTours>) query.getResultList();
    }
    
    @Override
    public List<Hotels> findAllHotelByDestinationID(int destinationID) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(Hotels.class);
        cq.select(root);
        cq.where(cb.equal(root.get("destinationID").get("destinationID"), destinationID));
        Query query = em.createQuery(cq);
        return (List<Hotels>) query.getResultList();
    }
}
