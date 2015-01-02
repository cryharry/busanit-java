package exam.collection;

import java.util.*;

public class ShowIter {

	public static void main(String[] args) {
		Vector v;
		v = new Vector();
		
		String str1 = "김혜수";
		String str2 = "서민정";
		String str3 = "전지현";
		String str4 = "김태희";
		String s = "";
		
		v.add(str1);
		v.add(str2);
		v.add(str3);
		v.add(str4);
		
		Iterator iter = v.iterator();
		while(iter.hasNext()) {
			String str = (String)iter.next();
			System.out.println("차례대로: " + str);
		}
	}

}
