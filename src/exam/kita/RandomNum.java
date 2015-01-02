package exam.kita;

import java.util.Random;

public class RandomNum {

	/*
	public static void main(String[] args) {
		Random r = new Random();
		int i = (int)(Math.random()*100);
		System.out.println("0~100 범위의 임의 숫자는 " + i);
		
		i = r.nextInt(1000);
		System.out.println("0~1000 범위의 임의 숫자는 " + i);
		
		float f = r.nextFloat();
		System.out.println("임의 숫자는 " +f);
	}
	*/
	public static void main(String[] args) {
		
		Random r = new Random();
		System.out.println("nextInt(): " + r.nextInt());
		System.out.println("nextFloat(): " + r.nextFloat());
		System.out.println("nextDouble(): " + r.nextDouble());
		System.out.println("Math.random(): " + (int)(Math.random()*10) );
		
		r.setSeed(10);
		for(int i=0; i<5; i++)
			System.out.println("seed=10: " + r.nextInt(10));
		
		r.setSeed(100);
		for(int i=0; i<5; i++)
			System.out.println("seed=100: " + r.nextInt(100));
		
		r.setSeed(1000);
		for(int i=0; i<5; i++)
			System.out.println("seed=1000:" + r.nextInt(1000));
	}

}
