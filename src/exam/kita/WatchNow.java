package exam.kita;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class WatchNow extends Frame implements ActionListener, Runnable{

	

	TextField tf;
	Button bt, bt2;
	boolean timeshot = false;
	public WatchNow()
	{
		tf  = new TextField(30);
		bt =  new Button("시작");
		bt2 = new Button("정지");
		tf.setText("");
		bt.addActionListener(this);
		bt2.addActionListener(this);
		
		this.setLayout(new FlowLayout());
		this.add(tf,"East");
		this.add(bt,"West");
		this.add(bt2,"West");
		this.setSize(300,300);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt)
		{
			TimeStart();
		}
		else
			TimeStop();
			
	}
	public void TimeStart() {
		timeshot = true;
		Thread t = new Thread(this);
		t.start();
	}
	public void TimeStop() {
		timeshot = false;
	}


	public void run() {
	
		for(; ;)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			CurrentTime ct = new CurrentTime();
			tf.setText(ct.getTime());
		}
	}
	
	public static void main(String[] args) {
		new WatchNow();	
	}
}
