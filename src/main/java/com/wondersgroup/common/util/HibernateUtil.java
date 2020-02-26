package com.wondersgroup.common.util;

/**
 * Created by 319 on 2020/2/26.
 */

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private HibernateUtil(){}
    private static class SingletonInstance{
        private static final HibernateUtil INSTANCE = new HibernateUtil();
    }

    private SessionFactory bulidSessionFactory(){
        try {
            Configuration configuration = new Configuration().configure();
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }catch (Throwable th){
            System.err.println("Enitial SessionFactory creation failed" + th);
            throw new ExceptionInInitializerError(th);
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory(){
        return SingletonInstance.INSTANCE.bulidSessionFactory();
    }
}

