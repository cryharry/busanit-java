/*
 *  [이미지 처리]
 *  T(oolkit) A(pplet) G(etImage())
 *  
 *  - getImage() 메소드를 사용할 수 있는 클래스는 Toolkit과 Applet
 *  	--> Graphics클래스의 drawImage() 메소드를 통해서 그리기.
 *  
 *  - Applet은 getImage()를 바로 사용 가능
 *  	ex> Image img = this.getImage("URL경로");
 *  
 *  - Applet이외의 클래스에서는 Toolkit의 getImage() 메소드 사용
 *  	ex> Image img = Toolkit.getDefaultToolkit.getImage("경로");
 *  
 *  - getImage()의 인자
 *  	-> String
 *  	-> URL : Applet은 무조건 사용해야 함.
 */

package exam.image;
import java.awt.*;
import java.net.*;
import java.awt.event.*;

public class StdImage extends Frame implements Runnable
{	
	// 멤버변수
	Image img[] = new Image[4];
	URL url[] = new URL[4];
	int idxImage;
	
	Thread t;
	boolean runFlg;
	
	Button bt1, bt2;
	
	// 생성자
	public StdImage() {
		
		bt1 = new Button("시작");
		bt2 = new Button("중지");
		Panel pSouth = new Panel();
		pSouth.add(bt1);
		pSouth.add(bt2);
		
		add(pSouth, "South");
		bt1.addActionListener(new ButtonHandler());
		bt2.addActionListener(new ButtonHandler());
		
		// 이미지를 프레임에 추가
		try {
			url[0] = new URL("http://kr.img.blog.yahoo.com/ybi/1/04/af/dieta27/folder/8/img_8_70_10?1196751350.jpg");
			url[1] = new URL("http://kr.img.blog.yahoo.com/ybi/1/04/af/dieta27/folder/8/img_8_70_13?1196751350.jpg");
			url[2] = new URL("http://kr.img.blog.yahoo.com/ybi/1/04/af/dieta27/folder/8/img_8_70_6?1196751350.jpg");
			url[3] = new URL("http://kr.img.blog.yahoo.com/ybi/1/04/af/dieta27/folder/8/img_8_70_1?1196751350.jpg");
		} catch (MalformedURLException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
			System.out.println("URL형식이 잘못됨.");
		}
		
		
		for(int i=0; i<img.length; i++) {
			img[i] = Toolkit.getDefaultToolkit().getImage(url[i]);
		}
		
		this.setSize(300,300);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				System.out.println("프로그램 끝");
				System.exit(0);
			}
		});
	}
	
	// 이미지를 그리기
	public void paint(Graphics g) {
		g.drawImage(img[idxImage++%4], 50,50, 200,200, this);
	}
	
	public boolean imageUpdate(Image img, int flags, int x, int y, int w, int h) {
		
		if((flags % ALLBITS) !=0) {
			repaint();
		}
		
		return (flags & (ALLBITS | ERROR)) == 0;
	}

	class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae){
			if(ae.getSource() == bt1) {
				//idxImage++;
				showImage();
				runFlg = true;
			} else {
				//idxImage--;
				runFlg = false;
			}
			repaint();
		}
	}
	
	public void showImage() {
		t = new Thread(this);
		t.start();
	}


	public static void main(String[] args) {
		new StdImage();
	}
	
	// 쓰레드 구현 메소드
	public void run() {
		while(runFlg) {
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
