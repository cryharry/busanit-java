package exam.image;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class HWImage2 extends JFrame
{
	// 멤버변수
	Image img;
	ImageIcon imgicon;
	JButton bt[] = new JButton[9];
	JPanel pMain;
	HWImage2 hwimg;

	// 생성자
	public HWImage2() {

		pMain = new JPanel(new GridLayout(0,3));

		for(int i=0; i<9; i++) {
			bt[i] = new JButton("");
			pMain.add(bt[i]);
			ButtonHandler bh = new ButtonHandler();
			bt[i].addActionListener(bh);
		}
		img = Toolkit.getDefaultToolkit().getImage("image/image01.jpg");
		imgicon = new ImageIcon(img);


		this.getContentPane().add(pMain, "Center");
		this.setSize(300, 300);
		this.setVisible(true);
		int ran = (int)(Math.random()*9);
		bt[ran].setIcon(imgicon);


		// 윈도우 이벤트 추가
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				System.out.println("프로그램 끝");
				System.exit(0);
			}
		});
		hwimg = this;
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
			hwimg.bt[x+(y*3)].setIcon(imgicon);
			
		}
	}

//	public void paint(Graphics g) {
//
//	}

	public static void main(String[] args) {
		new HWImage2();
	}

}
