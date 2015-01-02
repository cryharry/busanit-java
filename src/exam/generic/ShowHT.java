package exam.generic;
import java.util.*;

public class ShowHT {

	public static void main(String[] args) {
		Hashtable<Integer, Integer> ht1 = new Hashtable<Integer, Integer>();
		for(int i=0; i<40; i++) {
			ht1.put(i, 100*i);
		}
		
		for(int i=0; i<5; i++) {
			System.out.println(i+ "의 100배는 " +ht1.get(i));
		}
		
		Hashtable<String, Random> randomT = new Hashtable<String, Random>();
		randomT.put("첫번째", new Random());
		randomT.put("두번째", new Random());
		Random r = randomT.get("첫번째");
		System.out.println("첫번째: " +r.nextInt());
	}

}
