package exam.abs;

import java.awt.*;
import java.awt.event.*;

public class StdStringToken extends Frame implements ActionListener {

	TextField tf1, tf2, tf3, tf4;
	Button bt1, bt2;
	
	public StdStringToken() {
		tf1 = new TextField(20);
		tf2 = new TextField(15);
		tf3 = new TextField(15);
		tf4 = new TextField(14);
		Panel pCenter = new Panel(new GridLayout(4,1));
		Panel p[] = new Panel[4];
		for(int i=0; i<p.length; i++)
		{
			p[i] = new Panel();
			pCenter.add(p[i]);
		}
		
		
		
		bt1 = new Button("확인");
		bt2 = new Button("리셋");
		
		p[0].add(new Label("내용: "));
		p[0].add(tf1);
		p[1].add(new Label("이름: "));
		p[1].add(tf2);
		p[2].add(new Label("아이디: "));
		p[2].add(tf3);
		p[3].add(new Label("비밀번호: "));
		p[3].add(tf4);
		
		Panel pSouth = new Panel();
		pSouth.add(bt1);
		pSouth.add(bt2);
		this.add(pSouth,BorderLayout.SOUTH);
		this.add(pCenter, BorderLayout.CENTER);
		
		this.setSize(300,400);
		this.setVisible(true);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {	
		
	}
	
	public static void main(String[] args) {
		new StdStringToken();
	}

}
