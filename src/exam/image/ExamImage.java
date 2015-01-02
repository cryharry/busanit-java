package exam.image;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class ExamImage extends Frame
{
	// 멤버변수
	Image [] imgObj = new Image[4];
	Rectangle rect [] = new Rectangle[4];
	int picWidth = 120;
	int picHeight = 100;
	int imageNum;
	
	Button bt1, bt2, bt3, bt4;
	Choice Selected;
	Panel pCenter = new Panel();
	Panel pSouth = new Panel();
	
	// 생성자
	public ExamImage(String strAry[]) {
		// 클래스배열의 초기화
		for(int i=0; i<imgObj.length; i++) {
			imgObj[i] = Toolkit.getDefaultToolkit().getImage(strAry[i]);
			rect[i] = new Rectangle();
		}
		rect[0].setBounds(10,30, picWidth, picHeight);
		rect[1].setBounds(230,30, picWidth, picHeight);
		rect[2].setBounds(10,210, picWidth, picHeight);
		rect[3].setBounds(230,210, picWidth, picHeight);
		
		bt1 = new Button("넓이 증가");
		bt2 = new Button("넓이 감소");
		bt3 = new Button("높이 증가");
		bt4 = new Button("높이 감소");
		Selected = new Choice();
		for(int i=1; i<5; i++) {
			Selected.add("이미지" + i);
		}
		
		pSouth.add(bt1);
		pSouth.add(bt2);
		pSouth.add(bt3);
		pSouth.add(bt4);
		pSouth.add(Selected);
		
		this.add(pSouth,"South");
		
		this.setSize(400,400);
		this.setVisible(true);
		
		// 이벤트 추가
		ButtonHandler bh = new ButtonHandler();
		bt1.addActionListener(bh);
		bt2.addActionListener(bh);
		bt3.addActionListener(bh);
		bt4.addActionListener(bh);
		Selected.addItemListener(new ItemHandler());
		
		// 윈도우 이벤트 추가
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				System.out.println("프로그램 끝");
				System.exit(0);
			}
		});
	}
	
	class ItemHandler implements ItemListener {

		public void itemStateChanged(ItemEvent e) {
			String str = Selected.getSelectedItem(); 
			if( str.equals("이미지1")) {
				imageNum = 0;
			} else if(str.equals("이미지2")) {
				imageNum = 1;
			} else if(str.equals("이미지3")) {
				imageNum = 2;
			} else {
				imageNum = 3;
			}
			
			
		}
		
	}
	
	class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Button bt = (Button)ae.getSource();
			if(bt == bt1){
				// 넓이 증가
				rect[imageNum].width += 10;
//				rect[1].width += 10;
//				rect[2].width += 10;
//				rect[3].width += 10;
			} else if(bt == bt2) {
				// 넓이 감소
				rect[imageNum].width -= 10;
//				rect[1].width -= 10;
//				rect[2].width -= 10;
//				rect[3].width -= 10;
			} else if(bt == bt3) {
				// 높이 증가
				rect[imageNum].height += 10;
//				rect[1].height += 10;
//				rect[2].height += 10;
//				rect[3].height += 10;
			} else {
				//높이 감소
				rect[imageNum].height -= 10;
//				rect[1].height -= 10;
//				rect[2].height -= 10;
//				rect[3].height -= 10;
			} 
			repaint();
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(imgObj[0], rect[0].x, rect[0].y, rect[0].width, rect[0].height, this);
		g.drawImage(imgObj[1], rect[1].x, rect[1].y, rect[1].width, rect[1].height, this);
		g.drawImage(imgObj[2], rect[2].x, rect[2].y, rect[2].width, rect[2].height, this);
		g.drawImage(imgObj[3], rect[3].x, rect[3].y, rect[3].width, rect[3].height, this);
	}
	
	
	public static void main(String[] args) {
		String strAry[] = {"image/image01.jpg", "image/image02.jpg", "image/image03.jpg", "image/image04.jpg"};
		new ExamImage(strAry);
	}

}
