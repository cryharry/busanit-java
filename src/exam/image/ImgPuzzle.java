package exam.image;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImgPuzzle extends JFrame
{
	// 멤버변수
	Image img[] = new Image[9];
	ImageIcon imgicon[]  =new ImageIcon[9];
	JButton bt[] = new JButton[9];
	JPanel pMain;
	ImgPuzzle imgP;
	int ran[] = new int[9];
	int ok = 1, iTmp = 0;
	String imgAry[] = {"image/show0.jpg", "image/show1.jpg", "image/show2.jpg", "image/show3.jpg", "image/show4.jpg", "image/show5.jpg", "image/show6.jpg", "image/show7.jpg", "image/show8.jpg"};
	
	// 생성자
	public ImgPuzzle() {

		pMain = new JPanel(new GridLayout(0,3));
		
		for(int i=0; i<ran.length; i++) {
			
			while(i != ok){
				iTmp = (int)(Math.random()*9);
				ok=0;
				
				for(int j=0; j<i;i++)	{
					if(iTmp == ran[j]){
						ok++;
					}
				}
			}
			
			img[i] = Toolkit.getDefaultToolkit().getImage(imgAry[i]);
			imgicon[i] = new ImageIcon(img[i]);
			bt[i] = new JButton("");
			pMain.add(bt[i]);
			ButtonHandler bh = new ButtonHandler();
			bt[i].addActionListener(bh);
			ran[i] = iTmp;
			bt[i].setIcon(imgicon[i]);
			System.out.print(ran[i] + " ");
		}		
		


		this.getContentPane().add(pMain, "Center");
		this.setSize(300, 300);
		this.setVisible(true);
		


		// 윈도우 이벤트 추가
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				System.out.println("프로그램 끝");
				System.exit(0);
			}
		});
		imgP = this;
	}

	class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			JButton bt = (JButton)ae.getSource();

			// GridLayout의 x좌표 값이 97씩 증가하므로 97로 나눠서 0,1,2 값으로 받아들이고,
			// y좌표값이 88씩 증가하므로 88로 나눠서 0,1,2 값으로 받아들여 x+3y로 버튼의
			// 위치를 찾아서 Icon을 이미지로 변경한다.
			int x = (bt.getX()/97);
			int y = (bt.getY()/88);
			//x,y값 보여주기
			System.out.println("x:" +x);
			System.out.println("y:" +y);
			imgP.bt[x+(y*3)].setIcon(imgicon[4]);
			
		}
	}

//	public void paint(Graphics g) {
//
//	}

	public static void main(String[] args) {
		new ImgPuzzle();
	}

}
