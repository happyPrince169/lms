package LMS;

public class NodeReader {
	private Reader rd;
	private NodeReader nextNode;
	
	//constructor
	public NodeReader(Reader r) {
		this(r, null);
	}
	public NodeReader(Reader r, NodeReader n) {
		// TODO Auto-generated constructor stub
		rd = r;
		nextNode = n;
	}
	//Print Link data
	public void printNode(Reader r) {
		System.out.printf("%-10s%s%-20s%s%-10s%s\n", r.getRcode(), "|", r.getName(), "|", r.getByear(), "|");
	}
	//access to fields
	public Reader getReader() {
        return rd;
    }

    public NodeReader getNext() {
        return nextNode;
    }

    // modify fields
    public void setReader(Reader r) {
        rd = r;
    }

    public void setNext(NodeReader n) {
        nextNode = n;
    }
    
}
