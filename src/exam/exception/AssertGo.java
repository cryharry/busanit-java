package exam.exception;

public class AssertGo {

	public static void main(String[] args) {
		int timer = Integer.parseInt(args[0]);
		
		assert timer > 0 : "timer의 값은 늘 0보다 커야한다.";
		System.out.println("정상임다.");
	}

}
