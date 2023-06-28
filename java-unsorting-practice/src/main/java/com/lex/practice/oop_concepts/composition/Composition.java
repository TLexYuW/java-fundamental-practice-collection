package com.lex.practice.oop_concepts.composition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lex Yu
 * @date : 2023/6/28
 */
// Class 1
//  Book
class Book {

	// Attributes of book
	public String title;
	public String author;

	// Constructor of Book class
	Book(String title, String author) {

		// This keyword refers to current instance itself
		this.title = title;
		this.author = author;
	}
}

// Class 2
class Library {

	// Reference to refer to list of books
	private final List<Book> books;

	// Library class contains list of books
	Library(List<Book> books) {

		// Referring to same book as
		// this keyword refers to same instance itself
		this.books = books;
	}

	// Method
	// To get total number of books in library
	public List<Book> getTotalBooksInLibrary() {
		return books;
	}
}

public class Composition {
	public static void main(String[] args) {

		// Creating objects of Book class inside main()
		// method Custom inputs
		Book b1 = new Book("EffectiveJ Java", "Joshua Bloch");
		Book b2 = new Book("Thinking in Java", "Bruce Eckel");
		Book b3 = new Book("Java: The Complete Reference", "Herbert Schildt");

		// Creating the list which contains number of books
		List<Book> books = new ArrayList<Book>();

		// Adding books
		// using add() method
		books.add(b1);
		books.add(b2);
		books.add(b3);

		Library library = new Library(books);

		// Calling method to get total books in library
		// and storing it in list of user0defined type - Books
		List<Book> bks = library.getTotalBooksInLibrary();

		// Iterating over books using for each loop
		for (Book bk : bks) {
			// Printing the title and author name of book on console
			System.out.printf("""
					Title : %s and Author : %s
					""", bk.title, bk.author);
		}
	}
}
