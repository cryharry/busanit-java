package exam.kita;

public class StdInner {

	// 멤버변수
	private int ox = 10;
	private static int oy = 20;
	
	public void printVal() {
		System.out.println("외부클래스 ox: " + ox);
		System.out.println("외부클래스 oy: " + oy);
	}

	// 내부 클래스
	class ExamInner {
		private int ix = 30;
		private int iy = 40;
		
		public void printVal() {
			System.out.println("내부클래스 ix: " + ix);
			System.out.println("내부클래스 iy: " + iy);
			System.out.println("외부클래스 ox(내부): " + ox);
			System.out.println("외부클래스 oy(내부): " + oy);
		}
	}
	
	static class ExamInner2 {
		private int ix2 = 50;
		private int iy2 = 60;
		private static int iz = 70;
		
		public void printVal() {
			System.out.println("ix2: " + ix2);
			System.out.println("iy2: " + iy2);
			
//			System.out.println("ox: " + ox); //<--에러 non-static
			System.out.println("oy: " + oy);
		}
		
		public static void printVal2() {
			System.out.println("iz: " + iz);
			System.out.println("oy: " + oy);
		}
	}
	
	public static void main(String[] args) {
		// 1. 외부클래스 인자의 호출
		StdInner si = new StdInner();
		si.printVal();

		// 2. 내부클래스 인자의 호출
		//ExamInner ei = new ExamInner();
		StdInner.ExamInner siei = si.new ExamInner();
		siei.printVal();
		
		StdInner.ExamInner siei2 = new StdInner().new ExamInner();
		siei2.printVal();
		
		// 3. Static 내부클래스의 호출
		StdInner.ExamInner2 siei3 = new ExamInner2();
		siei3.printVal();
		
		//siei3.printVal2();
		StdInner.ExamInner2.printVal2();
	}

}
