package exam.exception;
import java.io.*;

public class ResolveException extends Object{

	ResolveException(String file_name) {
		reading(file_name);
	}
	
	public void reading(String file_name) {
		FileReader reader = null;
		char[]	buffer = new char[100];
		
		try{
			reader = new FileReader(file_name);
			reader.read(buffer,0,100);
			
			String str = new String(buffer);
			System.out.println("읽은건 " + str);
			
		
		}	catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("읽다가 에러났슈");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new ResolveException("image/action.gif");
	}

}
