package exam.collection;
import java.util.*;

public class StdVector {


	public static void main(String[] args) {
		Vector vec = new Vector();
		System.out.println(vec.size());
		System.out.println(vec.capacity());
		
		Vector vec2 = new Vector(5,4);
		System.out.println(vec2.size());
		System.out.println(vec2.capacity());
		
		for(int i=0; i<11; i++) {
			vec.add(i);
			vec2.add(i);
		}
		
		System.out.println("vec의 사이즈: " + vec.size());
		System.out.println("vec2의 사이즈: " + vec2.size());
		
		System.out.println("vec의 용량: " +vec.capacity());
		System.out.println("vec2의 용량: " +vec2.capacity());
		
		Vector vec3 = new Vector(); //용량 10, 증가값 10
		//vec3.add(100);
		vec3.add(new String("박찬호"));
		//vec3.add(new Integer(200));
		vec3.add("설기현");
		vec3.add("박지성");
		
		System.out.println(vec3.firstElement());
		System.out.println(vec3.lastElement());
		
		for(int i=0; i<vec3.size(); i++) {
			//String val = (String)vec3.get(i); <--에러
			//System.out.println(val);
		}
		
		System.out.println(vec3.toString());
		
		String str [] = new String[0];
		String strAry[] = (String[]) vec3.toArray(str);
		
		for(int i=0; i<strAry.length; i++) {
			System.out.println(strAry[i]);
		}
		System.out.println();
		
		Enumeration e = vec3.elements();
		
		while(e.hasMoreElements()) {
			String val = (String)e.nextElement();
			System.out.println(val);
			if(val.equals("박찬호")) {
				System.out.println("있다");
			} else {
				System.out.println("없다");
			}
		}
		
	}

}
