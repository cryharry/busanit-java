package exam.image;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PuzzleImage2 extends JFrame{
	int ran[] = new int[9];
	int ok = 1, iTmp = 0;
	Image img[] = new Image[9];
	Rectangle rect[] = new Rectangle[9];
	ImageIcon imgicon[]  =new ImageIcon[9];
	String imgAry[] = {"image/show0.jpg", "image/show1.jpg", "image/show2.jpg", "image/show3.jpg", "image/show4.jpg", "image/show5.jpg", "image/show6.jpg", "image/show7.jpg", "image/show8.jpg"};
	Image imgSelect;
	PuzzleCan pcan;
	int picWidth = 97, picHeight = 88;
	
	public PuzzleImage2() {
		
		// TODO 자동 생성된 메소드 스텁
		pcan = new PuzzleCan();
		this.add(pcan);
		
		for(int i=0; i<ran.length; i++) {
			
 			while(i != ok) {
 				
 				iTmp = (int)(Math.random()*9);
 				 ok =0;
 				 
 				for(int j=0; j<i; j++) {
 					
 					if(iTmp != ran[j]) {
 						ok++;
 					}	
 				}
 			}
 			rect[i] = new Rectangle();
 			
 			img[i] = Toolkit.getDefaultToolkit().getImage(imgAry[i]);
 			ran[i] = iTmp;
 			System.out.print(ran[i] + " ");			
 		}
		rect[0].setBounds(0, 0, picWidth, picHeight);
		rect[1].setBounds(97, 0, picWidth, picHeight);
		rect[2].setBounds(194, 0, picWidth, picHeight);
		rect[3].setBounds(0, 88, picWidth, picHeight);
		rect[4].setBounds(97, 88, picWidth, picHeight);
		rect[5].setBounds(194, 88, picWidth, picHeight);
		rect[6].setBounds(0, 176, picWidth, picHeight);
		rect[7].setBounds(97, 176, picWidth, picHeight);
		rect[8].setBounds(194, 176, picWidth, picHeight);
		
		
		//this.getContentPane().add(pMain, "Center");
		this.setSize(300,300);
		this.setVisible(true);
		MouseHandler mh = new MouseHandler();
		pcan.addMouseListener(mh);
		
		
		// 윈도우 이벤트 추가
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				System.out.println("프로그램 끝");
				System.exit(0);
			}
		});
		
	}
	class PuzzleCan extends Canvas {
		Graphics g2;
		public void paint(Graphics g) {
			 g.drawLine(0,88,291,88);
	         g.drawLine(0,176,291,176);
	         g.drawLine(97,0,97,264);
	         g.drawLine(194,0,194,264);
	         for(int i=0; i<rect.length; i++) {
	        	 g.drawImage(img[ran[i]], rect[i].x, rect[i].y, rect[i].width, rect[i].height, this); 
	         }
	         g2 = g;
		}
		public void repaint(int x2, int y2, int width, int height) {
			g2.drawImage(imgSelect, x2, y2, width, height, this);
		}
	}
		
	class MouseHandler implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			// TODO 자동 생성된 메소드 스텁
		}

		public void mouseEntered(MouseEvent e) {
			// TODO 자동 생성된 메소드 스텁
		}

		public void mouseExited(MouseEvent e) {
			// TODO 자동 생성된 메소드 스텁
		}

		public void mousePressed(MouseEvent e) {
			// TODO 자동 생성된 메소드 스텁
			System.out.println("Press");
			int x=e.getX();
			int y=e.getY();
						
		}

		public void mouseReleased(MouseEvent e) {
			// TODO 자동 생성된 메소드 스텁
			System.out.println("Released");
			int x = e.getX();
			int y = e.getY();
			if(x <97 && y < 88) {
				pcan.repaint(0, 0, picWidth, picHeight);
			} else if(x >=97 && x<194 && y>0 && y <88) {
				pcan.repaint(97, 0, picWidth, picHeight);
			} else if(x >=194 && y >=0 && y <88) {
				pcan.repaint(194, 0, picWidth, picHeight);
			} else if(x <97 && y > 88 && y < 176) {
				pcan.repaint(0, 88, picWidth, picHeight);
			} else if(x >= 97 && x < 194 && y>= 88 && y<176) {
				pcan.repaint(97, 88, picWidth, picHeight);
			} else if(x >194 && y >= 88 && y <176) {
				pcan.repaint(194, 88, picWidth, picHeight);
			} else if(x < 97 && y >= 176){
				pcan.repaint(0, 176, picWidth, picHeight);
			} else if(x >= 97 && x<= 176 && y >= 176) {
				pcan.repaint(97, 176, picWidth, picHeight);
			} else {
				pcan.repaint(194, 176, picWidth, picHeight);
			}
		}
	}

	public static void main(String[] args) {
		new PuzzleImage2();		
	}
}
