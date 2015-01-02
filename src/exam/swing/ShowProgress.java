package exam.swing;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.table.*;
import javax.swing.border.*;

class ShowProgress extends JFrame
{
	JPanel panel;


	public ShowProgress()
	{
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		setTitle("새 프래임");
		setBounds(178, 58, 545, 419);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(null);

		makeComponent();

		getContentPane().add(panel, BorderLayout.CENTER);
	}

	public void makeComponent()
	{
	}

	public static void main(String[] args)
	{
		ShowProgress GUI_Interface = new ShowProgress();
		GUI_Interface.setVisible(true);
	}
}
