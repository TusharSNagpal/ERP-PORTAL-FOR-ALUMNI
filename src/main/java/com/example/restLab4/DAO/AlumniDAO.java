package com.example.restLab4.DAO;

import com.example.restLab4.Bean.Alumni;

public interface AlumniDAO {
    boolean registerAlumni(Alumni aluObj);

    Alumni getAlumniByEmail(String email);
}
