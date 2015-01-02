package exam.generic;
import java.util.*;

public class ExtFor {

	public static void main(String[] args) {
		String[] arrName = {"김희선", "강혜정", "성윤아", "고소영"};
		
		List oldList = new Vector();
		oldList.add("헤헤헤");
		oldList.add("하하하");
		
		List<String> newList = new Vector<String>();
		newList.add("첫번째");
		newList.add("두번째");
		
		for(String str: arrName) {
			System.out.println(str);
		}
		
		for(Object obj: oldList) {
			System.out.println((String)obj);
		}
		
		for(String str2: newList) {
			System.out.println(str2);
		}
	}

}
