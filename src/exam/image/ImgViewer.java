package exam.image;
import java.net.*;
import java.awt.*;
import java.awt.image.*;

public class ImgViewer extends Frame 
{	
    Image curImg;
    URL url1;
    

  ImgViewer(String s)
  {
  	// Frame 클래스 생성자를 호출한다.
    super(s + " 파일 보여주기");
   
 	//url1 = this.getClass().getResource("Win95.jpg");
    curImg = Toolkit.getDefaultToolkit().getImage(s);
	//curImg = getToolkit().getImage(url1);
    
    
    setSize(500,500);
    setVisible(true);
  }


  public void paint(Graphics g) 
  {
    //g.drawImage(curImg, 0, 0,this);
    g.drawImage(curImg, 0, 0, 200,200,this);
  }

  public static void main(String args[]) 
  {
   	ImgViewer iv = new ImgViewer("image/image02.jpg");
   //System.out.println(args[1]);
  }
}
