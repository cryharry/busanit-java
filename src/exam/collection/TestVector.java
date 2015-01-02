package exam.collection;
import java.io.*;
import java.util.*;

public class TestVector {

	public static void main(String[] args) {
		Vector v;
		v = new Vector();
		BufferedReader br = null;
		
		String str1 = "김혜수";
		String str2 = "서민정";
		String str3 = "전지현";
		String str4 = "김태희";
		String s = "";
		
		v.add(str1);
		v.add(str2);
		v.add(str3);
		v.add(str4);
		
		System.out.println("이름을 입력하세요: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		try 
		{
			s = br.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		if(v.contains(s))
		{
			int i = v.indexOf(s) + 1;
			int j = v.size();
			System.out.println("전체 객체의 수는 " + j);
			System.out.println("해당 객체가 " + i + "번째에 있습니다");
		}
		else
			System.out.println("해당객체가 없습니다요");
				

	}

}

