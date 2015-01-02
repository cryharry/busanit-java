package exam.swing;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class ShowTable extends JFrame implements ActionListener{
	
	JButton bt1 = new JButton("입력");
	JButton bt2 = new JButton("삭제");
	JTextField tf1 = new JTextField(5);
	JTextField tf2 = new JTextField(5);
	JTextField tf3 = new JTextField(5);
	JTextField tf4 = new JTextField(5);
	JTable table;
	
	// 데이타처리 객체
	Object dataObj[][];
	
	public ShowTable() {
		JPanel pSouth = new JPanel();
		pSouth.add(new JLabel("이름: "));
		pSouth.add(tf1);
		pSouth.add(new JLabel("작품: "));
		pSouth.add(tf2);
		pSouth.add(new JLabel("직업: "));
		pSouth.add(tf3);
		pSouth.add(new JLabel("순위:  "));
		pSouth.add(tf4);
		pSouth.add(bt1);
		pSouth.add(bt2);
		
		
		
		// 1.일반 테이블
		//BeutyModel bModel = new BeutyModel("down/mem.list");
		
		// 2.수정가능 테이블
		BeutyModel bModel = new BeutyModel("down/mem.list");
		Object [][] objAry = bModel.getObject();
		String [] titleAry = {"이름", "작품", "직업", "순위"}; 
		DefaultTableModel dModel = new DefaultTableModel(objAry,titleAry);
		table = new JTable(dModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		// 데이타 처리 객체
		//int iCol = dtm.getColumnCount();
		//int iRow= dtm.getRowCount();
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		// 입력용 JPanel추가 
		this.getContentPane().add(pSouth, BorderLayout.SOUTH);
		
		//	이벤트 핸들러의 추가
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		table.addMouseListener(new MouseHandler());
		
	}
	
	public void actionPerformed(ActionEvent e) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		if(e.getSource() == bt1) {
			Object arr[] = new Object[4];
			arr[0] = tf1.getText();
			arr[1] = tf2.getText();
			arr[2] = tf3.getText();
			arr[3] = tf4.getText();
			model.addRow(arr);
			
		} else {
			int iRow = table.getSelectedRow();
			if(iRow == -1) return;
			model.removeRow(iRow);
		}
	}
	
	class MouseHandler implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			int iRowIndex = table.getSelectedRow();
			int iColIndex = table.getSelectedColumn();
			
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			
			switch(iColIndex) {
				case 0:
					tf1.setText((String)model.getValueAt(iRowIndex, iColIndex));
					tf2.setText("");
					tf3.setText("");
					tf4.setText("");
					break;
				case 1:
					tf2.setText((String)model.getValueAt(iRowIndex, iColIndex));
					tf1.setText("");
					tf3.setText("");
					tf4.setText("");
					break;
				case 2:
					tf3.setText((String)model.getValueAt(iRowIndex, iColIndex));
					tf2.setText("");
					tf1.setText("");
					tf4.setText("");
					break;
				case 3:
					tf4.setText((String)model.getValueAt(iRowIndex, iColIndex));
					tf2.setText("");
					tf3.setText("");
					tf1.setText("");
					break;
			}
		}

		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		
	}

	public static void main(String[] args) {
		ShowTable frame = new ShowTable();
		frame.setSize(600,400);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent evt) {
				System.exit(0);
			}
		});
	}

}

//class BeutyModel extends AbstractTableModel <--일반 테이블
class BeutyModel extends DefaultTableModel
{

	//private Object[][] table_data = { {"엄정화", "포이즌", "가수"}, {"김혜수", "국희", "탤런트"}, {"채정안", "테크노", "가수"}, {"이승연", "세이세이", "탤런트"} ,{"채시라", "왕과비", "탤런트"}};
	private Vector<String> vec = new Vector<String>();
	private int iRowcnt;
	private int iColcnt;
	private Object[][] table_data;
	
	
	public BeutyModel(String file_name) {
		reading(file_name);
	}
	
	public void reading(String file_name) {
		
		try {
			FileReader fr = new FileReader(file_name);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null) {
				vec.add(line);
				iRowcnt++;
			}
//			String str = vec.get(0);
//			String str2[] = str.split(",");
//			iColcnt = str2.length;
			iColcnt = vec.get(0).split(",").length;
			
			table_data = new Object[iRowcnt][iColcnt];
			for(int i=0; i<vec.size(); i++) {
				String strVec = vec.get(i);
				String aryStr[] = strVec.split(",");
				for(int j=0; j<iColcnt; j++) {
					table_data[i][j] = aryStr[j];
				}
			}
			
			
		} catch (FileNotFoundException e1) {
			// TODO 자동 생성된 catch 블록
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}
	
	public int getColumnCount() {
		// TODO 자동 생성된 메소드 스텁
		return iColcnt;
	}

	public int getRowCount() {
		// TODO 자동 생성된 메소드 스텁
		return iRowcnt;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO 자동 생성된 메소드 스텁
		return table_data[rowIndex][columnIndex];
	}
	
	public String getColumnName(int columnIndex) {
		String str = "";
		
		switch(columnIndex) {
			case 0:
				str = "이  름";
				break;
			case 1:
				str = "특기나 대표작";
				break;
			case 2:
				str = "직  업";
				break;
			case 3:
				str = "순  위";
				break;
		}
		return str;
	}
	public Object [][] getObject(){
		return table_data;
	}
}
