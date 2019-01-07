package LMS;

public class Link {
	private Book book;
	private Link nextLink;

	// constructor
	public Link(Book b) {
		this(b, null);
	}

	public Link(Book b, Link n) {
		book = b;
		nextLink = n;
	}

	// Print Link data
	public void printLink() {
		System.out.printf("%-10s%s%-20s%s%-10s%s%-10s%s%-15s%s%-15s\n", book.getBcode(), "|", book.getTitle(), "|",
				book.getQuantity(), "|", book.getLended(), "|", book.getPrice(), "|",
				book.getPrice() * book.getQuantity());
	}

	// access to fields
	public Book getBook() {
		return book;
	}

	public Link getNext() {
		return nextLink;
	}

	// modify fields
	public void setBook(Book b) {
		book = b;
	}

	public void setNext(Link n) {
		nextLink = n;
	}
}
