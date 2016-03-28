package com.sjsu.cmpe275.lab2;


import java.util.List;

/**
 * Created by huimin on 3/24/16.
 */
public interface ProfileDao {
    public Profile create(Profile profile);

    public Profile update(Profile profile);

    public Profile delete(String id);

    public Profile findById(String id);

    //public List<Profile> findAll();
}
