package com.lib.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.lib.DAO.BookDAO;
import com.lib.Entity.Book;
import com.lib.Entity_user.UserPassword;
import com.lib.encyption.Encrypt;

public class BookService {
	private BookDAO dao=new BookDAO();
	
	
	
	public String insertBook(Book b) {
			
		
		b.setCreationTime(LocalDateTime.now());
		b.setModificationTime(LocalDateTime.now());
		
		
		String encisbn=Encrypt.encryptMyISBN(b.getIsbn());
		b.setIsbn(encisbn);
		
		
		
		boolean check=dao.insertBook(b);
		if(check) {
			return "Book is Inserted ";
		}
		else {
		return "Book not Inserted Properly...";
		}
	}

	
	
	
	public List<Book> searchbookbyauthor(String author) {
	return	dao.searchbookbyauthor(author);
		
	}




	public List<Book> getallbooks() {
		return dao.getallbooks();
		
	}




	public List<Book> searchbytitlekeyword(String searchkey) {
		return dao.searchbytitlekeyword(searchkey);
		
	}




	public List<Book> searchbyYear(int searchyear) {
	
		return dao.searchbyYear(searchyear);
	}




	public String deletebyName(String bname) {
		Boolean ans=dao.deletebyName(bname);
		if(ans) {
			return "Book with title '" + bname + "' deleted successfully.";
		}
		else {
			return"Book not found!";
		}
	}




	public String deletebyAuthor(String aname) {
		Boolean ans=dao.deletebyAuthor(aname);
		if(ans) {
			return "Book with Author '" + aname + "' deleted successfully.";
		}
		else {
			return"Book not found!";
		}
	}




	public String deletebyyear(int yearr) {
		Boolean ans=dao.deletebyyear(yearr);
		if(ans) {
			return "Book with Publishing year '" + yearr + "' deleted successfully.";
		}
		else {
			return"Book not found!";
		}
	}




//	public String userpassword(UserPassword u) {
//		Boolean check= dao.userpassword(u);
//		if(check) {
//		return	"New User Created";
//			}
//		else {
//	return	"User was unable to create the account";
//		}
//	}
//
//}
}