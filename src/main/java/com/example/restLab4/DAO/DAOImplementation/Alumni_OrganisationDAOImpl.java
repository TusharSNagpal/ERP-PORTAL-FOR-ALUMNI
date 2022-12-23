package com.example.restLab4.DAO.DAOImplementation;

import com.example.restLab4.Bean.Alumni_Organisation;
import com.example.restLab4.DAO.Alumni_OrganisationDAO;
import com.example.restLab4.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Alumni_OrganisationDAOImpl implements Alumni_OrganisationDAO {
    @Override
    public boolean registerAlumniOrg(Alumni_Organisation aluOrgObj) {
        //Alumni aluObj = new Alumni(email, contact_number, stud);
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(aluOrgObj);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        } catch (Exception e) {
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }
}
