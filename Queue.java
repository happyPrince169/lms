package LMS;

public class Queue {
	protected NodeQueue front;
	protected NodeQueue rear;
	protected int size;

	public Queue() {
		front = null;
		size = 0;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public int getSize() {
		return size;
	}

	public NodeQueue enqueue(Lending ld) {
		NodeQueue nq = new NodeQueue(ld);
		nq.setNext(front);
		front = nq;
		size++;
		return nq;
	}

	public NodeQueue dequeue() {
		if (isEmpty()) {
			System.out.println("Empty...");
			return null;
		} else {
			NodeQueue node = front;
			while (node.getNext().getNext() != null) {
				node = node.getNext();
			}
			node.setNext(node.getNext().getNext());
			size--;
			return node;
		}
	}

	public void displayQueue() {
		NodeQueue nq = front;
		System.out.printf("%-10s%s%-20s%s%-10s%s\n", "Rcode", "|", "Bcode", "|", "State", "|");
		while (nq != null) {
			nq.printNode(nq.getLending());
			nq = nq.getNext();
		}
		System.out.println("...");
	}
}
