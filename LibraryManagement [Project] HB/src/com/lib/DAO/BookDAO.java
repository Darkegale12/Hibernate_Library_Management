package com.lib.DAO;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.lib.Configuration.HbConfig;
import com.lib.Entity.Book;
import com.lib.Entity_user.UserPassword;

public class BookDAO {
	
	private SessionFactory sf=HbConfig.getSessionFactory();
	
	
	
	public boolean insertBook(Book b) {
		
		Session session=sf.openSession();
		session.save(b);
		session.beginTransaction();
		session.close();
		return true;
		
	}

	public List<Book> searchbookbyauthor(String author) {
		 Session session=sf.openSession();
		 Criteria creitera=session.createCriteria(Book.class);
		 creitera.add(Restrictions.eq("author", author));
		 List<Book>ls=creitera.list();
		 return ls;
		
	}

	public List<Book> getallbooks() {
		Session session=sf.openSession();
		Criteria creitera=session.createCriteria(Book.class);
		 List<Book>ls=creitera.list();
		 return ls;
		 
	}

	public List<Book> searchbytitlekeyword(String searchkey) {
		Session session=sf.openSession();
		 Criteria creitera=session.createCriteria(Book.class);
		 creitera.add(Restrictions.like("title", "%"+ searchkey+"%"));
		 List<Book>ls=creitera.list();
		 return ls;
		
	}

	public List<Book> searchbyYear(int searchyear) {
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Book.class);
		 cr.add(Restrictions.eq("year", searchyear));
		return cr.list();
	}
	
	
	
	
public boolean deletebyName(String bname) {
	    Session session = sf.openSession();
	    Criteria cr=session.createCriteria(Book.class);
	    cr.add(Restrictions.eq("title", bname));
	    List<Book> books = cr.list();

	    if (books.isEmpty()) {
	        session.close();
	        return false;
	    }

	    for (Book book : books) {
	        session.delete(book);
	    }

	    session.beginTransaction().commit();
	    session.close();

	    return true;
	}


	public boolean deletebyAuthor(String aname) {
		   Session session = sf.openSession();
		    Criteria cr=session.createCriteria(Book.class);
		    cr.add(Restrictions.eq("author", aname));
		    List<Book> books = cr.list();

		    if (books.isEmpty()) {
		        session.close();
		        return false;
		    }

		    for (Book book : books) {
		        session.delete(book);
		    }

		    session.beginTransaction().commit();
		    session.close();

		    return true;
		}

	public Boolean deletebyyear(int yearr) {
		   Session session = sf.openSession();
		    Criteria cr=session.createCriteria(Book.class);
		    cr.add(Restrictions.eq("year", yearr));
		    List<Book> books = cr.list();

		    if (books.isEmpty()) {
		        session.close();
		        return false;
		    }

		    for (Book book : books) {
		        session.delete(book);
		    }

		    session.beginTransaction().commit();
		    session.close();

		    return true;
	}

//	public boolean userpassword(UserPassword u) {
//		Session session=sf.openSession();
//		session.save(u);
//		session.beginTransaction();
//		session.close();
//		return true;
//		
//	}

}
