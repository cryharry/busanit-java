package exam.thread;

public class ThreadSync {

	public static void main(String[] args) {
		// 비동기처리
//		WareHouse wh = new WareHouse();
//		Producer p = new Producer(wh);
//		Consumer c = new Consumer(wh);
//		
//		p.start();
//		c.start();
		
		// 동기처리
		WareHouseSync whs = new WareHouseSync();
		Producer p = new Producer(whs);
		Consumer c = new Consumer(whs);
		
		p.start();
		c.start();
	}

}


class WareHouse {
	private int data = 0;
	
	public synchronized void get() {
		System.out.println(data  + "만큼 소비하다");
	}
	
	public synchronized void put(int d) {
		this.data = d;
		System.out.println(data + " 만큼 생산하다");
	}
}

class WareHouseSync {
	private int data = 0;
	private boolean chk = false;
	
	public synchronized void get(int d) {
		while(chk == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
		}
		chk = false;
		notifyAll();
		System.out.println(d + " 만큼 소비하다");
	}
	
	public synchronized void put(int d) {
		while(chk == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
		}
		data = d;
		chk = true;
		notifyAll();
		System.out.println(data + " 만큼 생산하다");
	}
	
	public int returndata() {
		return data;
	}
}

class Producer extends Thread {
	
//	private WareHouse w;
	private WareHouseSync w;
	
	public Producer(WareHouseSync w) {
		this.w = w;
		
	}
	
	public void run() {
		for(int i=0; i<10; i++)
		{
			int data = (int)(Math.random()*100+1);
			w.put(data);
			
			try {
				this.sleep((int)(Math.random()*100+1));
			} catch (InterruptedException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread {
	
//	private WareHouse w;
	private WareHouseSync w;
	
	public Consumer(WareHouseSync w) {
		this.w = w;
	}
	
	public void run() {
		for(int i=0; i<10; i++)
		{
			int a = (int)((Math.random()*w.returndata())+1);
			w.get(a);
			
			try {
				this.sleep((int)((Math.random()*100+1)));
			} catch (InterruptedException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
		}
	}
}