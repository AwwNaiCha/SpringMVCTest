package com.sjsu.cmpe275.lab2.service;

import com.sjsu.cmpe275.lab2.domain.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by huimin on 3/24/16.
 */
@Service
@Repository("profileDao")
public class JpaProfileDao implements ProfileDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void store(Profile profile) {
        entityManager.merge(profile);
    }

    @Transactional
    public void update(Profile profile) {
        entityManager.merge(profile);
    }

    @Transactional
    public void delete(String id) {
        Profile profile = entityManager.find(Profile.class, id);
        entityManager.remove(profile);
    }
    @Transactional(readOnly = true)
    public Profile findById(String id) {
        return entityManager.find(Profile.class, id);
    }
    @Transactional(readOnly = true)
    public List<Profile> findAll() {
        List<Profile> query = entityManager.createQuery("select profile from Profile profile", Profile.class).getResultList();
        return query;
    }


//    @PersistenceContext
//    private EntityManagerFactory entityManagerFactory;
//
//    public JpaProfileDao() {
//        entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
//    }

//    @Transactional
//    public void store(Profile profile) {
//
//        EntityManager manager = entityManagerFactory.createEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        try {
//            tx.begin();
//            manager.merge(profile);
//            tx.commit();
//        }
//        catch (RuntimeException e) {
//            tx.rollback();
//            throw e;
//        }
//        finally {
//            manager.close();
//        }
//    }

//    @Transactional
//    public void update(Profile profile) {
//        EntityManager manager = entityManagerFactory.createEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        try {
//            tx.begin();
//            manager.merge(profile);
//            tx.commit();
//        }
//        catch (RuntimeException e) {
//            tx.rollback();
//            throw e;
//        }
//        finally {
//            manager.close();
//        }
//    }

//    @Transactional
//    public void delete(String id) {
//
//        EntityManager manager = entityManagerFactory.createEntityManager();
//        EntityTransaction tx = manager.getTransaction();
//        try {
//            tx.begin();
//            Profile profile = manager.find(Profile.class, id);
//            manager.remove(profile);
//            tx.commit();
//        }
//        catch (RuntimeException e) {
//            tx.rollback();
//            throw e;
//        }
//        finally {
//            manager.close();
//        }
//    }

//    @Transactional(readOnly = true)
//    public Profile findById(String id) {
//        EntityManager manager = entityManagerFactory.createEntityManager();
//        try {
//            return manager.find(Profile.class, id);
//        }
//        finally {
//            manager.close();
//        }
//    }

    //remove the query language check
//    @Transactional(readOnly = true)
//    public List<Profile> findAll() {
//        EntityManager manager = entityManagerFactory.createEntityManager();
//        try {
//            Query query = manager.createQuery("select profile from Profile profile");
//            return query.getResultList();
//        }
//        finally {
//            manager.close();
//        }
//    }

}
