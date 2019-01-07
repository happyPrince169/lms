package LMS;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Application {
	private static LinkList l = new LinkList();
	private static Stack s = new Stack();
	private static Stack s2 = new Stack();
	private static Queue q = new Queue();

	public static int choose() {
		Scanner scan = new Scanner(System.in);
		try {
			int n = scan.nextInt();
			return n;
		} catch (Exception e) {
			// TODO: handle exception
			// menu();
			return choose();
		}
	}

	public static void menu() {
		System.out.println("Menu: ");
		System.out.println("1. Thêm sách vào đầu list");
		System.out.println("2. Thêm sách vào cuối list");
		System.out.println("3. Chèn sách vào sau vị trí k trong list");
		System.out.println("4. Tìm sách theo bcode");
		System.out.println("5. Xóa sách tại vị trí k trong list");
		System.out.println("6. Display danh sách book");
		System.out.println("7. Thêm reader vào stack");
		System.out.println("8. Tìm và xóa reader trong stack");
		System.out.println("9. Tìm reader trong stack");
		System.out.println("10. Display danh sách reader");
		System.out.println("11. Thêm lending vào queue");
		System.out.println("12. Display danh sách lending");
		System.out.println("13. Exit");
	}

	public static Book addBook() {
		Book book = new Book();
		System.out.println("Vui lòng nhập bcode");
		book.setBcode(Adding.validateBcode(l));
		System.out.println("Vui lòng nhập title");
		book.setTitle(Adding.validateTitle());
		System.out.println("Vui lòng nhập số lượng");
		book.setQuantity(Adding.validateQuantity());
		System.out.println("Vui lòng nhập số lượng thuê");
		book.setLended(Adding.validateLended(book.getQuantity()));
		System.out.println("Vui lòng nhập giá tiền");
		book.setPrice(Adding.validatePrice());
		return book;
	}

	public static Reader addReader() {
		Reader reader = new Reader();
		System.out.println("Vui lòng nhập rcode");
		reader.setRcode(Adding.validateRcode(s));
		System.out.println("Vui lòng nhập tên");
		reader.setName(Adding.validateTitle());
		System.out.println("Vui lòng nhập năm sinh");
		reader.setByear(Adding.validateByear());
		return reader;
	}

	public static Lending addLending() {
		Lending lending = new Lending();
		System.out.println("Vui lòng nhập Rcode");
		lending.setRcode(Adding.addRToLending(s));
		System.out.println("Vui lòng nhập Bcode");
		lending.setBcode(Adding.addBToLending(l));
		System.out.println("Vui lòng nhập state");
		lending.setState(Adding.addState());
		return lending;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = 0;
		while (n != 13) {
			menu();
			n = choose();
			switch (n) {
			case 1: // Add to beginning
				Book b1 = new Book();
				b1 = addBook();
				l.addToFirst(b1);
				l.printList();
				break;
			case 2: // add to the end
				System.out.println("Add to the end...");
				Book b2 = new Book();
				b2 = addBook();
				l.addToEnd(b2);
				l.printList();
				break;
			case 3:
				System.out.println("Nhập thông tin sách để chèn vào list");
				Book b3 = new Book();
				b3 = addBook();
				l.insert(b3);
				l.printList();
				break;
			case 4:
				if (!l.isEmpty()) {

					LinkList.searchBook(l);
				} else {
					System.out.println("Không có sách để tìm kiếm");
				}
				break;
			case 5:
				if (!l.isEmpty()) {
					System.out.println("Nhập vị trí muốn xóa");
					l.deleteK(l.addK());
				} else {
					System.out.println("Không có sách để xóa");
				}
				break;
			case 6:
				if (!l.isEmpty()) {
					l.printList();
				} else {
					System.out.println("Không có sách trong danh sách");
				}
				break;
			case 7:
				System.out.println("Push a new reader to the stack...");
				Reader r = new Reader();
				r = addReader();
				s.push(r);
				s.printStack();
				break;
			case 8:
				// System.out.println("Pop an element from the stack.");

				if (!s.isEmpty()) {
					System.out.println("Vui lòng nhập rcode để tìm kiếm và xóa...");
					Scanner sc = new Scanner(System.in);
					String rcode = sc.nextLine();
					if (rcode != null && !rcode.isEmpty()) {
						NodeReader sNode = s.searchNode(rcode);
						if (sNode != null) {
							NodeReader node = s.peek();
							while (!rcode.equals(node.getReader().getRcode())) {
								NodeReader popNode = s.pop();
								s2.push(popNode.getReader());
								node = node.getNext();
							}
							s.pop();
						} else {
							System.out.println("Data not found...");
						}
					} else {
						System.out.println("Ko nhập");
					}
					NodeReader pushNode = s2.peek();
					while (pushNode != null) {
						NodeReader popNode = s2.pop();
						s.push(popNode.getReader());
						pushNode = pushNode.getNext();
					}
				} else {
					System.out.println("Stack rỗng");
				}
				break;
			case 9:
				if (s.isEmpty()) {
					System.out.println("Không có reader để tìm kiếm");
				} else {
					System.out.println("Searching...");
					s.searchReader(s);
				}
				break;
			case 10:
				if (s.isEmpty()) {
					System.out.println("Danh sách rỗng");
				} else {
					s.printStack();
				}

				break;
			case 11:
				if (l.isEmpty() || s.isEmpty()) {
					System.out.println("Không có sách hoặc ko có reader");
				} else {
					Lending ld = new Lending();
					ld = addLending();
					q.enqueue(ld);
					q.displayQueue();
				}
				break;
			case 12:
				if (q.isEmpty()) {
					System.out.println("Danh sách rỗng");
				} else {
					q.displayQueue();
				}

				break;
			case 13:
				System.out.println("Exit");
				break;
			}
		}
	}
}
