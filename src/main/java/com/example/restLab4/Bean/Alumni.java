package com.example.restLab4.Bean;

import jakarta.persistence.*;

@Entity
@Table(name= "alumni")
public class Alumni {
    @Id
    @Column(name ="alumni_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alumni_id;

//    public Alumni(String email, String contact_number, Students students) {
//        this.email = email;
//        this.contact_number = contact_number;
//        this.students = students;
//    }

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @Column(name="contact_number",nullable = false, unique = true)
    private String contact_number;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name="student_id", unique = true)
    private Students students;

    public int getAlumni_id() {
        return alumni_id;
    }

    public void setAlumni_id(int alumni_id) {
        this.alumni_id = alumni_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }
//    @ManyToMany (mappedBy = "AlumniList", fetch = FetchType.EAGER)
////    @JoinTable(name = "Alumni_Organisation",
////            joinColumns = { @JoinColumn(name = "org_id") },
////            inverseJoinColumns = { @JoinColumn(name = "alumni_id") })
//    private List<Alumni> AlumniList;

    public Alumni() {
    }
}