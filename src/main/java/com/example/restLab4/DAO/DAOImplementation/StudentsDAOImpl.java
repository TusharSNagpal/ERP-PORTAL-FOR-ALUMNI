package com.example.restLab4.DAO.DAOImplementation;

import com.example.restLab4.Bean.Students;
import com.example.restLab4.DAO.StudentsDAO;
import com.example.restLab4.Util.HibernateSessionUtil;
//import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAOImpl implements StudentsDAO {
    @Override
    public boolean addStudent(Students studObj) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction t = session.beginTransaction();
            session.save(studObj);
            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Students> getStudents(){
        try (Session session = HibernateSessionUtil.getSession()){
            List<Students> studList = new ArrayList<>();
            for (final Object d : session.createQuery("from Students ").list()) {
                studList.add((Students) d);
            }
            return studList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
//
    @Override
    public List<Students> getStudentByGradYearName(int gradYear, String fname, String lname) {
        try(Session session = HibernateSessionUtil.getSession()){

            List<Students> studentList = new ArrayList<>();
            Query q = session.createQuery("from Students where graduation_year =: gradYear and first_name =: fname and last_name =: lname");
//            List <Students> studentList = q.list();
            q.setParameter("gradYear", gradYear);
            q.setParameter("fname", fname);
            q.setParameter("lname", lname);

            for (final Object fetch : q.list()) {
                studentList.add((Students) fetch);
            }
            return studentList;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    //start
    @Override
    public Students getStudentByID(int stud_id){
        try (Session session = HibernateSessionUtil.getSession()) {
            return session.get(Students.class, stud_id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
    //end

    @Override
    public Students getStudentByName(String studName) {
        try (Session session = HibernateSessionUtil.getSession()) {
            return session.get(Students.class, studName);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}