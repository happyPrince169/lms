package LMS;

import java.util.Scanner;

public class Adding {
	// private static LinkList l = new LinkList();
	public static String validateBcode(LinkList l) {
		Scanner sc = new Scanner(System.in);
		String bcode = sc.nextLine();
		if (bcode != null && !bcode.isEmpty()) {
			try {
				if (!l.isEmpty()) {
					if (l.searchLink(bcode) != null) {
						System.out.println("Already exists, please re-enter...");
						return validateBcode(l);
					}
				}
				return bcode;
			} catch (Exception e) {
				System.out.println("Error");
				return validateBcode(l);
			}
		} else {
			System.out.println("Ko duoc rong");
			return validateBcode(l);
		}
	}

	public static String validateRcode(Stack s) {
		Scanner sc = new Scanner(System.in);
		String rcode = sc.nextLine();
		if (rcode != null && !rcode.isEmpty()) {
			try {
				if (!s.isEmpty()) {
					if (s.searchNode(rcode) != null) {
						System.out.println("Already exists, please re-enter...");
						return validateRcode(s);
					}
				}
				return rcode;
			} catch (Exception e) {
				System.out.println("Error");
				return validateRcode(s);
			}
		} else {
			System.out.println("Ko duoc rong");
			return validateRcode(s);
		}
	}

	public static String validateTitle() {
		Scanner sc = new Scanner(System.in);
		String title = sc.nextLine();
		if (title != null && !title.isEmpty()) {

			return title;
		} else {
			System.out.println("Ko được rỗng");
			return validateTitle();
		}
	}

	public static int validateQuantity() {
		Scanner sc = new Scanner(System.in);
		int quantity;
		while (!sc.hasNextInt()) {
			System.out.println("Invalid input\\n Type the integer-type number:");
			return validateQuantity();
		}
		quantity = sc.nextInt();
		return quantity;
	}

	public static int validateLended(int quantity) {
		Scanner sc = new Scanner(System.in);

		int lended;
		while (!sc.hasNextInt()) {
			System.out.println("Invalid input\\\\n Type the integer-type number:");
			return validateLended(quantity);
		}
		lended = sc.nextInt();
		while (lended > quantity) {
			System.out.println("Lended has to be smaller than " + quantity);
			return validateLended(quantity);
		}
		return lended;
	}

	public static double validatePrice() {
		Scanner sc = new Scanner(System.in);
		double price;
		while (!sc.hasNextDouble()) {
			System.out.println("Invalid input\\n Type the double-type number:");
			return validatePrice();
		}
		price = sc.nextDouble();
		return price;
	}

	public static int validateByear() {
		Scanner sc = new Scanner(System.in);
		int byear = 0;
		while (!sc.hasNextInt()) {
			System.out.println("Invalid input\\n Type the integer-type number:");
			return validateByear();
		}
		byear = sc.nextInt();
		if (byear >= 1900 && byear <= 2010) {
			return byear;
		} else {
			System.out.println("Năm sinh chỉ trong khoảng 1900 tới 2010 ");
			return validateByear();
		}
	}

	public static String addRToLending(Stack s) {
		Scanner sc = new Scanner(System.in);
		String rcode = sc.nextLine();
		if (rcode != null && !rcode.isEmpty()) {
			try {

				if (s.searchNode(rcode) != null) {
					System.out.println("Nhập rcode là: " + rcode);
					return rcode;
				}

				System.out.println("Ko tìm thấy reader, vui lòng nhập rcode đã có trong stack...");
				return addRToLending(s);
			} catch (Exception e) {
				System.out.println("Error");
				return addRToLending(s);
			}
		} else {
			System.out.println("Ko duoc rong");
			return addRToLending(s);
		}

	}

	public static String addBToLending(LinkList l) {
		Scanner sc = new Scanner(System.in);
		String bcode = sc.nextLine();
		if (bcode != null && !bcode.isEmpty()) {
			try {
				if (l.searchLink(bcode) != null) {
					System.out.println("Nhập bcode là " + bcode);
					return bcode;
				}
				System.out.println("Nhập rcode đã có trong list");
				return addBToLending(l);
			} catch (Exception e) {
				System.out.println("Không tìm thấy sach, vui lòng nhập lại...");
				return addBToLending(l);
			}
		} else {
			System.out.println("Vui lòng nhập bcode...");
			return addBToLending(l);
		}
	}

	public static int addState() {
		Scanner sc = new Scanner(System.in);
		System.out.println("State chỉ nhận giá trị 0, 1, 2 ");
		int stt = sc.nextInt();
		if (stt <= 2 && stt >= 0) {
			return stt;
		} else {
			System.out.println("State chỉ nhận giá trị 0, 1, 2 ");
			return addState();
		}
	}

}
