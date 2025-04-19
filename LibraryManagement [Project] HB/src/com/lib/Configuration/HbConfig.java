package com.lib.Configuration;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lib.Entity.Book;

public class HbConfig {
	public static final SessionFactory getSessionFactory () {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Book.class);
		SessionFactory sf=cfg.buildSessionFactory();
		return sf;
	}
}

