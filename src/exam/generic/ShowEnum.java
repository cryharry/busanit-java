package exam.generic;
import java.util.*;

public class ShowEnum {
	
	Color myColor;
	
	// 생성자
	public ShowEnum(Color c) {
		myColor = c;
	}
	
	public Color getColor() {
		return myColor;
	}
	
	public void setColor(Color c) {
		myColor = c;
	}

	public static void main(String[] args) {
		List<ShowEnum> objList = new Vector<ShowEnum>();
		ShowEnum obj;
		obj = new ShowEnum(Color.Red);
		objList.add(obj);
		obj = new ShowEnum(Color.Green);
		objList.add(obj);
		obj = new ShowEnum(Color.Blue);
		objList.add(obj);
		
		for(ShowEnum param : objList) {
			switch(param.getColor()) {
			case Red :
				System.out.println("이 객체의 색상은 Red");
				break;
			case Green :
				System.out.println("이 객체의 색상은 GREEN");
				break;
			case Blue :
				System.out.println("이 객체의 색상은 BLUE");
				break;
			}
		}
	}

}
