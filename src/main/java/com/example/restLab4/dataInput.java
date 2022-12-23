package com.example.restLab4;

import com.example.restLab4.Util.HibernateSessionUtil;
import org.hibernate.Session;

public class dataInput {
    public static void main(String args[]){
        Session one = HibernateSessionUtil.getSession();
    }
}
