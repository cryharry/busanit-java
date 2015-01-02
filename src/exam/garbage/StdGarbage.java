package exam.garbage;

class ExamGarbage {
	// 멤버변수
	int count;
	String file;
	
	// 생성자
	ExamGarbage(int i) {
		count = i;
		System.out.println("객체생성: " + count);
	}
	
	void setFile(String str) {
		file = str;
	}
	String getFile() {
		return file;
	}
	
	// 객체소멸시 호출
	protected void finalize() throws Throwable {
		super.finalize();
		count = 0;
		file = "Close";
		
		System.out.println("객체소멸: " + count);
		System.out.println("파일은: " + file + "입니다.");
	}
}

public class StdGarbage {

	public static void main(String[] args) {
		// 1.System.gc() 호출에 희한 가비지콜렉팅
//		ExamGarbage eg = new ExamGarbage(1);
//		eg.setFile("Open");
//		System.out.println("파일의 상태는 " + eg.getFile()+ "입니다.");
//		
//		eg =  null;
//		System.gc();
		
		// 2.JVM에 의한 가비지콜렉팅
		ExecGarbage eg[] = new ExecGarbage[3000];
		for(int i=0; i<eg.length; i++) {
			eg[i] = new ExecGarbage(i);
			eg[i] = null;
			
		}
	}

}
