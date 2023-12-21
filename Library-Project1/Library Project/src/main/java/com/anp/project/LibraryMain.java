package com.anp.project;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

 //The LibraryMain class serves as the main entry point of the application
 // demonstrating the usage of LibraryDAO to interact with the database.

public class LibraryMain {

	// The main method demonstrating database interactions using LibraryDAO
	
			public static void main(String []a) {
			EntityManagerFactory factory = null;
				
		   try { 
			//connecting to database using persistence unit "ks" .
					factory  = Persistence.createEntityManagerFactory("ks");
					EntityManager em = factory.createEntityManager();
					
					
	    System.out.println("-----WELCOME TO BOOKSTORE DATABASES-----");
		  
	 // Creating instances of Library and adding them to the database.
	    
		  Library book1 = new Library(11, "Thinking,fast and slow" , "Dainel Kahneman ", 599.0 , 30);
		  Library	book2 = new Library(12, "Sapiens" , "YualNoh Harai", 699.0 , 12);
		  Library book3 = new Library(13, "The power of Habit" , "Charles Duhigg" ,  499.0 , 25);
		  Library book4 = new Library(14, "Becoming" , "Michelle Obama" , 899.0 , 10 );

					

		  LibraryDAO bDAO = new LibraryDAO(em);
		  
		  bDAO.createBookStore(book1);
		  bDAO.createBookStore(book2);
		  bDAO.createBookStore(book3);
		  bDAO.createBookStore(book4);
					
      System.out.println("  Data added successfully  ");
					
	  System.out.println("---------------------------------------------");

          	// Updating book details based on ID		
	                 int  newid = 13;
					String newbookname ="The Lean Startup" ;
					String newauthorname = "Eric Ries" ;
					double newprice = 999.0;
					int newstock = 45;
		           
					
			bDAO.UpdateBookStore(newid, newbookname, newauthorname, newprice, newstock);
					
			
			System.out.println(" Data updated successfully ");
			
	     System.out.println("-----------------------------------------------");	
	   
	     
	 // Retrieving book details based on ID and displaying them
         	
	   
			System.out.println(" Book details based on the id  :");
							
							Optional<Library> bk1 = bDAO.getById(1);
							System.out.println(bk1);
							 
							bDAO.getById(1);

							
					// Retrieving details of all the books
		       System.out.println("  Details of all the bookstore  ");	
							
							List<Library> allbk = bDAO.getAll();
			                System.out.println(allbk);
			               
			                  // Removing a record based on ID
							System.out.println("  Data removes based on id : ");
							
							bDAO.removeById(11);
							
							System.out.println(" 11th record is removed ");

							
		System.out.println(" Data removed successfully  ");
			
		System.out.println("-----------------------------------------------");	

		 
						}
		   
		   
				catch (HibernateException e) {
							 e.printStackTrace();
			//				 System.out.println(" Hibernate exception ");
						}
				catch (Exception e) {
						 e.printStackTrace();
				//		 System.out.println(" Exception ");
						}
		   
		   finally {
	            if (factory != null) {
	                factory.close();     // Closing the EntityManagerFactory
	            }

		        	}
			}
}

	


