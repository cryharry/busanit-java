/*
	[Exception처리의 학습]
	
	<에러의 종류>
	에러	- 문법에러(Compile Error)
	
			- 실행에러(Runtime Error)
				-> 논리에러 : 잘못된 프로그램
				-> 시스템에러 : 프로그래머가 제어불가능한 에러
				-> 예외사항 : 정상적인 프로그램 진행에서 발생하는 예측가능한 에러
	
	<예외 클래스의 계층구조>
		- 최상위 클래스 : java.lang.Throwable
		- Error : 쓰레드나 시스템관리 관련 에러
		- Exception -> RuntimeException
									: 실행시 발생하는 예외사항.
									: 실행전에는 알 수 없기때문에 명시적으로 예외처리를 요구하지 않는다.
										얘> ArithmeticException, ArrayBoundOutOfException,NullPointException
		
							-> 기타 Exception 
									: 반드시 예외처리를 해야하는 예외사항. (현재 70여개)
									
	<예외 처리를 하는 방법>
	1. throws를 사용
	2. try~catch절을 사용
	
	<finally블럭이란>
	1. try메소드의 실행과 상관없이 무조건 수행되는 블럭
	2. 프로그램 수행지 자원을 해제해야 하는 경우에 사용.
		예> File의 close(), Database의 close()
		
	<예외클래스 관련 메소드>
	1. getMessage()
	2. printStackTrace()
	3. printStaceTrace(PrintStream)
	
 */

package exam.exception;

public class StdException {

	public static void main(String[] args) {
		// 1. throw의 예외처리
//		for(int i=5; i<6; i--) {
//			TestThrows(i);
//		}
		
		// 2. try~catch
		for(int i=5; i>-1; i--) {
			TestTry(i);
		}
	}
	
	// 1.throws
	public static void TestThrows(int j) throws ArithmeticException {
		int i=10;
		System.out.println("실행블럭 진입: i=" +i+ " j=" +j);
		System.out.println("i/j=" + (i/j));
		
	}
	
	// 2. try ~ catch
	public static void TestTry(int j) {
		int i=10;
		System.out.println("실행블럭 진입: i=" +i+ " j=" +j);
		try {
			System.out.println("i/j=" + (i/j));
		} catch(ArithmeticException e) {
			System.out.println("나누기는 0을 사용할 수 없습니다.");
			e.printStackTrace();
			System.out.println(e.toString());
		} finally {
			System.out.println("여기는 무조건 수행구간입니다.");
		}
	}

}
