package exam.thread;

class FirstThread extends Thread{
	long toAdd;
	String name;
	
	FirstThread(long t, String n)
	{
		toAdd = t;
		name = n;
	}
	
	public void run()
	{
		long all = 0;
		
		for(int i=0; i<= toAdd; i++)
		{
			try
			{
				sleep(20);
			}
			catch(InterruptedException e) {
			}
			all += i;
			System.out.println(name + " : " + all);
		}
	}
	
	public static void main(String[] args)
	{
		FirstThread t1, t2;
		
		t1 = new FirstThread(5, "첫번째 쓰레드");
		t2 = new FirstThread(5, "두번쨰 쓰레드");
		
		t1.start();
		t2.start();
	}
}
