package exam.kita;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Administrator
 *
 */
public class StdStatic extends MyFrame{

	// 멤버변수
	protected static int clickNum;
	protected int myClickNum;
	protected TextArea ta = new TextArea();
	protected Button bt = new Button("클릭");
	
	StdStatic ss;
	
	//생성자
	StdStatic(String str){
		super(str);
		this.setLayout(new GridLayout(2,1));
		
		this.add(ta);
		this.add(bt);
		
		bt.addActionListener(new ButtonHandler());
		
		this.setSize(200, 200);
		this.setVisible(true);
		
		ss = this;
	}
	
	class ButtonHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			String strInfo="";
			myClickNum++;
			clickNum++;
			strInfo = "현재 클래스명 " + ss.getTitle() + "\n";
			strInfo += "현재 클릭수는 " +myClickNum+ "\n";
			strInfo += "총 클릭수는 " +clickNum;
			
			ta.setText(strInfo);
		}
		
	}
	
	public static void main(String[] args) {
		StdStatic st01 = new StdStatic("첫번째창");
		StdStatic st02 = new StdStatic("두번쨰창");
		StdStatic st03 = new StdStatic("세번째창");
		
		TestFrame tf = new TestFrame("새로운 창");
		System.out.println("상수 출력: " + tf.CLICKNUM);
		System.out.println(TestFrame.getStr());
	}

}

class TestFrame extends StdStatic
{
	final int CLICKNUM = 100;
	
	TestFrame(String str) {
		super(str);
	}
	
	public static String getStr() {
		return "새 프레임의 결과";
	}
	
}
