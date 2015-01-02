package exam.generic;
import java.util.*;

public class ListNIter {

	public static void main(String[] args) {
		List<String> strList = new Vector<String>();
		strList.add("호호호");
		strList.add("하하하");
//		strList.add(new Object());
//		strList.add(new Integer());
		
		for(Iterator<String> iter = strList.iterator(); iter.hasNext();) {
			String s = iter.next();
			System.out.println(s);
		}
		// 확장For문
		for(String str: strList) {
			System.out.println(str);
		}
		// 기존방식
		for(int i=0; i<strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		
		List<Integer> nList = new Vector<Integer>();
		nList.add(new Integer(100));
		nList.add(200);
		
		for(Iterator<Integer> iter = nList.iterator(); iter.hasNext();) {
			// jdk1.5
			//int n = iter.next();
			//System.out.println(n);
			
			// jdk1.4
			int n2 = iter.next().intValue();
			System.out.println(n2);
		}
	}

}
