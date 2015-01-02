/*********************************
 * 만든 날짜 : 2007년 11월 26일 방과후
 * 만든 이 : 부산IT직업전문하교 USN솔루션 과정 곽창범
 * 만든 의도 : HomeWork(숙제)
 * 도움 준 이 : 같은 반 정한국 형님
**********************************/


package exam.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingGame extends JFrame implements ActionListener {

	private JPanel pSouth, pCenter;
	private JButton bt[] = new JButton[9];
	private JTextField txtName, txtLeft, txtRight;
	private JButton btCommit;
	private String aryStr[] = {"현상원", "김재성", "이우용"};
	private int catchNum;
	
	public SwingGame()
	{
		// pCenter 패널은 GridLayout으로 버튼을 올리고,
		// pSouth 패널은 TextField와 확인Button 을 올리기 위해 사용
		pCenter = new JPanel(new GridLayout(3,3));
		pSouth = new JPanel(new FlowLayout());
		
		// 버튼을 GridLayout에 올림
		for(int i=0; i<bt.length; i++)
		{
			bt[i] = new JButton();
			pCenter.add(bt[i]);
		}
		int btNum[] = new int[3];
		
		for(int i=0; i<aryStr.length; i++)
		{
			// Math.random()함수를 사용하여 랜덤하게 버튼에 라벨을 더한다
			btNum[i]=(int)(Math.random()*8);
			// Math.random함수에서 동일한 숫자가 나왔을 경우 btNum[i]=0으로 초기화하고
			// 다시 실행
			if(btNum[0] == btNum[1])
			{
				btNum[i] = 0;
				btNum[i] = (int)(Math.random()*8);
			}
			if(btNum[0] == btNum[2])
			{
				btNum[i] = 0;
				btNum[i] = (int)(Math.random()*8);
			}
			if(btNum[1] == btNum[2])
			{
				btNum[i] = 0;
				btNum[i] = (int)(Math.random()*8);
			}
			
			bt[btNum[i]].setLabel(aryStr[i]);
		}
		
		// TextField 및 확인 버튼을 pSouth에 올린다
		txtName = new JTextField(15);
		txtLeft = new JTextField("",1);
		txtRight = new JTextField("",1);
		btCommit = new JButton("확인");
		pSouth.add(txtName);
		pSouth.add(txtLeft);
		pSouth.add(txtRight);
		pSouth.add(btCommit);
		
		// pCenter와 pSouth를 JFrame에 올린다
		this.add(pCenter,BorderLayout.CENTER);
		this.add(pSouth, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		btCommit.addActionListener(this);
		
		this.setSize(400,400);
		this.setVisible(true);
	}
	
	// LeftNum->x, RightNum->y값을 인자로 받아와 3x+y번째의 bt의 라벨과 비교하여
	// 일치할 시에는 잡았습니다로 변경 및 범인수+1 하고 아닐경우 놓쳤습니다를 출력한다
	// 잡은 범인수의 수가 3이 될때 게임종료를 출력해준다.
	public void removeCompo(int x, int y) {
		
		if(txtName.getText().equals(bt[((x*3)+y)].getLabel()))
		{
			bt[((x*3)+y)].setLabel("잡았습니다");
			catchNum++;
		}
		else
		{
			txtName.setText("놓쳤습니다");
		}
		if(catchNum > 2 )
			txtName.setText("게임 종료");
	}
	
	// txtLeft=>LeftNum, txtRight=>RightNum을 계산이 가능한 int형으로 변경하고
	// 그 int값을 인자값으로 removeCompo라는 함수로 넘겨준다.
	public void actionPerformed(ActionEvent e) {
		int LeftNum = (int)Integer.parseInt(txtLeft.getText());
		int RightNum = (int)Integer.parseInt(txtRight.getText());
		removeCompo(LeftNum, RightNum);
	}
	
	public static void main(String[] args) {
		new SwingGame();
	}

}
