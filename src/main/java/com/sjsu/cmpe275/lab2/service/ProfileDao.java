package com.sjsu.cmpe275.lab2.service;

import com.sjsu.cmpe275.lab2.domain.Profile;

import java.util.List;

/**
 * Created by huimin on 3/24/16.
 */
public interface ProfileDao {
    public void store(Profile profile);

    public void update(Profile profile);

    public void delete(String id);

    public Profile findById(String id);

    public List<Profile> findAll();
}
