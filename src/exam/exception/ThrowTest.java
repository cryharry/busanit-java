package exam.exception;
import java.io.*;

class MyException extends Exception {
	public MyException(Exception e) {
		System.out.println(e.toString()+ "\n" + "나만의 예외가 발생했다.");
	}
	public void printEx() {
		System.out.println("예외발생");
	}
}

public class ThrowTest extends Object {
	
	ThrowTest(String file_name) throws MyException{
		try {
			reading(file_name);
		} catch (Exception e) {
			throw new MyException(e);
		} finally {
			System.out.println("어쨌거나 읽었어요");
		}
	}
	
	public void reading(String file_name)
		throws FileNotFoundException,IOException
	{
		FileReader reader;
		char[] buffer = new char[100];
		
		reader = new FileReader(file_name);
		reader.read(buffer,0,100);
		
		String str = new String(buffer);
		System.out.println("읽은 건 " +str);
		reader.close();
	}

	public static void main(String[] args) {
		try {
			new ThrowTest("image/action.jpg");
		} catch (MyException e) {
			e.printEx();
		}
	}

}
