package exam.collection;

import java.util.*;

public class SearchVector
{
	public static void main(String args[])
	{
		Vector v;
		v = new Vector();
		
	    String str1 = "김혜수";
	    String str2 = "서민정";
	    String str3 = "전지현";
	    String str4 = "김태희";
	
	    v.add(str1);
	    v.add(str2);
	    v.add(str3);
	    v.add(str4);
	
	    String s = "김태희";
		
		if(v.contains(s))
		{
			int i = v.indexOf(s) + 1;
			int j = v.size();
			System.out.println("전체 객체의 수는 " + j);
			System.out.println("해당 객체가 " + i + "번째에 있습니다");
		}			
		else
			System.out.println("해당 객체가 없습니다요");
	}
}
