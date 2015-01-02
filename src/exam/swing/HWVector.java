package exam.swing;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import java.util.*;

class Human {
	
	private String name;
	private String id;
	private String telephone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}

class Product {
	private String pname;
	private String pid;
	private String price;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}

public class HWVector extends JFrame implements ItemListener, ActionListener {

	HWVector hv;
	JComboBox ch;
	JLabel kind,lname, lid, ltel;
	TextField tname, tid, ttel;
	JButton btNext, btPrev;
	JList list;
	Vector vhr = new Vector();
	
	Vector<Human> hvec = new Vector<Human>();
	Human hr[] = new Human[4];
	String nameStr[] = {"박찬호","박지성","설기현","권종만"};
	String idStr[] = {"Chan-Ho","Ji-Sung", "Ki-Hyun", "UsnSol"};
	String telStr[] = {"051-111-1111","051-222-2222", "051-333-3333","051-631-1175"};
	
	Vector<Product> pvec = new Vector<Product>();
	Product pr[] = new Product[4];
	String pnameStr[] = {"컴퓨터", "내비게이션","휴대폰","자동차"};
	String pidStr[] = {"Computer", "Navi", "Phone","Car"};
	String priceStr[] = {"500000", "300000","50000","10000000"};
	
	int a;
		
	public HWVector() {
		super("숙제");
		JPanel pMain = new JPanel(new FlowLayout());
		JPanel pMainWest = new JPanel(new FlowLayout());
		kind = new JLabel("종류: ");
		ch = new JComboBox();
		ch.addItem("사람");
		ch.addItem("물건");
		ch.addItemListener(this);
		pMain.add(ch);
		list = new JList();
		for(int i=0; i<nameStr.length; i++){
			vhr.addElement(nameStr[i]);
			list.setListData(vhr);
		}
		pMainWest.add(list);
		pMain.add(pMainWest, "West");
		
		tname = new TextField(3);
		tid = new TextField(10);
		ttel = new TextField(15);
		JPanel pCenter = new JPanel(new GridLayout(0,1));
		lname = new JLabel("이름: ");
		pCenter.add(lname);
		pCenter.add(tname);
		lid = new JLabel("아이디: ");
		pCenter.add(lid);
		pCenter.add(tid);
		ltel = new JLabel("전화번호: ");
		pCenter.add(ltel);
		pCenter.add(ttel);
		
		JPanel pSouth = new JPanel();
		btNext = new JButton("다음");
		btPrev = new JButton("이전");
		pSouth.add(btNext);
		pSouth.add(btPrev);
		btNext.addActionListener(this);
		btPrev.addActionListener(this);
		
		
		Container c = this.getContentPane();
		c.add(pMain, "North");
		c.add(pCenter, "Center");
		c.add(pSouth, "South");
		
		for(int i=0; i<hr.length; i++)
		{
			hr[i] = new Human();
			hr[i].setName(nameStr[i]);
			hr[i].setId(idStr[i]);
			hr[i].setTelephone(telStr[i]);
			hvec.add(hr[i]);
		}
						
		for(int i=0; i<pr.length; i++)
		{
			pr[i] = new Product();
			pr[i].setPname(pnameStr[i]);
			pr[i].setPid(pidStr[i]);
			pr[i].setPrice(priceStr[i]);
			pvec.add(pr[i]);
		}
		
		
		tname.setText(hr[0].getName());
		tid.setText(hr[0].getId());
		ttel.setText(hr[0].getTelephone());
		
		this.setSize(200,360);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void PsetData(Product x[], int y) {
		tname.setText(x[y].getPname());
		tid.setText(x[y].getPid());
		ttel.setText(x[y].getPrice());
	}
	
	public void HsetData(Human x[], int y) {
		tname.setText(x[y].getName());
		tid.setText(x[y].getId());
		ttel.setText(x[y].getTelephone());
	}

	public void itemStateChanged(ItemEvent e) {
		String c2 = (String)e.getItem();
		if(c2.equals("사람"))
		{
			vhr.removeAllElements();
			for(int i=0; i<nameStr.length; i++){
				vhr.addElement(nameStr[i]);
				list.setListData(vhr);
			}
			lname.setText("이름: ");
			lid.setText("아이디: ");
			ltel.setText("전화번호: ");
			HsetData(hr, 0);
		}
		else
		{
			vhr.removeAllElements();
			for(int i=0; i<nameStr.length; i++)
			{
				vhr.addElement(pnameStr[i]);
				list.setListData(vhr);
			}
			lname.setText("상품명: ");
			lid.setText("상품아이디: ");
			ltel.setText("가격: ");
			PsetData(pr, 0);
		}
	}

	public void actionPerformed(ActionEvent e) {
		JButton bt = (JButton)e.getSource();
		if(ch.getSelectedItem() == "사람")
		{
			if(bt == btNext)
			{
				a += 1;
				if(a > hr.length - 1)
					--a;
				Human hh = (Human)hvec.elementAt(a);
				tname.setText(hh.getName());
				tid.setText(hh.getId());
				ttel.setText(hh.getTelephone());
					
			}
			else
			{
				--a;
				if(a < 0)
					a++;
				Human hh2 = (Human)hvec.elementAt(a);
				tname.setText(hh2.getName());
				tid.setText(hh2.getId());
				ttel.setText(hh2.getTelephone());
			}
		}
		else
		{
			
			if(bt == btNext)
			{
				a += 1;
				if(a > hr.length - 1)
					--a;
				Product pp = (Product)pvec.elementAt(a);
				tname.setText(pp.getPname());
				tid.setText(pp.getPid());
				ttel.setText(pp.getPrice());
				
			}
			else
			{
				--a;
				if(a < 0)
					a++;
				Product pp2 = (Product)pvec.elementAt(a);
				tname.setText(pp2.getPname());
				tid.setText(pp2.getPid());
				ttel.setText(pp2.getPrice());
			}
		}
		
	}
	
	public static void main(String[] args) {
		new HWVector();	
	}

}
