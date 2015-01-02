package exam.abs;
interface ExamInterface {
	public static final int iNum = 100;
	public int iNum2 = 60;
	String strTitle = "인터페이스의 연습";
	
	// iNum과 iNum2의 값을 출력
	public abstract void printNum();
	// 던져진 정수배열에 두번째 인자로 주어진 정수만큼의 난수를 배열로 반환한다.
	// ex> createRand(iAry, 10) => 10개의 난수 배열을 반환
	public int[] createRand(int p1);
	public String appendStr(String pStr1, String pStr2);
}

class ExamInter implements ExamInterface {

	public String appendStr(String pStr1, String pStr2) {
		String resStr = null;
		resStr = pStr1 + pStr2;
		return resStr;
	}

	public int[] createRand(int p1) {
		int [] pAry = new int[p1];
		for(int i=0; i<pAry.length; i++)
			pAry[i] = (int)(Math.random()* p1);
		return pAry;
	}

	public void printNum() {
		System.out.println("iNum의 값: " +iNum);
		System.out.println("iNum2의 값: " +iNum2);
	}
	
}
public class StdInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1. 인터페이스 호출
		//ExamInterface ei = new ExamInterface(); 
		// 에러 : 인터페이스는 인스턴스화 할 수 없다.
		
		// 2. 인터페이스의 멤버확인
		System.out.println(ExamInterface.iNum);
		System.out.println(ExamInterface.iNum2);
		System.out.println(ExamInterface.strTitle);

		// 3. 인터페이스를 상속(구현)받은 클래스에서 호출
		ExamInter ei = new ExamInter();
		int iAry[] = ei.createRand(10);
		
		for(int i=0; i<iAry.length; i++)
			System.out.println(iAry[i]);
		
		ei.printNum();
		System.out.println(ei.appendStr("인터페이스는 " , "확실히 이해했습니다"));
	}

}
