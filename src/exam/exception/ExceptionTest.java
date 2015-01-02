package exam.exception;

class MyException2 extends Exception {
	public MyException2() {}
	public MyException2(String msg) {
		super("이건 MyException임 : " + msg);
	}
}

public class ExceptionTest {

	public void noArg() throws MyException2 {
		System.out.println("인자가 없는 MyException이 발생했습니다.");
		throw new MyException2();
	}
	
	public void arg() throws MyException2 {
		System.out.println("인자가 있는 MyException이 발생했습니다.");
		throw new MyException2("이건 에럽니다요");
	}
	
	public static void main(String[] args) {
		ExceptionTest et = new ExceptionTest();
		
		try {
			et.noArg();
		} catch (MyException2 e) {
			e.printStackTrace();
		}
		try {
			et.arg();
		} catch (MyException2 e) {
			e.printStackTrace();
		}
	}

}
