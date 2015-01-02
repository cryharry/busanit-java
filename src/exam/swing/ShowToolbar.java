package exam.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ShowToolbar extends JPanel{

	public ShowToolbar() {
		JToolBar bar;
		JComboBox combo;
		JButton button;
		
		bar = new JToolBar();
		ImageIcon img1 = new ImageIcon("image/button.gif");
		
		setLayout(new GridLayout(1,3,5,5));
		
		button = new JButton();
		button.setIcon(img1);
		bar.add(button);
		
		bar.addSeparator();
		
		combo = new JComboBox();
		combo.addItem("One");
		combo.addItem("Two");
		combo.addItem("Three");
		
		bar.add(combo);
		
		add(bar, "South");
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(400, 150);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Toolbar Example");
		ShowToolbar panel = new ShowToolbar();
		
		frame.setForeground(Color.black);
		frame.setBackground(Color.lightGray);
		frame.getContentPane().add(panel, "Center");
		
		frame.setSize(panel.getPreferredSize());
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
