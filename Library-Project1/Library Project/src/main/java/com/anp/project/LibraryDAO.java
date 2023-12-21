package com.anp.project;

import java.util.List;
import java.util.Optional;

//import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

//The LibraryDAO class serves as a Data Access Object (DAO) to perform CRUD operations.
// related to the Library entity using Jakarta.Persistence API and EntityManager.

public class LibraryDAO {
	
	
	private EntityManager em;      //The EntityManager used for database interaction.

	public LibraryDAO(final EntityManager em) {

		this.em = em;
}
	
	
	public void createBookStore(final Library Book) {
		
 // Method implementation to persist a new Library entity in the database.
		
		EntityTransaction tx = null;
		
		try {
			tx = em.getTransaction(); // Return the resource-level EntityTransaction object

			if (!tx.isActive()) // Indicate whether a resource transaction is in progress.
			{
				tx.begin();
			}
			
		Library mergedBookStore = em.merge(Book);
		
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
  public void UpdateBookStore( int id, String newbookname, String newauthorname, double newprice, int newstock) {  
		 
	// Updates an existing Library entity in the database based on the provided ID
	     // with new attribute values.	 
		 
			EntityTransaction tx = null; 
			try {
			tx = em.getTransaction(); // Return the resource-level EntityTransaction object

			if (!tx.isActive()) // Indicate whether a resource transaction is in progress.
			{
				tx.begin();
			}
			Library b1 = em.find(Library.class, id) ;
			
		//	The ID of the Library entity to be updated.
		    
			if(b1 !=null) {
				b1.setBookname(newbookname);         //The new name of the book
				b1.setAuthorname(newauthorname);     //  The new author's name.
				b1.setPrice(newprice);                //The new price of the book.
				b1.setStock(newstock);              //The new stock quantity of the book.
			    
				
				em.merge(b1); //merger the changes
				tx.commit(); 
			}
			  
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	 
		public Optional<Library> getById(int id) {
			
	 // Method implementation to retrieve a Library entity by ID from the database
	 // Returns an Optional containing the retrieved entity or an empty Optional if not found.
			
			Library t = em.find(Library.class, id);

			if (t != null) {
			return Optional.of(t);
		} else {
			return Optional.empty();
		}
	}	
		
			
		public List<Library> getAll() {

	//  Method implementation to retrieve all Library entities from the database
    //  Returns a List<Library> containing all entities.
			
			List<Library> t1 = em.createQuery("from Library", Library.class).getResultList();

			return t1;
		}
			
		
		
		public void removeById(int id) {  //removing  based on id 
			// Method implementation to remove a Library entity by ID from the database.
			EntityTransaction tx = null; 
			
			Library tr = em.find(Library.class, id);  
			
			try {
				
				tx = em.getTransaction(); // Return the resource-level EntityTransaction object

		if (!tx.isActive()) // Indicate whether a resource transaction is in progress.
				{
					tx.begin();
					}
					em.remove(tr);
					tx.commit();
				}
			
		catch (Exception e) {
		    e.printStackTrace(); 
				}	
			}
		
}
	