package newlibrary;

import java.util.Scanner;

public class main1 {
	static Scanner input = new Scanner(System.in);

	public static Library library1 = new Library();

	public static void main(String[] args) {
		run();

	}

	private static void run() {
		int options = 0; 
		do {

			System.out.println();
			System.out.println();
			System.out.println("                      ***  Welcome to our library system  ***               ");
			System.out
					.println("   *** Please choose one of the options below by typing the corresponding number... ***");
			System.out.println(
					"  -------------------------------------------------------------------------------------------------------------------");
			System.out.println("  1  Check library list. ");
			System.out.println("  2-  Add books to the Library.");
			System.out.println("  3-  Register a customer  ");
			System.out.println("  4-  Borrow a book  ");
			System.out.println("  5-  Display Borrowed books  ");
			System.out.println("  6-  Search book by author  ");
			System.out.println("  7-  Return a book to the library ");
			System.out.println("  8-  Display registered customers List");
			System.out.println(
					"  9- (This option is for storing custemers and books data ( 15 Books and 6 customers ) )");
			System.out.println(" 10-  Empty the library ");
			System.out.println("  0- Exit.");
			System.out.println(
					"  -------------------------------------------------------------------------------------------------------------------");

			System.out.print("Enter command : ");
			options = input.nextInt();
			input.nextLine();

			try {

				switch (options) {

				case 1:
					if (library1.BookList.isEmpty()) {
						System.out.println("The library is empty please add books to it  !! ");
					} else {

						printLibrary();
					}
					break;

				case 2:

					library1.BookList.add(readBook());
					break;

				case 3:
					addCustemer();
					break;
				case 4:
					Borrow();
					break;
				case 5:
					library1.BorrowedList();
					break;

				case 6:
					searchByAuthor();
					break;
				case 7:
					returning();
					break;
				case 8:
					printCustemers();
					break;
				case 9:
					addBooksAndCustemers();
					break;
				case 10:
					removeAll();

				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		while (options != 0);

		if (options == 0) {
			System.out.println("---- Thank you for using our library system ! ----");

		}

	}

	public static void addCustemer() {
		

		System.out.println("Register customer's name ");
		String name = input.nextLine();
        System.out.println("Register customer's phone number ");
		String phoneNumber = input.nextLine();
		System.out.println("Register custemer's address ");
		String adress = input.nextLine();

		library1.addCustemer(name, phoneNumber, adress);

	}

	public static void searchByAuthor() {
		System.out.println("enter author name");
		String author = input.nextLine();

		// library1.findBookbyAuthor(author);
		library1.PrintBookList(library1.findBookbyAuthor(author));

	}

	public static Book readBook() throws Exception {// i'm assuming this library can't accept reading more than one book
													// with the same title and author

		System.out.println(" Enter book title");

		String BookName = input.nextLine();
		System.out.println(" Enter the name of the author ");
		String AuthorName = input.nextLine();
		System.out.println("  Enter the gener of the book ");
		String genreOfBook = input.nextLine();
		System.out.println(" Enter the name of the publisher ");
		String publisher = input.nextLine();
		System.out.println(" Enter the shelf Number (1..30) ");
		int shelfNumber = input.nextInt();
		while (!library1.ValidShelf(shelfNumber)) {
			System.out.println("  Invalid shelf ");
			System.out.println("  Please Enter the shelf Number you where the book is located  (1..30)");
			shelfNumber = input.nextInt();
		}
		Book book1 = new Book(BookName, AuthorName, genreOfBook, publisher, shelfNumber);
		book1.setTitle(BookName);
		book1.setAuthor(AuthorName);
		book1.setGenre(genreOfBook);
		book1.setPublisher(publisher);
		book1.setShelf(shelfNumber);
		if (library1.checkList(AuthorName) == true && book1.getTitle().equalsIgnoreCase(BookName)) {
			throw new Exception("\"sorry you can't add the same book ! \"");
			// System.out.print(" ");
			// System.out.print("sorry you can't add the same book ! ");
		} else {

		}
		return book1;
	}

	public static void printLibrary()  {
		for (int i = 0; i < library1.BookList.size(); i++) {

			printBook(library1.BookList.get(i));
		}

	}

	public static void printCustemers() {

		if (library1.CustomerList.isEmpty()) {
			System.out.println();
			System.out.println(
					" { The libray doesn't have any registered customers yet. please register customers to it }");
		}
		for (int i = 0; i < library1.CustomerList.size(); i++) {

			printCustemer(library1.CustomerList.get(i));
		}

	}

	private static void Borrow() {
		System.out.println(" please enter customer ID reference 1.." + library1.CustomerList.size());
		int CustemerNumber = input.nextInt();
		while (CustemerNumber < 1 || CustemerNumber > library1.CustomerList.size()) {
			System.out.println("  invalid Customer");
			System.out.println(
					"please enter customer number and make sure your registered 'Customers list' are not empty 1.."
							+ library1.CustomerList.size());
			CustemerNumber = input.nextInt();
		}

		System.out.println("please enter book ID reference " + " 1.." + library1.BookList.size());
		int BookNumber = input.nextInt();

		while (BookNumber < 1 || BookNumber > library1.BookList.size()
				|| !library1.BookList.get(BookNumber - 1).available()) {
			System.out.println("invalid book");
			System.out.println("please enter book number and make sure the book is available in the library 1.."
					+ library1.BookList.size());
			BookNumber = input.nextInt();
			input.nextLine();
		}
		System.out.println();
		System.out.println("The book has been successfully borrowed");

		library1.lend(BookNumber - 1, CustemerNumber - 1);

	}

	public static void removeAll() {
		library1.BookList.clear();
		library1.CustomerList.clear();

		System.out.println(" the Library is empty!");

	}

	public static void returning() {

		System.out
				.println(" please enter the ID of the custoemer borrowing the book 1.." + library1.BookList.size());
		int CustemerNumber = input.nextInt();
		while (CustemerNumber < 1 || CustemerNumber > library1.CustomerList.size()) {
			System.out.println("invalid custemer ");
			System.out.println("please try again 1.. " + library1.BookList.size());
			CustemerNumber = input.nextInt();
		}

		System.out.println(
				" please enter the ID reference of the book you want to return 1.." + library1.BookList.size());
		int BookNumber = input.nextInt();
		while (BookNumber < 1 || BookNumber > library1.BookList.size()) {// checks if the choice is in the range
			System.out.println("invalid Book or the book is already returned");
			System.out.println("please try again and enter a Book number..1 " + library1.BookList.size());
			BookNumber = input.nextInt();

		}

		returnBook(CustemerNumber - 1, BookNumber - 1);

		System.out.println();
		System.out.println(" The book has been successfuly returned ! ");

	}

	public static void returnBook(int custemerNumber, int bookNumber) {

		if (library1.BookList.get(bookNumber).getBorrower().equals(library1.CustomerList.get(custemerNumber))) {
			library1.BookList.get(bookNumber).setBorrower(null);

		}

	}

	public static void printCustemer(Customer custemer) {

		System.out.println("                                          *                                        ");
		System.out.println(" ----------------------------------------------------------------------------------");
		System.out.println("  The name of the custemer with the ID number (" + (library1.CustomerList.indexOf(custemer) + 1)
				+ ") is : " + custemer.getName());
		System.out.println("  The telephone number of this custemer is : " + custemer.getPhoneNumber());
		System.out.println("  The address of the custemer number with the ID (" + (library1.CustomerList.indexOf(custemer) + 1)
				+ ") is  :" + custemer.getAdress());
		System.out.println(" ----------------------------------------------------------------------------------");

	}

	public static void printBook(Book book) {
		//library1.sortByAuthor();
		String s = "";
		String b = "";

		if (book.available()) {
			s = " ((available))";
		} else if (book.unavailable()) {
			b = " ((borrowed)) ";
		}
		//library1.sortByAuthor();

		System.out.println("                                           *                                        ");
		System.out.println(" -----------------------------------------------------------------------------------");
		System.out.println("   The title of book with the ID number (" + (library1.BookList.indexOf(book) + 1) + ")  is : "
				+ book.getTitle() + "     " + s + "  " + b);
		System.out.println("   Written by : " + book.getAuthor());
		System.out.println("   The genre of this book is  : " + book.getGenre());
		System.out.println("   The publisher's name of this book is : " + book.getPublisher());
		System.out.println("   The book is located on the shelf  : " + book.getShelf());
		System.out.println("-------------------------------------------------------------------------------------");
		

	}

	public static void addBooksAndCustemers() {
		library1.addCustemer(" M.jawad mu ", "0761111", " Latakia street number 2");
		library1.addCustemer(" jason bros ", "0762222", " Washington street number 1");
		library1.addCustemer(" sally miller ", "0763333", " Washington street number 3");
		library1.addCustemer(" bill jhonson ", "0764444", " Venice street number 4");
		library1.addCustemer(" carl albert", "0765555", " Damascus street number 5");
		library1.addCustemer("jack black ", "076666", " sunset bolevard street number 6");
		library1.BookList.add(new Book(" The shadow rising ", " don jorddan ", " science fiction ", "  dony ", 4));
		library1.BookList
				.add(new Book(" A million little pieces  ", " james frey  ", " horror  ", " freddy dickson ", 7));
		library1.BookList.add(new Book(" A room of one's own ", " virgenia woold " + "", " Drama ", " joe martin ", 1));
		library1.BookList.add(new Book(" The lord of the rings ", " jt auston ", " epic ", " sami", 2));
		library1.BookList.add(new Book(" 7 deadly sins ", "corey taylor ", "fantasy", "corey taylor", 3));
		library1.BookList.add(new Book("", " the pick of destiny ", " jack black  ", " kyle gas ", 4));
		library1.BookList.add(new Book(" Hary potter ", "j.k rawling ", "science fiction ", " joey", 1));
		library1.BookList.add(new Book(" Twilight ", " Stepanie mayer ", " fantasy ", " Martin ", 1));
		library1.BookList.add(new Book("white noise ", "Don Delillio ", " Story  ", " london daily  ", 5));
		library1.BookList.add(new Book(" The Jungle ", "  Upton Sinclair ", " horror  ", " unknown ", 1));
		library1.BookList.add(new Book(" The Hunt for Red October ", "Tom Clancy  ", " drama ", " unknown ", 1));
		library1.BookList.add(new Book(" The Martian ", " Andy Weir ", "action ", " unknown ", 1));
		library1.BookList.add(new Book(" The Neverending Story  ", " Michael Ende ", " epic  ", " steve jones ", 1));
		library1.BookList.add(new Book(" Smoke and Mirrors: Short Fictions and Illusions ", " Neil gaiman ",
				" fantacy ", "publisher", 1));
		library1.BookList
				.add(new Book(" Gravity's Rainbow ", " Thomas Pynchon ", " real life story ", " jack thomson", 1));

		System.out.println();
		
		System.out.println("You have stored data in the library ...");
	}
}
