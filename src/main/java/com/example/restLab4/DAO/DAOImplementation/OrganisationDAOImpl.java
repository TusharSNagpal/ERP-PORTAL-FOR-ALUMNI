package com.example.restLab4.DAO.DAOImplementation;

import com.example.restLab4.Bean.Organisation;
import com.example.restLab4.DAO.OrganisationDAO;
import com.example.restLab4.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class OrganisationDAOImpl implements OrganisationDAO {
    @Override
    public List<Organisation> getOrganisation(){
        try (Session session = HibernateSessionUtil.getSession()){
            List<Organisation> OrgList = new ArrayList<>();
            for (final Object d : session.createQuery("from Organisation ").list()) {
                OrgList.add((Organisation) d);
            }
            return OrgList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}
