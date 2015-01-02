package exam.thread;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GraphicThread extends Frame implements Runnable, ActionListener{

	int num = 500;
	Color color;
	Random r;
	int x, y;
	Button btStart, btStop;
	Panel pNorth;
	GraphicThread gt;
	
	
	public GraphicThread() {
		color = Color.red;
		r= new Random();
		
		pNorth = new Panel();
		btStart = new Button("시작");
		btStop = new Button("정지");
		
		pNorth.add(btStart);
		pNorth.add(btStop);
		add(pNorth,"South");
		btStart.addActionListener(this);
		btStop.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});
		
		gt = this;
		
		this.setSize(200, 200);
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 3, 3);
	}
	
	public void update(Graphics g) {
		g.clipRect(x, y, 3, 3);
		paint(g);
	}

	public void run() {
		Rectangle rec = getBounds();
		for(int i=0; i<num; i++)
		{
			x = r.nextInt(rec.width);
			y = r.nextInt(rec.height);
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Button bt = (Button)e.getSource();
		Thread t = new Thread(gt);
		if(bt == btStart)
		{
			t.start();
		}
		else
		{
			t.stop();
		}
	}
	
	public static void main(String[] args) {
		new GraphicThread();
	}

	
}
