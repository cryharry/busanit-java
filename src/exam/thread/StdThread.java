package exam.thread;

public class StdThread {

	public static void main(String[] args) {
		// 1. 쓰레드 구현의 첫번째 방법
//		ExamThread et = new ExamThread("첫번째", 100);
//		ExamThread et2 = new ExamThread("두번째", 100);
//		ExamThread et3 = new ExamThread("세번쨰", 100);
//		
//		et.start();
//		et2.start();
//		et3.start();
		
		// 2. 쓰레드 구현의 두번째 방법
		ExamRunnable er = new ExamRunnable("첫번째", 100);
		ExamRunnable er2 = new ExamRunnable("두번째", 100);
		ExamRunnable er3 = new ExamRunnable("세번째", 100);
		
		Thread t = new Thread(er);
		t.start();
		Thread t2 = new Thread(er2);
		t2.start();
		Thread t3 = new Thread(er3);
		t3.setPriority(Thread.MAX_PRIORITY);
		t3.start();
	}

}


class ExamThread extends Thread {
	
	private int iNum;
	private String strName;
	
	public ExamThread(String pStr, int pInt) {
		this.iNum = pInt;
		this.strName = pStr;
	}
	
	public void run() {
		for(int i=0; i<iNum; i++) {
			
			if(i ==50 && strName.equals("세번째")) {
				this.yield();
			}
			System.out.println(i + "번째 쓰레드의 이름: " + this.strName + "의 " + this.getName());
		}
	}
}

class ExamRunnable implements Runnable {
	
	private String strName;
	private int iNum;
	
	public ExamRunnable(String pStr, int pNum) {
		this.strName = pStr;
		this.iNum = pNum;
	}
	
	public void run() {
		for(int i=0; i<iNum; i++)
		{
			System.out.println(i + "번째 쓰레드: " + this.strName);
		}
	}
}