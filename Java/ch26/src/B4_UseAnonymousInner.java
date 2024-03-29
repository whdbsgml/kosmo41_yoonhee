interface Printable3 {
	void print();
}

class Papers3 {
	private String con;

	public Papers3(String s) {
		con = s;
	}

	public Printable3 getPrinter() {
		return new Printable3() {
			public void print() {
				System.out.println(con);
			}
		};
		
	}
}

public class B4_UseAnonymousInner {
	public static void main(String[] args) {
		Papers3 p = new Papers3("서류 내용: 행복합니다.");
		Printable3 prn = p.getPrinter();
		prn.print();
	}
}
