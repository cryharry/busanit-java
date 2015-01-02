package exam.image;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Anime extends Frame implements Runnable{

	int frame;
	int delay;
	Thread animator;
	Image frameImg[];
	
	public Anime() {
		frame = 0;
		delay = 200;
		frameImg = new Image[10];
		
		for(int i=1; i<frameImg.length; i++) {
			frameImg[i-1] = Toolkit.getDefaultToolkit().getImage("image/image0" +i+ ".jpg");
		}
		
		this.setBackground(Color.red);
		this.setSize(100, 200);
		this.setVisible(true);
		showAnime();
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				System.out.println("프로그램 끝");
				System.exit(0);
			}
		});
	}
	
	public void showAnime() {
		animator = new Thread(this);
		animator.start();
	}
	
	public void run() {
		long tm = System.currentTimeMillis();
		while(true) {
			repaint();
			
			try {
				tm +=delay;
				Thread.sleep(Math.max(0, tm - System.currentTimeMillis()));
			} catch (InterruptedException e) {
				break;
			}
			
			frame++;
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(frameImg[frame % 10], 0, 50, this);
	}
	
	public boolean imageUpdate(Image img, int flags, int x, int y, int w, int h) {
		if((flags & ALLBITS) !=0) {
			repaint();
		}
		return (flags & (ALLBITS | ERROR)) ==0;
	}
	
	public static void main(String[] args) {
		Anime a = new Anime();
	}

}
