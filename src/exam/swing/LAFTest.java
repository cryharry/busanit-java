package exam.swing;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class LAFTest extends JPanel implements ActionListener {

	public LAFTest() {
		AbstractButton button;
		JSlider slider;
		JRadioButton radioButton;
		JPanel topPanel, bottomPanel;
		ButtonGroup grp;
		
		setLayout(new GridLayout(2,1));
		
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		
		button = new JButton("Button");
		topPanel.add(button);
		
		button = new JCheckBox("CheckBox");
		topPanel.add(button);
		
		button = new JRadioButton("RadioButton");
		topPanel.add(button);
		
		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		topPanel.add(slider);
		
		add(topPanel);
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		
		grp = new ButtonGroup();
		
		radioButton = new JRadioButton("윈도우", true);
		radioButton.addActionListener(this);
		radioButton.setActionCommand("Windows");
		grp.add(radioButton);
		bottomPanel.add(radioButton);
		
		radioButton = new JRadioButton("모티프", false);
		radioButton.addActionListener(this);
		radioButton.setActionCommand("Motif");
		grp.add(radioButton);
		bottomPanel.add(radioButton);
		
		radioButton = new JRadioButton("자바", false);
		radioButton.addActionListener(this);
		radioButton.setActionCommand("Java");
		grp.add(radioButton);
		bottomPanel.add(radioButton);
		
		add(bottomPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd;
		
		cmd = e.getActionCommand();
		
		if(cmd.equals("Windows")) setUI2Windows();
		else if(cmd.equals("Motif")) setUI2Motif();
		else setUI2Basic();
	}
	
	public void setUI2Basic() {
		try
		{
			Container parent;
			String cn = "javax.swing.plaf.";
			
			cn+= "metal.MetalLookAndFeel";
			
			parent = getParent();
			
			if(parent != null)
			{
				UIManager.setLookAndFeel(cn);
				
				SwingUtilities.updateComponentTreeUI(this);
				parent.validate();
				parent.repaint();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace(System.out);
		}
	}
	
	public void setUI2Motif() {
		try
		{
			Container parent;
			String cn = "com.sun.java.swing.plaf.";
			
			cn+="motif.MotifLookAndFeel";
			
			parent = getParent();
			
			if(parent != null)
			{
				UIManager.setLookAndFeel(cn);
				
				SwingUtilities.updateComponentTreeUI(this);
				parent.validate();
				parent.repaint();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace(System.out);
		}
	}
	
	public void setUI2Windows() {
		try
		{
			Container parent;
			String cn = "com.sun.java.swing.plaf.";
			
			cn+= "windows.WindowLookAndFeel";
			
			parent = getParent();
			
			if(parent != null)
			{
				UIManager.setLookAndFeel(cn);
				
				SwingUtilities.updateComponentTreeUI(this);
				parent.validate();
				parent.repaint();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace(System.out);
		}
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(200,200);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Look & Feel 테스트");
		LAFTest panel = new LAFTest();
		String cn = "com.sun.java.swing.plaf.";
		
		cn+="windows.WindowsLookAndFeel";
		
		frame.setForeground(Color.black);
		frame.setBackground(Color.lightGray);
		frame.getContentPane().add(panel, "Center");
		
		try
		{
			UIManager.setLookAndFeel(cn);
			SwingUtilities.updateComponentTreeUI(frame);
		}
		catch(Exception exp)
		{
			System.out.println(exp);
		}
		
		frame.setSize(panel.getPreferredSize());
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	

}
