package exam.image;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//import exam.image.ImgPuzzle.ButtonHandler;

public class MathRan extends JFrame{
	int ran[] = new int[9];
	int ok = 1, iTmp = 0;
	JButton bt[] = new JButton[9];
	JPanel pMain;
	Image img[] = new Image[9];
	ImageIcon imgicon[]  =new ImageIcon[9];
	String imgAry[] = {"image/show0.jpg", "image/show1.jpg", "image/show2.jpg", "image/show3.jpg", "image/show4.jpg", "image/show5.jpg", "image/show6.jpg", "image/show7.jpg", "image/show8.jpg"};
	//PuzzleImg puzz;
	ImageIcon imgSelect;
	
	public MathRan() {
		
		// TODO 자동 생성된 메소드 스텁
		pMain = new JPanel(new GridLayout(0,3));
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
			
			
			bt[i].setIcon(imgicon[i]);
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
			//System.out.println("Click");
		}

		public void mouseEntered(MouseEvent e) {
			// TODO 자동 생성된 메소드 스텁
			//System.out.println("Enter");
		}

		public void mouseExited(MouseEvent e) {
			// TODO 자동 생성된 메소드 스텁
			//System.out.println("Exit");
		}

		public void mousePressed(MouseEvent e) {
			// TODO 자동 생성된 메소드 스텁
			System.out.println("Press");
			int x = e.getX();
			int y = e.getY();
			JButton bt = (JButton)e.getSource();
			imgSelect = (ImageIcon)bt.getIcon();
		}

		public void mouseReleased(MouseEvent e) {
			// TODO 자동 생성된 메소드 스텁
			System.out.println("Released");
			int x = e.getX();
			int y = e.getY();
			if(x <97 && y < 88) {
                bt[x+(y*3)].setIcon(imgSelect);
            } else if(x >=97 && x<194 && y>0 && y <88) {
            	bt[x+(y*3)].setIcon(imgSelect);
            } else if(x >=194 && y >=0 && y <88) {
            	bt[x+(y*3)].setIcon(imgSelect);
            } else if(x <97 && y > 88 && y < 176) {
            	bt[x+(y*3)].setIcon(imgSelect);
            } else if(x >= 97 && x < 194 && y>= 88 && y<176) {
            	bt[x+(y*3)].setIcon(imgSelect);
            } else if(x >194 && y >= 88 && y <176) {
            	bt[x+(y*3)].setIcon(imgSelect);
            } else if(x < 97 && y >= 176){
            	bt[x+(y*3)].setIcon(imgSelect);
            } else if(x >= 97 && x<= 176 && y >= 176) {
            	bt[x+(y*3)].setIcon(imgSelect);
            } else {
            	bt[x+(y*3)].setIcon(imgSelect);
            }
		}
	}

		

	public static void main(String[] args) {
		new MathRan();		
	}

}
