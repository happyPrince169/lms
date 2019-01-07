package LMS;

public class Lending {
	private String bc;
	private String rc;
	private int state;

	public Lending() {
		bc = "";
		rc = "";
		state = 0;
	}

	public Lending(String bc, String rc, int state) {
		this.bc = bc;
		this.rc = rc;
		this.state = state;
	}

	public String getRcode() {
		return rc;
	}

	public String getBcode() {
		return bc;
	}

	public int getState() {
		return state;
	}

	public void setRcode(String rcode) {
		this.rc = rcode;
	}

	public void setBcode(String bcode) {
		this.bc = bcode;
	}

	public void setState(int stt) {
		this.state = stt;
	}
}
