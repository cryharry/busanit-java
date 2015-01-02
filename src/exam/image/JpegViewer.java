package exam.image;
import java.applet.*;
import java.awt.*;
import java.awt.image.*;

public class JpegViewer extends Applet{
	
	Image myImg;
	
	public void init() {
		myImg = getImage(getDocumentBase(), "../image/action.gif");
		System.out.println(getDocumentBase());
	}
	
	public void paint(Graphics g) {
		g.drawImage(myImg, 0, 0, this);
	}

}
