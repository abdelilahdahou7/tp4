package org.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Classe utilitaire pour Hibernate
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Crée la SessionFactory à partir de hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Libère le cache et les pools de connexion
        getSessionFactory().close();
    }
}
