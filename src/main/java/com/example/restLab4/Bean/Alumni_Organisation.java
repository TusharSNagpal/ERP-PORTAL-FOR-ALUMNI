package com.example.restLab4.Bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "alumni_organisation")
public class Alumni_Organisation {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="org_id")
    private Organisation organisation;

    @ManyToOne
    @JoinColumn(name="alumni_id")
    private Alumni alumni;

    @Column(name="position",nullable = false)
    private String position;

    @Column(name="leaving_date",nullable = false)
    private Date leaving_date;

    @Column(name="joining_date",nullable = false)
    private Date joining_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Alumni getAlumni() {
        return alumni;
    }

    public void setAlumni(Alumni alumni) {
        this.alumni = alumni;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getLeaving_date() {
        return leaving_date;
    }

    public void setLeaving_date(Date leaving_date) {
        this.leaving_date = leaving_date;
    }

    public Date getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(Date joining_date) {
        this.joining_date = joining_date;
    }

    public Alumni_Organisation() {
    }
}