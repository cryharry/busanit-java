package exam.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class JButtonEx extends JFrame {
	
	public JButtonEx() {
		super("스윙의 버튼");
		setLayout(new GridLayout(0,1));
		
		JPanel btPanel = new JPanel();
		JButton jbt1 = new JButton("Button");
		JButton jbt2 = new JButton("Action");
		
		ImageIcon icon1 = new ImageIcon("image/button.gif");
		ImageIcon icon2 = new ImageIcon("image/action.gif");
		
		JButton jbt3 = new JButton(icon1);
		jbt3.setPressedIcon(icon2);
		jbt3.setMnemonic('b');
		
		btPanel.add(jbt1);
		btPanel.add(jbt2);
		btPanel.add(jbt3);
		
		JPanel togglePanel = new JPanel();
		togglePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED),"토글그룹"));
		
		
		JToggleButton jtbt1 = new JToggleButton("ONE");
		JToggleButton jtbt2 = new JToggleButton("TWO");
		JToggleButton jtbt3 = new JToggleButton("THREE");
		
		ButtonGroup btgr = new ButtonGroup();
		btgr.add(jtbt1);
		btgr.add(jtbt2);
		btgr.add(jtbt3);
		
		jtbt1.setSelected(true);
		
		togglePanel.add(jtbt1);
		togglePanel.add(jtbt2);
		togglePanel.add(jtbt3);
		
		JPanel selectPanel = new JPanel();
		JCheckBox jcheck = new JCheckBox("CheckBox");
		JRadioButton jrb = new JRadioButton("Radio");
		
		selectPanel.add(jcheck);
		selectPanel.add(jrb);
		
		ButtonGroup rdbgrp = new ButtonGroup();
		JRadioButton rb1 = new JRadioButton("ONE");
		JRadioButton rb2 = new JRadioButton("TWO");
		JRadioButton rb3 = new JRadioButton("THREE");
		
		rdbgrp.add(rb1);
		rdbgrp.add(rb2);
		rdbgrp.add(rb3);
		
		JPanel rdPanel = new JPanel();
		rdPanel.add(rb1);
		rdPanel.add(rb2);
		rdPanel.add(rb3);
		rdPanel.setBorder(new TitledBorder(new LineBorder(Color.black,3),"라디오 그룹"));
		rb1.setSelected(true);
		
		Container c = this.getContentPane(); //<--1.5이전 버전에서 동작시
		c.add(btPanel);
		c.add(togglePanel);
		c.add(selectPanel);
		c.add(rdPanel);
				
		pack();
		setLocation(300,200);
		setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new JButtonEx();
	}

}
