package LMS;

public class Reader {
	private String rcode;
	private String name;
	private int byear;

	public Reader() {
		rcode = "";
		name = "";
		byear = 0;
	}

	public Reader(String rcode, String name, int byear) {
		this.rcode = rcode;
		this.name = name;
		this.byear = byear;
	}

	public String getRcode() {
		// TODO Auto-generated method stub
		return rcode;
	}

	public String getName() {
		return name;
	}

	public int getByear() {
		return byear;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setByear(int byear) {
		this.byear = byear;
	}

}
