package exam.swing;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class ShowTab extends JPanel implements ChangeListener{

	JTabbedPane pane;
	
	public ShowTab() {
		JPanel panel;
		
		pane = new JTabbedPane();
		
		setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.add(new Label("첫번째 탭입니다."));
		pane.addTab("첫번째", panel);
		
		panel = new JPanel();
		panel.add(new Label("두번째 탭입니다."));
		pane.addTab("두번째", panel);
		
		panel = new JPanel();
		panel.add(new Label("세번째 탭입니다."));
		pane.addTab("세번째", panel);
		
		pane.setSelectedIndex(0);
		
		pane.addChangeListener(this);
		add(pane, "Center");
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}
	
	public void stateChanged(ChangeEvent e) {
		int curSelIndex = pane.getSelectedIndex();
		String curPaneTitle = pane.getTitleAt(curSelIndex);
		
		System.out.println(curPaneTitle + " 탭이 선택되었습니다");
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("탭 예제");
		ShowTab panel = new ShowTab();
		
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
