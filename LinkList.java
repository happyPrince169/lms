package LMS;

import java.util.Scanner;

public class LinkList {
	protected Link first;
	protected int size;

	// LinkList constructor
	public LinkList() {
		first = null;
		size = 0;
	}

	// Returns true if list is empty
	public boolean isEmpty() {
		return first == null;
	}

	/* Function to get the size of the list */
	public int getSize() {
		return size;
	}

	// Inserts a new Link at the first of the list
	public void addToFirst(Book b) {
		Link link = new Link(b);
		link.setNext(first);
		first = link;
		size++;
	}

	public void addToEnd(Book b) {
		Link link = new Link(b);
		if (first == null) {
			first = link;
		} else {
			Link current = first;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(link);
		}
		size++;
	}

	public int addK() {
		Link cLink = first;
		System.out.println("Số sách đang có: " + size);
		Scanner sc = new Scanner(System.in);
		// System.out.println("Nhập vị trí muốn xóa");
		int k = sc.nextInt();
		while (k < 1) {
			System.out.println("Invalid input...");
			return addK();
		}
		while (k > size) {
			System.out.println("Invalid input...");
			return addK();
		}
		return k;
	}

	// Add a link after position k
	public void insert(Book b) {
		Link cLink = first;
		Link temp;
		int index = 1;

		if (isEmpty()) {
			System.out.println("List chưa có sách");
			addToFirst(b);

		} else {
			System.out.println("Nhap vi tri muon chen...");
			int k = addK();
			while (cLink != null) {
				if (index == k) {
					// Book b = Adding.addBook();
					Link link = new Link(b);
					System.out.println(cLink.getBook().getBcode());
					temp = cLink.getNext();
					cLink.setNext(link);
					link.setNext(temp);
				}
				cLink = cLink.getNext();
				index++;
			}
			size++;
		}

	}

	// Deletes a link from a linked list at position k.
	public Link deleteK(int k) {

		Link head = first;
		if (head == null) {
			return null;
		} else {
			if (k == 1) {
				first = first.getNext();
				size--;
				return head;
			} else if (k == size) {
				Link l = first;
				while (l.getNext().getNext() != null) {
					l = l.getNext();
				}
				l.setNext(l.getNext().getNext());
				size--;
				return head;
			} else {
				Link l = head;
				for (int i = 0; i < k - 2; i++) {
					l = l.getNext();
				}
				l.setNext(l.getNext().getNext());
				size--;
				return head;
			}
		}
	}

	public void printList() {
		Link currentLink = first;
		System.out.printf("%-10s%s%-20s%s%-10s%s%-10s%s%-15s%s%-15s\n", "Code", "|", "Title", "|", "Quantity", "|",
				"Lended", "|", "Price", "|", "Value");
		while (currentLink != null) {
			currentLink.printLink();
			currentLink = currentLink.getNext();
		}
		System.out.println(" ");
	}

	public Book searchLink(String bcode) {
		Link cLink = first;
		while (cLink != null) {
			if (bcode.equals(cLink.getBook().getBcode())) {
				System.out.println(cLink.getBook().getBcode());
				return cLink.getBook();
			}
			cLink = cLink.getNext();
		}
		return null;
	}

	public static Book searchBook(LinkList l) {
		System.out.println("Vui lòng nhập bcode để tìm kiếm...");
		Scanner sc = new Scanner(System.in);
		String target = sc.nextLine();
		if (target != null && !target.isEmpty()) {
			Book book = l.searchLink(target);
			if (book != null) {
				System.out.printf("%-10s%s%-20s%s%-10s%s%-10s%s%-15s%s%-15s\n", "Code", "|", "Title", "|", "Quantity",
						"|", "Lended", "|", "Price", "|", "Value");
				System.out.printf("%-10s%s%-20s%s%-10s%s%-10s%s%-15s%s%-15s\n", book.getBcode(), "|", book.getTitle(),
						"|", book.getQuantity(), "|", book.getLended(), "|", book.getPrice(), "|",
						book.getPrice() * book.getQuantity());
				return book;
			} else {
				System.out.println("Data not found...");
				return null;
			}
		} else {
			System.out.println("Ko duoc rong");
			return searchBook(l);
		}
	}

}
