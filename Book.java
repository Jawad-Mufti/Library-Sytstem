package newlibrary;

import java.util.Date;

public class Book { 
	
	 private String title ;
	private  String Author ;
	private String genre ;
	private String publisher ;
	private int shelf;  
	private Customer Borrower ;
	private Date borrowDate ;
	private Date returnDate ;
	
	public Book() {};
	public Book (String name,String Author,String genre, String publisher ,int shelfReference) {
		this.title= name ;
		this.Author= Author;
		this.genre= genre;
		this.publisher= publisher ;
		this.shelf = shelfReference ;
	
	}

	
	
public String toString() {
 String result =
            	   "\n the title of the book is " + getTitle() +
                "\n the author of the book is  " + getAuthor() +
                "\n the genre of the book is "   +  getGenre()+
                "\n the publisher's name of the book is" +getPublisher() +
                "\n the book is located on the chelf " +getPublisher() ;

 return result ;
}
	

	
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title ;
	}
	public int getShelf() {
		
		return shelf ;
	}
	
	public Date getReturnDate() {
		return returnDate;
	}
	
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	/**
	 * @return the borrowDate
	 */
	public Date getBorrowDate() {
		return borrowDate;
	}
	
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	
	public Customer getBorrower() {
		return Borrower;
	}
	
	public void removeB(Customer Borrower) {
		
		Borrower = null ;
	}
	public void setBorrower(Customer borrower) {
		Borrower = borrower;
	}
	public boolean available() {
		
		return Borrower== null ;
		
	}
public boolean unavailable() {
		
		return Borrower!= null ;
		
	}
	public void setShelf(int shelfNumber) {
    this.shelf= shelf;		
	}

   public boolean returnable () { // use in the main
	return Borrower!= null; 

	}
   public int compareTo(Book newBook) {
		return this.getAuthor().compareToIgnoreCase(newBook.getAuthor())  ;
	}
  
	}
	


