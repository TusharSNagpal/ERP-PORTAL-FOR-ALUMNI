package com.example.restLab4.DAO.DAOImplementation;

import com.example.restLab4.Bean.Alumni_Education;
import com.example.restLab4.DAO.Alumni_EducationDAO;
import com.example.restLab4.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Alumni_EducationDAOImpl implements Alumni_EducationDAO {
    @Override
    public boolean registerAlumniEducation(Alumni_Education aluEduObj) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(aluEduObj);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println("Hibernate Error Caught");
            System.out.print(exception.getLocalizedMessage());
            return false;
        } catch (Exception e) {
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }
}
