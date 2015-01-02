package exam.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StdJtext extends JFrame implements ActionListener{
	// 멤버변수
	JTextField tf = new JTextField(20);
	JTextArea ta = new JTextArea(10, 20);
	JButton bt1 = new JButton("텍스트필드제어");
	JButton bt2 = new JButton("텍스트에리어제어");
	
	//생성자
	StdJtext() {
		// super("텍스트의 연습");
		this.setTitle("텍스트의 연습");
		
		Container frame = this.getContentPane();
		frame.add(tf, BorderLayout.NORTH);
		frame.add(ta, BorderLayout.CENTER);
		JPanel pSouth = new JPanel();
		pSouth.add(bt1);
		pSouth.add(bt2);
		frame.add(pSouth, BorderLayout.SOUTH);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt1) {
			tf.setText("입력금지");
			tf.setEnabled(false);
			ta.setEditable(true);
			bt1.setEnabled(false);
			bt2.setEnabled(true);
		} else {
			ta.setText("입력금지");
			ta.setEnabled(false);
			tf.setEnabled(true);
			bt2.setEnabled(false);
			bt1.setEnabled(true);
		}
	}

	public static void main(String[] args) {
		new StdJtext();
	}
}
