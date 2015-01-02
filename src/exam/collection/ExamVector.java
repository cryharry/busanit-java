package exam.collection;
import java.util.*;

class Student {
	private Vector vec = new Vector(4,2);
	private String name;
	
	void setStudent(String str) {
		vec.add(str);
	}
	public String[] findStudent(String str) {
		if(vec.contains(str)) {
			String aryStr[] = (String[])vec.toArray(new String[0]);
			return aryStr;
		} else {
			return null;
		}
	}
	public void printStudent() {
		for(Enumeration e=vec.elements();e.hasMoreElements();) {
			System.out.println(e.nextElement());
		}
	}
}

public class ExamVector {

	public static void main(String[] args) {
		String str[] = {"석진영", "이승주", "정명철", "김동균"};
		String str2[];
		
		Student std = new Student();
		
		for(int i=0; i<str.length; i++) {
			std.setStudent(str[i]);
		}
		
		str2 = std.findStudent("동균");
		if(str2 != null) {
			for(int i=0; i<str2.length; i++) {
				System.out.println(str2[i]);
			}
		} else
			System.out.println("찾는 데이타는 없슴");
		
		std.printStudent();
	}

}
