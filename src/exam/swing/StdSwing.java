/*
	[스윙의 학습]
	
	스윙의 기본구조는
		Object -> Component -> Container -> javax.swing.Component
		
	컨테이너의 구조는
		Container -> Panel -> Applet -> JApplet
		     			 -> Window -> Dialog -> JDialog
						 				   -> Frame -> JFrame
	
	JFrame의 구조는
		- 4개의 Pane으로 구성
		- JRootPane -> GlassPane
							 -> layeredPane -> ContentPane, JMenuBar
		- ContentPane : 일반적인 컴포넌트를 가지는 패널, 가장 많이 사용함.
		- GlassPane : 기본적으로 숨겨진 상태로 다른 패널위에 존재
								주로 마우스 이벤트 및 팝업메튜를 처리함.
		- layeredPane : 여러층의 패널을 오버랩하여 붙힐 수 있도록 하는 패널
								  상단은 JMenuBar, 하단은 ContentPane으로 구성
		
	JDK 5.0에서 추가
	1. JFrame에 바로 add() 메소드로 컴포넌트의 추가 가능
		-> 1.4까지는 반드시 getContentPane() 메소드를 통해서 추가 가능
	2. 종료 버튼의 기본 이벤트 주어짐.
		-> setDefaultOperation(HIDE_ON_CLOSE);가 디폴트로 가짐.
			=> EXIT_ON_CLOSE
			=> DISPOSE_ON_CLOSE
	
	Pane패널의 종류
	-> JEditorPane : 여러 형태의 문서 포맷을 처리하는 클래스
	-> JTextPane : 덱스트 스타일을 가미하여 편집할 수 있는 클래스
	-> JScrollPane : 스크롤을 이용하여 컴포넌트를 보여주는 클래스
	-> JTabbedPane : 탭형태로 컴포넌트를 보여주는 클래스
	-> JSplitPane : 윈도우 내부를 두 개의 패널로 상하 또는 좌우로 분리하여 보여주는 클래스
	-> JDesktopPane : JInternalFrame을 담기 위한 가상 데스크탑을 생성하는 클래스
	-> JOptionPane : 메세지를 출력하고, 자료를 받는 다이얼로그를 생성하는 클래스	
 */

package exam.swing;
import javax.swing.*;
import java.awt.*;

public class StdSwing extends JFrame {

	private JLabel lb;
	private JButton jbt;
	private Container frame;
	
	public StdSwing(String str) {
		super(str);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		lb = new JLabel("스윙의 테스트");
		jbt = new JButton("확인");
		
		
		//this.add(lb);
		//this.add(jbt);
		
		frame = this.getContentPane();
		frame.add(lb);
		frame.add(jbt);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(200,200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new StdSwing("스윙의 연습");
	}

}
