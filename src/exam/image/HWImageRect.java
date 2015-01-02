package exam.image;
import java.awt.*;
import java.awt.event.*;

public class HWImageRect extends Frame {
    Image img;
    Rectangle rect;
    int picWidth =97, picHeight=88, picX=0, picY=0;
    DrawImage drImage;
    
    
    public HWImageRect() {
        img = Toolkit.getDefaultToolkit().getImage("image/image01.jpg");
        rect = new Rectangle();
        rect.setBounds(picX, picY, picWidth, picHeight);
        drImage = new DrawImage();
        this.add(drImage);       
        this.setSize(300,300);
        this.setVisible(true);
        
        // 마우스 이벤트 추가
        drImage.addMouseListener(new MouseAdapter() {
        	public void mouseReleased (MouseEvent  me) {
            	int x = me.getX();
                int y = me.getY();
                xyReturn(x,y);
                drImage.repaint();
            }
        });        
        
        // 윈도우 이벤트 추가
        this.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent we) {
               System.out.println("프로그램 끝");
               System.exit(0);
           }
        });

    }
    
	class DrawImage extends Canvas {
		
        int x, y;
        public void paint(Graphics g) {
            g.drawLine(0,88,291,88);
            g.drawLine(0,176,291,176);
            g.drawLine(97,0,97,264);
            g.drawLine(194,0,194,264);
            int xL = drImage.x;
            int yL = drImage.y;
            
            if(xL <97 && yL < 88) {
                g.drawImage(img, 0, 0, rect.width, rect.height, this);
            } else if(xL >=97 && xL<194 && yL>0 && yL <88) {
            	g.drawImage(img, 97, 0, rect.width, rect.height, this);
            } else if(xL >=194 && yL >=0 && yL <88) {
            	g.drawImage(img, 194, 0, rect.width, rect.height, this);
            } else if(xL <97 && yL > 88 && yL < 176) {
            	g.drawImage(img, 0, 88, rect.width, rect.height, this);
            } else if(xL >= 97 && xL < 194 && yL>= 88 && yL<176) {
            	g.drawImage(img, 97, 88, rect.width, rect.height, this);
            } else if(xL >194 && yL >= 88 && yL <176) {
            	g.drawImage(img, 194, 88, rect.width, rect.height, this);
            } else if(xL < 97 && yL >= 176){
            	g.drawImage(img, 0, 176, rect.width, rect.height, this);
            } else if(xL >= 97 && xL<= 176 && yL >= 176) {
            	g.drawImage(img, 97, 176, rect.width, rect.height, this);
            } else {
            	g.drawImage(img, 194, 176, rect.width, rect.height, this);
            }
        }       
	}
	
	public void xyReturn(int xLo, int yLo) {
		drImage.x = xLo;
		drImage.y = yLo;
	}
     
    public static void main(String[] args) {
        new HWImageRect();
    }
}