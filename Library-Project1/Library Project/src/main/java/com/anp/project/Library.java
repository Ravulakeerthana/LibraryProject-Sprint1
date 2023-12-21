package com.anp.project;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// The Library class represents a book entity in the Library.
// It is mapped to a database table named "book" by using Jakarta.Persistence API annotations.


@Entity
@Table (name = "book")
public class Library {
	
    @Id              //The unique identifier for a book.
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int bookid;
    
	private String bookname;              //The name of the book.
	
	@Column (name = "book _author")
	private String authorname;            //The name of the author of the book.
	
	private double price;                //The price of the book.
	 
	private int stock;                   //The Stock quantity of the book available in the Library.
	
	
	
//           **getters, setters, constructors, and toString method. **
	
	
	
	      // Getters and setters for book attributes
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
 // Overrides the toString method to provide a string representation of the Library object.	
	
	@Override
	public String toString() {
		return "BookStore [bookid=" + bookid + ", bookname=" + bookname + ", authorname=" + authorname + ", price="
				+ price + ", stock=" + stock + "]";
	}
	
// Constructor are Constructs a new Library with the specified attributes.
	
	public Library(int bookid, String bookname, String authorname, double price, int stock) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.authorname = authorname;
		this.price = price;
		this.stock = stock;  
			
	}
	
//Constructs a new  Library  with default values
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	
		 
	}
	
}
