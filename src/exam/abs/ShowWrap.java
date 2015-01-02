package exam.abs;
import java.util.*;

public class ShowWrap {
	
	public static String calAdd(Object obj1, Object obj2) {
		String resStr = "";
		
		Integer iCls1 = (Integer)obj1;
		Integer iCls2 = (Integer)obj2;
		
		int iNum1 = iCls1.intValue();
		int iNum2 = iCls2.intValue();
		
		int iRes = iNum1 + iNum2;
		resStr = "" + iRes;
		
		return resStr;
	}

	public static void main(String[] args) {
		boolean bi = true;
		Boolean wrapBi = new Boolean(bi);
		
		int n = 300;
		Integer wrapN = new Integer(n);
		
		float f = (float)300.3;
		Float wrapF = new Float(f);
		
		System.out.println("Wrapper 클래스의 값은 " + wrapBi.toString());
		System.out.println("Wrapper 클래스의 값은 " + wrapN.intValue());
		System.out.println("Wrapper 클래스의 값은 " + wrapF.floatValue());
		
		//오토언박싱
		System.out.println("오토박스의 값은 " + wrapBi);
		System.out.println("오토박스의 값은 " + wrapN);
		System.out.println("오토박스의 값은 " + wrapF);
		
		//오토박싱
		//Float wrapF2 = new Float(400.4f);
		Float wrapF2 = 400.4f;
		Integer wrapN2 = 400;
		System.out.println(wrapF2);
		System.out.println();
		
		System.out.println("calAdd(): " + calAdd(wrapN, wrapN2));
		System.out.println("calAdd(): " + calAdd(500,600));
	}

}
