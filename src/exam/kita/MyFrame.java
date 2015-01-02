package exam.kita;

import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame implements WindowListener 
{
	MyFrame() {
		this.addWindowListener(this);
	}
	MyFrame(String strName) {
		super(strName);
		this.addWindowListener(this);
	}
	//추상메소드 재정의
	public void windowActivated(WindowEvent e){
		//System.out.println("windowActivated");
	} 
	public void windowClosed(WindowEvent e){
		//System.out.println("windowClosed");
	} 
	public void windowClosing(WindowEvent e){
		//System.out.println("windowClosing");
		System.exit(0);
	} 
	public void windowDeactivated(WindowEvent e){
		//System.out.println("windowDeactivated");
	} 
	public void windowDeiconified(WindowEvent e){
		//System.out.println("windowDeiconified");
	} 
	public void windowIconified(WindowEvent e) {
		//System.out.println("windowIconified");
	}
	public void windowOpened(WindowEvent e){
		//System.out.println("windowOpened");
	} 
 
}

