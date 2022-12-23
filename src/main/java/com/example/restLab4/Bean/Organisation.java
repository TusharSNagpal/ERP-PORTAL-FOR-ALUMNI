package com.example.restLab4.Bean;

import jakarta.persistence.*;

@Entity
@Table(name= "organisation")
public class Organisation {
    @Id
    @Column(name ="org_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int org_id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="address")
    private String address;

//    @ManyToMany (fetch = FetchType.EAGER, targetEntity = Alumni.class, cascade = { CascadeType.ALL })
////    @JoinTable(name = "Alumni_Organisation",
////            joinColumns = { @JoinColumn(name = "org_id") },
////            inverseJoinColumns = { @JoinColumn(name = "alumni_id") })
//    private List<Alumni> AlumniList;


    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Organisation() {
    }
}