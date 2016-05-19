package com.pb.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static final SessionFactory sessionFactory;
	//使用ThreadLocal管理Session
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	static {
		try {
			//根据hibernate.cfg.xml建立SessionFactory
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			ex.printStackTrace();
			System.err.println("建立SessionFactory错误" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
		
    public static Session getSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		if (session == null || !session.isOpen()) {
			session = (sessionFactory != null) ? sessionFactory.openSession(): null;
			threadLocal.set(session);
		}
		return session;
	} 
    
    public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }
}

