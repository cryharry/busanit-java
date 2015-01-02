/*
 	[추상클래스]
 	- abstract 키워드 사용 : 실체가 없는 추상적 클래스
 		추한상태 -> 미완성 ==> 완성은 자식클래스
 	- 인스턴스 생성 불가 (new 연산자 사용안됨),
 		실체가 없는 메소드(추상메소드)를 하나 이상 가짐.
 	- 상위클래스에서 메소드의 내용 정의하지 않고,
 		하위클래스에서 반드시 메소드의 재정의를 하여야 함.
 	- 클래스내에 추상메소드로 정의된 메소드가 하나라도 있으며,
 		그 클래스는 추상클래스로 정의하여야 함.
 		
 	[인터페이스]
 	- interface 키워드 사용 : 추상메소드를 가진 클래스 명세서.
 	- 자바에서 다중상속을 가능케 한다.
 	- 객체를 모델링한 클래스가 아니라, 객체가 필요한 기능만 정의한 명세
 	- 인터페이스 상속의 개념 : 구현하다 (implements)
 	- 인터페이스간은 서로 상속이 가능 (extends)
 	
 	[기타제어자]
 	- native : C언어 등 다른 언어의 라이브러리 사용시 사용
 	- synchronized : 쓰레드의 동기화에 사용, 메소드와 멤버변수에 사용 가능
 								synchronized 적용 메소드와 변수는 한번에 한 쓰레드만 접근 가능.
 	- transient : 객체지렬화(Serializable)에서 사용, 멤버변수에만 사용 가능
 	- volatile : 휘발성의 ... 변수의 값이 수시로 변결될 수 있다는 의미
 */

package exam.abs;

abstract class ExamAbstract {
	int iNum;
	String strName;
	abstract void setValue(int iNum, String strName);
	int getNum(){
		return iNum;
	}
	String getName(){
		return strName;
	}
}
class ExecAbstract extends ExamAbstract {

	@Override
	void setValue(int iNum, String strName) {
		// TODO 자동 생성된 메소드 스텁
		this.iNum = iNum;
		this.strName = strName;
	}
	
}
class ExecAbstract02 extends ExamAbstract {

	@Override
	void setValue(int iNum, String strName) {
		// TODO 자동 생성된 메소드 스텁
		this.iNum = iNum * iNum;
		this.strName = strName + "님 행복하세요!";
	}
	
}
public class Stdabstract {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 추상클래스는 인스턴스를 만들 수 없다.
		// ExamAbstract ea = new ExamAbstract();
		
		ExecAbstract exa = new ExecAbstract();
		exa.setValue(10, "김태희");
		System.out.println("이름: " +exa.getName());
		System.out.println("값: " +exa.getNum());
		
		ExecAbstract02 exa02 = new ExecAbstract02();
		exa02.setValue(10,"김태희");
		System.out.println("이름: " +exa02.getName());
		System.out.println("값: " +exa02.getNum());
		
		// 추상클래스의 다행성 연습
		
		ExamAbstract ea []  = new ExamAbstract[4];
		for(int i=0; i<ea.length; i++)
		{
			if(i%2 ==0)
				ea[i] = new ExecAbstract();
			else
				ea[i] = new ExecAbstract02();
			ea[i].setValue(20, "김혜수");
		}
		
		// 출력
		for(int i=0; i<ea.length; i++)
		{
			System.out.print(i+ "번째 객체의 이름은 " +ea[i].getName());
			System.out.println(" 값은 " + ea[i].getNum());
		}
	}

}
