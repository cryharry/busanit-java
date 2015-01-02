package exam.collection;
import java.util.*;

public class ShowQue {

	public static void main(String[] args) {
		Queue myQue = new LinkedList();
		
		String str1 = "1-김혜수";
		String str2 = "2-서민정";
		String str3 = "3-전지현";
		String str4 = "4-김태희";
		
		myQue.offer(str1);
		myQue.offer(str2);
		myQue.offer(str3);
		myQue.offer(str4);
		
		while(myQue.peek() != null) {
			String val = (String)myQue.poll();
			System.out.println("값은 " + val);
		}
	}

}
