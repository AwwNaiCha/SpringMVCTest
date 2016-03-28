package com.sjsu.cmpe275.lab2;

import org.springframework.boot.orm.jpa.EntityScan;

import javax.persistence.*;

/**
 * Created by huimin on 3/24/16.
 */

@Entity
@Table(name = "PROFILE_TABLE")
public class Profile {

    @Id
    //@Column(name = "ID")
    private String id;

    //@Column(name = "FIRSTNAME")
    private String firstname;

    //@Column(name = "LASTNAME")
    private String lastname;

    //@Column(name = "EMAIL")
    private String email;

    //@Column(name = "ADDRESS")
    private String address;

    //@Column(name = "ORGANIZATION")
    private String organization;

    //@Column(name = "ABOUTMYSELF")
    private String aboutMyself;

//    public Profile() { }
//
//    public Profile(String firstname, String lastname, String email,
//                   String address, String organization, String aboutMyself) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.email = email;
//        this.address = address;
//        this.organization = organization;
//        this.aboutMyself = aboutMyself;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getAboutMyself() {
        return aboutMyself;
    }

    public void setAboutMyself(String aboutMyself) {
        this.aboutMyself = aboutMyself;
    }

//    @Override
//    public String toString() {
//        return "Profile{" +
//                "id='" + id + '\'' +
//                ", firstname='" + firstname + '\'' +
//                ", lastname='" + lastname + '\'' +
//                ", email='" + email + '\'' +
//                ", address='" + address + '\'' +
//                ", organization='" + organization + '\'' +
//                ", aboutMyself='" + aboutMyself + '\'' +
//                '}';
//    }

}
