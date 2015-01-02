package exam.generic;

public class ShowVarg {

	private int[] myNumber;
	
	public ShowVarg() {
		
	}
	
	public int add(String str, int... args) {
		myNumber = args;
		int sum = 0;
		for(int x : args) {
			sum += x;
		}
		System.out.println(str + myNumber.length + "개의 합계는" + sum);
		return sum;
	}
	
	public static void main(String[] args) {
		ShowVarg varg = new ShowVarg();
		varg.add("첫번째: ", 1,1,2,1,1,1);
		varg.add("두번째: ", 3,2,1,2,12,1,1,1,1);
		varg.add("세번째: ", 3,23,1,12,1,2,1,1,11,1,1,1,1,1,1);
	}

}
