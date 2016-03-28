//package com.sjsu.cmpe275.lab2;
//
//import com.sjsu.cmpe275.lab2.configuration.ProfileConfi;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.util.List;
//import com.sjsu.cmpe275.lab2.domain.*;
//
///**
// * Created by huimin on 3/25/16.
// */
//public class Main {
//    public static void main(String[] args) {
//
//        ApplicationContext context = new AnnotationConfigApplicationContext(ProfileConfi.class);
//        //CourseDao courseDao = context.getBean(CourseDao.class);
//
//        ProfileDao profileDao = context.getBean(ProfileDao.class);
//
//        Profile profile = new Profile();
//        profile.setId("0002");
//        profile.setFirstname("aaaa");
//        profile.setLastname("bbbb");
//        profile.setEmail("sdfs@gsrg.com");
//        profile.setAddress("address blabla");
//        profile.setOrganization("AAA");
//        profile.setAboutMyself("I'm jsodfjaopwe jafei jf");
//        profileDao.store(profile);
//
//        List<Profile> profiles = profileDao.findAll();
//        String profileId = profiles.get(0).getId();
//
//        profile = profileDao.findById(profileId);
//        System.out.println("\nProfile created:");
//        System.out.println("ID: " + profile.getId());
//        System.out.println("First Name: " + profile.getFirstname());
//        System.out.println("Last Name: " + profile.getLastname());
//        System.out.println("Email: " + profile.getEmail());
//        System.out.println("Address: " + profile.getAddress());
//        System.out.println("Organization: " + profile.getOrganization());
//        System.out.println("About Myself: " + profile.getAboutMyself());
//
//        profile.setFirstname("aaaaaaaaa");
//        profileDao.update(profile);
//        profileId = profiles.get(0).getId();
//
//        profile = profileDao.findById(profileId);
//        System.out.println("\nAfter update:");
//        System.out.println("ID: " + profile.getId());
//        System.out.println("First Name: " + profile.getFirstname());
//        System.out.println("Last Name: " + profile.getLastname());
//        System.out.println("Email: " + profile.getEmail());
//        System.out.println("Address: " + profile.getAddress());
//        System.out.println("Organization: " + profile.getOrganization());
//        System.out.println("About Myself: " + profile.getAboutMyself());
//    }
//}
