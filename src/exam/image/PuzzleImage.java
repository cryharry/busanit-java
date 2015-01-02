package exam.image;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PuzzleImage extends JFrame{
	int ran[] = new int[9];
	int ok = 1, iTmp = 0;
	JButton bt[] = new JButton[9];
	JPanel pMain;
	Image img[] = new Image[9];
	ImageIcon imgicon[]  =new ImageIcon[9];
	String imgAry[] = {"image/show0.jpg", "image/show1.jpg", "image/show2.jpg", "image/show3.jpg", "image/show4.jpg", "image/show5.jpg", "image/show6.jpg", "image/show7.jpg", "image/show8.jpg"};
	ImageIcon imgSelect;
	
	public PuzzleImage() {
		
		// TODO 자동 생성된 메소드 스텁
		pMain = new JPanel(new GridLayout(3,3));
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
			
			bt[i] = new JButton("");
			pMain.add(bt[i]);
			img[i] = Toolkit.getDefaultToolkit().getImage(imgAry[i]);
			imgicon[i] = new ImageIcon(img[i]);
			MouseHandler mh = new MouseHandler();
			bt[i].addMouseListener(mh);
			
			
			ran[i] = iTmp;
			System.out.print(ran[i] + " ");
			
		}
		
		for(int i=0; i<bt.length; i++) {
			bt[ran[i]].setIcon(imgicon[i]);
		}
		
		this.getContentPane().add(pMain, "Center");
		this.setSize(300,300);
		this.setVisible(true);
		
		
		// 윈도우 이벤트 추가
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				System.out.println("프로그램 끝");
				System.exit(0);
			}
		});
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
			int x = (e.getX()/97);
			int y = (e.getY()/88);
			System.out.println(e.getX());
			System.out.println(e.getY());
			JButton btx = (JButton)e.getSource();
			imgSelect=(ImageIcon)btx.getIcon();
			//imgSelect = (ImageIcon)bt[x+(y*3)].getIcon();
		}

		public void mouseReleased(MouseEvent e) {
			// TODO 자동 생성된 메소드 스텁
			System.out.println("Released");
			int x = e.getX();
			int y = e.getY();
			int xL = x/97;
			int yL = y/88;
			if(x <97 && y < 88) {
                bt[xL+(yL*3)].setIcon(imgSelect);
            } else if(x >=97 && x<194 && y>0 && y <88) {
            	bt[xL+(yL*3)].setIcon(imgSelect);
            } else if(x >=194 && y >=0 && y <88) {
            	bt[xL+(yL*3)].setIcon(imgSelect);
            } else if(x <97 && y > 88 && y < 176) {
            	bt[xL+(yL*3)].setIcon(imgSelect);
            } else if(x >= 97 && x < 194 && y>= 88 && y<176) {
            	bt[xL+(yL*3)].setIcon(imgSelect);
            } else if(x >194 && y >= 88 && y <176) {
            	bt[xL+(yL*3)].setIcon(imgSelect);
            } else if(x < 97 && y >= 176){
            	bt[xL+(yL*3)].setIcon(imgSelect);
            } else if(x >= 97 && x<= 176 && y >= 176) {
            	bt[xL+(yL*3)].setIcon(imgSelect);
            } else {
            	bt[xL+(yL*3)].setIcon(imgSelect);
            }
		}
	}

		

	public static void main(String[] args) {
		new PuzzleImage();		
	}

}
