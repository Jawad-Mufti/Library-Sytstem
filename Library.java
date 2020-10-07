package newlibrary;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Library {

	public ArrayList<Book> BookList;
	public ArrayList<Customer> CustomerList;
	private final int DAYS = 1000 * 60 * 60 * 24;

	public Library() {

		this.BookList = new ArrayList<Book>();
		this.CustomerList = new ArrayList<Customer>();
	}

	public boolean checkList(String Author) {
		boolean check = false;
		for (int i = 0; i < BookList.size(); i++) {

			if (BookList.get(i).getAuthor().equalsIgnoreCase(Author)) {
				check = true;

			}

		}
		return check;
	}

	public void printCustemerList() {
		for (int i = 0; i < CustomerList.size(); i++) {

			if (CustomerList.size() == 0) {
				System.out.println("The libray is empty please register custemers to it to it");
			} else {

				printCustemer(CustomerList.get(i));

			}

		}

	}

	private void printCustemer(Customer custemer) {

		System.out.println("the name of the custemer is " + custemer.getName());
		System.out.println("the phoneNuumber of the custemer is " + custemer.getPhoneNumber());
		System.out.println("the adress of the custemer is " + custemer.getAdress());

	}

	public void addCustemer(String name, String phoneNumber, String adress) {

		Customer cust = new Customer(name, phoneNumber, adress);

		this.CustomerList.add(cust);

	}

	public boolean ValidShelf(int shelf) { // assuming the library has only 30 shelf

		return (shelf <= 30 && shelf > 0);
	}

	public void lend(int BookNumber, int custemerNumber) {
		BookList.get(BookNumber).setBorrower(CustomerList.get(custemerNumber));

		System.out.println("The Book should be returned on " + returnDate(BookNumber));
	}

	public void removeBorrower(int bookN) {

		BookList.get(bookN).setBorrower(null);

	}

	public void BorrowedList() { //  classifies and applies printing of borrowed books 

		for (int i = 0; i < BookList.size(); i++) {
			if (BookList.get(i).getBorrower() != null) {
				printBook(BookList.get(i));
			}

		}

	}

	public String returnDate(int BookNumber) {// returns the date in which the book should be returned
		Date date = new Date();
		date.setTime(date.getTime() + (14 * DAYS));
		SimpleDateFormat timez = new SimpleDateFormat("YYYY-MM-DD");
		return timez.format(date);
	}

	public ArrayList<Book> findBookbyAuthor(String q) {//  searching method 
		ArrayList<Book> result = new ArrayList<Book>();
		for (int i = 0; i < BookList.size(); i++) {

			if (BookList.get(i).getAuthor().contains(q)) {
				result.add(BookList.get(i));
			}
		}
		return result;

	}

	public void PrintBookList(ArrayList<Book> List) {
		for (int i = 0; i < List.size(); i++) {

			printBook(List.get(i));

		}

	}

	public void sortByAuthor() { 
		
	Collections.sort(this.BookList, new Comparator <Book>(){
		public int compare(Book b1, Book b2) {
			int comparasion =1;
			comparasion = b1.getAuthor().compareTo(b2.getAuthor());
			return comparasion;
		}
		
		
	});
		
	}
	public void printBook(Book book) { 

		System.out.println("");
		System.out.println("- The title of book with ID number  " + (BookList.indexOf(book) + 1) + " is : " + book.getTitle());
		System.out.println("");
		System.out.println("- Written by : " + book.getAuthor());
		System.out.println("");
		System.out
				.println("- The genre of the book with the ID number (" + (BookList.indexOf(book) + 1) + ") is : " + book.getGenre());
		System.out.println("");
		System.out.println("- The publisher's name of the book  ID number  (" + (BookList.indexOf(book) + 1) + ") is :"
				+ book.getPublisher());
		System.out.println("");
		System.out.println("- The book with the ID number " + (BookList.indexOf(book) + 1) + " is located on the shelf number :"
				+ book.getShelf());
		System.out.println(" -------------------------------------------------------------------------------------");
		System.out.println("");

	}

}

////
////
