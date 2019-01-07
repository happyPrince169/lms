package LMS;

public class NodeQueue {
	private Lending ld;
	private NodeQueue nextNode;

	// constructor
	public NodeQueue(Lending l) {
		this(l, null);
	}

	public NodeQueue(Lending l, NodeQueue n) {
		ld = l;
		nextNode = n;
	}

	// print
	public void printNode(Lending l) {
		System.out.printf("%-10s%s%-20s%s%-10s%s\n", l.getRcode(), "|", l.getBcode(), "|", l.getState(), "|");
	}

	public Lending getLending() {
		return ld;
	}

	public NodeQueue getNext() {
		return nextNode;
	}

	public void setLending(Lending l) {
		ld = l;
	}

	public void setNext(NodeQueue n) {
		nextNode = n;
	}
}
