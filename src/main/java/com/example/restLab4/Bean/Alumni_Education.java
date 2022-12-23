package com.example.restLab4.Bean;

import jakarta.persistence.*;

@Entity
@Table(name= "alumni_education")
public class Alumni_Education {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="degree",nullable = false)
    private String degree;

    @Column(name="passing_year",nullable = false)
    private int passing_year;

    @Column(name="joining_year",nullable = false)
    private int joining_year;

    @Column(name="college_name")
    private String college_name;

    @Column(name="address",nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name="alumni_id")
    private Alumni alumni;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getPassing_year() {
        return passing_year;
    }

    public void setPassing_year(int passing_year) {
        this.passing_year = passing_year;
    }

    public int getJoining_year() {
        return joining_year;
    }

    public void setJoining_year(int joining_year) {
        this.joining_year = joining_year;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Alumni getAlumni() {
        return alumni;
    }

    public void setAlumni(Alumni alumni) {
        this.alumni = alumni;
    }

    public Alumni_Education() {
    }
}