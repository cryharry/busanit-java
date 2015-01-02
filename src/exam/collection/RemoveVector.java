package exam.collection;

import java.util.Vector;

public class RemoveVector {

	public static void main(String[] args) {
		Vector v = new Vector();
		String str1 = "1-김혜수";
		String str2 = "2-서민정";
		String str3 = "3-전지현";
		String str4 = "4-김태희";
		
		v.add(str1);
		v.add(str2);
		v.add(str3);
		v.add(str4);
		String val;
		val = (String)v.firstElement();
		System.out.println("첫번째 요소는 " + val);
		
		v.remove(0);
		val = (String)v.firstElement();
		System.out.println("첫번째 요소는 " + val);
		
		v.remove("2-서민정");
		val = (String)v.firstElement();
		System.out.println("첫번째 요소는 " + val);
		
		System.out.println(v.size());
		

	}

}
