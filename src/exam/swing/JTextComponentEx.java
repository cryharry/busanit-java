package exam.swing;
import java.awt.*;
import javax.swing.*;

public class JTextComponentEx extends JFrame{

	public JTextComponentEx() {
		JPanel p1 = new JPanel();
		JTextField field = new JTextField(5);
		JTextField numberField = new JTextField(2);
		JPasswordField passField = new JPasswordField(5);
		
		p1.add(new JLabel("Name: "));
		p1.add(field);
		p1.add(new JLabel("Age: "));
		p1.add(numberField);
		p1.add(new JLabel("Pass: "));
		p1.add(passField);
		
		JPanel p2 = new JPanel(new BorderLayout());
		JTextArea textArea = new JTextArea(5,10);
		textArea.setLineWrap(true); // 기본값은 false
		
		JScrollPane js = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		p2.add(new JLabel("자기소개서"), "North");
		p2.add(js, "Center");
		
		Container c = this.getContentPane();
		c.add(p1,"North");
		c.add(p2, "Center");
		
		//this.pack();
		this.setSize(500,400);
		this.setLocation(200,200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTextComponentEx();
	}

}
