package exam.garbage;

public class ExecGarbage {
	int count;
	
	public ExecGarbage(int i) {
		count = i;
		System.out.println("객체생성 : " + count + " " + Runtime.getRuntime().freeMemory());
	}
	
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("객체소멸 : " +count);
	}
}
