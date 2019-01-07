package LMS;

import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Stack {
	protected NodeReader top;
	protected int size;

	/* Các phương thức khởi dựng */
	public Stack() {
		top = null;
		size = 0;
	}

	/* Function to check if stack is empty */
	public boolean isEmpty() {
		return top == null;
	}

	/* Function to get the size of the stack */
	public int getSize() {
		return size;
	}

	/* Function to check the top element of the stack */
	public NodeReader peek() {
		if (isEmpty()) {
			return top = null;
		}
		return top;
	}

	// Function to push an element to the stack
	public NodeReader push(Reader r) {
		NodeReader node = new NodeReader(r, null);
		if (top == null) {
			top = node;
		} else {
			node.setNext(top);
			top = node;
		}
		size++;
		return node;
	}

	// Function to pop an element from the stack
	public NodeReader pop() {
		if (isEmpty()) {
			System.out.println("Empty...");
			return null;
		} else {
			NodeReader node = top;
			top = node.getNext();
			size--;
			return node;
		}
	}

	public NodeReader searchNode(String rcode) {
		NodeReader node = top;
		int i;
		while (node != null) {
			if (rcode.equals(node.getReader().getRcode())) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}

	public Reader searchReader(Stack s) {
		System.out.println("Vui lòng nhập rcode để tìm reader...");
		Scanner sc = new Scanner(System.in);
		String target = sc.nextLine();
		if (target != null && !target.isEmpty()) {
			NodeReader n = s.searchNode(target);
			if (n != null) {
				System.out.printf("%-10s%s%-20s%s%-10s%s\n", "Rcode", "|", "Name", "|", "Byear", "|");
				n.printNode(n.getReader());
				return n.getReader();
			} else {
				System.out.println("Data not found...");
				return null;
			}
		} else {
			System.out.println("Ko duoc rong");
			return searchReader(s);
		}
	}

	public void printStack() {
		System.out.println("\nStack: ");
		if (size == 0) {
			System.out.println("Empty\n");
		}
		NodeReader nodeR = top;
		System.out.printf("%-10s%s%-20s%s%-10s%s\n", "Rcode", "|", "Name", "|", "Byear", "|");

		while (nodeR != null) {
			nodeR.printNode(nodeR.getReader());
			nodeR = nodeR.getNext();
		}
		System.out.println("...");
	}
}
