package exam.exception;
import java.io.*;

public class WhereAssert {
	
	private int _Speed;

	public static void main(String[] args) {
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		int param=0;
		try {
			param = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		WhereAssert wa = new WhereAssert();
		switch(param) {
			case 1:
				assert wa.speedUp(1) >= 0: "speedUp() 메서드가 이상함\n"
					+ "Speed : " + wa._Speed;
				break;
			case 2:
				wa.doIt(null);
				break;
			case 3:
				System.out.println("성공");
				break;
			default :
				assert false: "1, 2, 3 외의 값이 오면 안되지";
		}
	}

	public int speedUp(int num) {
		_Speed -= num;
		return _Speed;
	}
	
	public void doIt(String test) {
		assert test != null : "억 null 레퍼런스";
		
		System.out.println(test);
	}

}
