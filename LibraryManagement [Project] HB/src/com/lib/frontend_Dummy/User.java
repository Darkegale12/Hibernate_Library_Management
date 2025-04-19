package com.lib.frontend_Dummy;

import java.util.List;
import java.util.Scanner;
import com.lib.Controller.BookController;
import com.lib.DAO.BookDAO;
import com.lib.Entity.Book;
import com.lib.Entity_user.UserPassword;
import com.lib.maskpassword.mask;

public class User {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookController bc = new BookController(); // Global variable
       // BookDAO pass=new BookDAO();
        
        System.out.println("Welcome to the Central Library");
        System.out.println("Login\n1] New User\n2] Existing User");
        
        int c = sc.nextInt();
        sc.nextLine();  

        if (c == 1) {
            System.out.print("Enter User Name: ");
           // UserPassword u=new UserPassword();
            String username = sc.nextLine();
       
            
            System.out.print("Enter Password: ");
           
            String password = mask.maskPassword();
         
            System.out.println("\nUser Registered Successfully!");
        }
        else {
			System.out.println("Work in progress..!");
		}

        while (true) {  
            System.out.println("\nOperations:\n1] Insert Book\n2] Search by Author\n3] View All Books\n"
            		+ "4] Search by Keywords of book\n5] Search Book by Publishing Year\n6] Delete a Book by its name\n7] Exit");
            int ch = sc.nextInt();
            sc.nextLine(); 
            
            switch (ch) {
                case 1:
                    Book b = new Book();
                    
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    
                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();
                    sc.nextLine(); 
                    
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    
                    b.setTitle(title);
                    b.setAuthor(author);
                    b.setYear(year);
                    b.setIsbn(isbn);
                    
                    String msg = bc.insertBook(b);
                    System.out.println(msg);
                    break;
                
                case 2:
                    System.out.print("Enter Author Name to Search: ");
                    String searchAuthor = sc.nextLine();
                    
                    List<Book> ls = bc.searchbookbyauthor(searchAuthor);
                    if (ls.isEmpty()) {
                        System.out.println("No books found by author: " + searchAuthor);
                    } else {
                        for (Book book : ls) {
                            System.out.println(book);
                        }
                    }
                    break;
                
                case 3:
                    List<Book> allBooks = bc.getallbooks();
                    if (allBooks.isEmpty()) {
                        System.out.println("No books available in the library.");
                    } else {
                        for (Book book : allBooks) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 4:
                	System.out.println("Enter keywords of book title:");
                	String searchkey=sc.nextLine();
                	List<Book>keytitle=bc.searchbytitlekeyword(searchkey);
                	if (keytitle.isEmpty()) {
						System.out.println("No such book found..");
					} else {
						for (Book book : keytitle) {
							System.out.println(book);
						}
					}
                	break;
                case 5:
                	System.out.println("Enter published year of the book:");
                	int searchyear=sc.nextInt();
                	List<Book>yearbook=bc.searchbyYear(searchyear);
                	if (yearbook.isEmpty()) {
						System.out.println("No such book found..");
					} else {
						for (Book book : yearbook) {
							System.out.println(book);
						}
					}
                	break;
                case 6:
                    System.out.println("Enter Choice to delete");
                    System.out.println("1] Delete by Book Name\n2] Delete by Author Name\n3] Delete by Publishing Year");
                    int deletechoice = sc.nextInt();
                    sc.nextLine(); 
                    
                    switch (deletechoice) {
                        case 1:
                            System.out.println("Enter Book Name:");
                            String bname = sc.nextLine();
                            String ans = bc.deletebyName(bname);
                            System.out.println(ans);
                            break;

                        case 2:
                            System.out.println("Enter Author Name:");
                            String aname = sc.nextLine();
                            String anss = bc.deletebyAuthor(aname);
                            System.out.println(anss);
                            break;

                        case 3:
                            System.out.println("Enter Publishing Year:");
                            int yearr = sc.nextInt();
                            String ansss = bc.deletebyyear(yearr);
                            System.out.println(ansss);
                            break;

                        default:
                            System.out.println("Invalid input, try again!");
                    }
                    break; 


                case 7:
                    System.out.println("Exited the Library System");
                    sc.close();
                    return;
                
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
