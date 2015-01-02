package exam.thread;

public class MainData {
	
	int data;
	
	public synchronized void up(String name) {
		System.out.print(name + "가 " +data);
		data++;
		System.out.println("를 " + data + "로 증가시킴");
	}
	
	public synchronized void down(String name) {
		System.out.print(name+ "가 " +data);
		data--;
		System.out.println("를 " + data +"로 감소시킴");
	}

	public static void main(String[] args) {
		MainData m = new MainData();
		IncThread t1;
		DecThread t2;
		
		t1 = new IncThread(m,2,"증가 쓰레드");
		t2 = new DecThread(m,3,"감소 쓰레드");
		
		t1.start();
		t2.start();
	}

}

class DecThread extends Thread {
	
	MainData m;
	int toAdd;
	String name;
	

	DecThread(MainData m, int i, String string) {
		// TODO 자동 생성된 생성자 스텁
		this.m = m;
		this.toAdd = i;
		this.name = string;
	}
	
	public void run() {
		for(int i=0; i<toAdd;i++) {
			try {
				sleep(5);
			} catch (InterruptedException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
			
			m.down(name);
		}
	}
	
}

class IncThread extends Thread {
	
	MainData m;
	int toAdd;
	String name;

	IncThread(MainData m, int i, String string) {
		// TODO 자동 생성된 생성자 스텁
		this.m = m;
		this.toAdd = i;
		this.name = string;
	}
	
	public void run() {
		for(int i=0; i<toAdd; i++) {
			try {
				sleep(5);
			} catch (InterruptedException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
			
			m.up(name);
		}
	}
	
}