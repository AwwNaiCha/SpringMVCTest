package com.sjsu.cmpe275.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huimin on 3/24/16.
 */
@Service
public class JpaProfileDao implements ProfileDao {

    @Autowired
    private ProfileRepo profileRepo;

    @Transactional
    public Profile create(Profile profile) {
        return profileRepo.save(profile);
    }

    @Transactional
    public Profile update(Profile profile) {
        Profile updated = profileRepo.findOne(profile.getId());
        updated.setFirstname(profile.getFirstname());
        updated.setLastname(profile.getLastname());
        updated.setAddress(profile.getAddress());
        updated.setEmail(profile.getEmail());
        updated.setAboutmyself(profile.getAboutmyself());
        updated.setOrganization(profile.getOrganization());
        return updated;

    }

    @Transactional
    public Profile delete(String id) {
        Profile deleted = profileRepo.findOne(id);
        profileRepo.delete(deleted);
        return deleted;
    }

    @Transactional
    public Profile findById(String id) {
        return profileRepo.findOne(id);
    }


//    @Transactional(readOnly = true)
//    public List<Profile> findAll() {
//        List<Profile> query = entityManager.createQuery("select profile from Profile profile", Profile.class).getResultList();
//        return query;
//    }




}
