
package com.example.restLab4.DAO;

import com.example.restLab4.Bean.Students;

import java.util.List;

public interface StudentsDAO {
    boolean addStudent(Students studObj);

    List<Students> getStudentByGradYearName(int gradYear, String fname, String lname);
    //start
    Students getStudentByID(int stud_id);

    List<Students> getStudents();

    Students getStudentByName(String studName);

//    boolean deleteEmployee(int empID);
//    Double avgSalary();
}