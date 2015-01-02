package exam.kita;

public class AnnoyInner implements MyInter {
	// 멤버변수
	int ox = 10;
	
	// 생성자
	public AnnoyInner() {
		
	}
	public void printValue() {
		new MyInter() {
			public void printVal() {
				System.out.println("내부무명클래스에서의 data: " + data);
			}
		}.printVal();
		
		System.out.println("ox + data: " + (ox+data));
	}
	
	public void printVal() {
		System.out.println("ox : " + ox);
	}

	public static void main(String[] args) {
		AnnoyInner ai = new AnnoyInner();
		ai.printVal();
		ai.printValue();
	}

}

interface MyInter {
	int data = 100;
	public void printVal();
}