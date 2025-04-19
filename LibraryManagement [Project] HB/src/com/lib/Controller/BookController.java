package com.lib.Controller;

import java.util.List;

import com.lib.Entity.Book;
import com.lib.Entity_user.UserPassword;
import com.lib.Service.BookService;

public class BookController {
	private BookService bs=new BookService();//global var to use everywhere
	
	public String insertBook(Book b) {
		
		
		return bs.insertBook(b);
		
	}

	public List<Book> searchbookbyauthor(String author) {
		
		return bs.searchbookbyauthor(author);
	}

	public List<Book> getallbooks() {
		return bs.getallbooks();
		
	}

	public List<Book> searchbytitlekeyword(String searchkey) {
		return bs.searchbytitlekeyword(searchkey);
		
	}

	public List<Book> searchbyYear(int searchyear) {
		
		return bs.searchbyYear(searchyear);
		}

	public String deletebyName(String bname) {
	return	bs.deletebyName(bname);
		
	}

	public String deletebyAuthor(String aname) {
		return	bs.deletebyAuthor(aname);
	}

	public String deletebyyear(int yearr) {
		return bs.deletebyyear(yearr);
	}


}