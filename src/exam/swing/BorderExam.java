package exam.swing;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class BorderExam extends JPanel{

	public BorderExam() {
		BevelBorder border;
		EtchedBorder eborder;
		TitledBorder tborder;
		JLabel label;
		
		setLayout(new GridLayout(1,4,20,20));
		
		label = new JLabel("보더없음", JLabel.CENTER);
		add(label);
		
		label = new JLabel("beveled border", JLabel.CENTER);
		border = new BevelBorder(BevelBorder.RAISED);
		label.setBorder(border);
		add(label);
		
		label = new JLabel("돌출한 etched border", JLabel.CENTER);
		eborder = new EtchedBorder(EtchedBorder.RAISED);
		label.setBorder(eborder);
		add(label);
		
		label = new JLabel("titled border", JLabel.CENTER);
		tborder = new TitledBorder("제목");
		tborder.setTitlePosition(TitledBorder.ABOVE_TOP);
		tborder.setTitleJustification(TitledBorder.CENTER);
		label.setBorder(tborder);
		add(label);
		
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(500,100);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("보더를 테스트합니다");
		BorderExam be = new BorderExam();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(be, "Center");
		
		frame.setSize(be.getPreferredSize());
		frame.setVisible(true);
	}

}
