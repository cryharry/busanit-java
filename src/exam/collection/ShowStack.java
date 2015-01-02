package exam.collection;
import java.util.*;

public class ShowStack {

	public static void main(String[] args) {
		Stack myStack = new Stack();
		String str1 = "1-김혜수";
		String str2 = "2-서민정";
		String str3 = "3-전지현";
		String str4 = "4-김태희";
		
		myStack.push(str1);
		myStack.push(str2);
		myStack.push(str3);
		myStack.push(str4);
		
		while(!myStack.isEmpty()) {
			String val = (String)myStack.pop();
			System.out.println("값은 " + val);
		}
	}

}
