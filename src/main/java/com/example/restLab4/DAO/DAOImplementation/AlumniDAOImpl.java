package com.example.restLab4.DAO.DAOImplementation;

import com.example.restLab4.Bean.Alumni;
import com.example.restLab4.DAO.AlumniDAO;
import com.example.restLab4.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AlumniDAOImpl implements AlumniDAO {
    @Override
    public boolean registerAlumni(Alumni aluObj) {
        //Alumni aluObj = new Alumni(email, contact_number, stud);
        try (Session session = HibernateSessionUtil.getSession()) {  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();  // transaction initiated
            session.save(aluObj);                                 // using session object to save java object into MySQL
            transaction.commit();                                  // committing transaction
            return true;
        } catch (HibernateException exception) {
            // if Hibernate Exception occurs return false
            // for related exception we can maintain separate logger / Sysout messages for easy debugging
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        } catch (Exception e) {
            //generalized exception class for any IO / Arithmetic Exception
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public Alumni getAlumniByEmail(String email) {
        try (Session session = HibernateSessionUtil.getSession()) {
            String sql = "FROM Alumni a WHERE a.email = :alumniEmail";
            Query query = session.createQuery(sql);
            query.setParameter("alumniEmail", email);
            List<Alumni> alummniList= query.list();
            if(alummniList.size() == 1){
                return alummniList.get(0);
            }
            else return null;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}
