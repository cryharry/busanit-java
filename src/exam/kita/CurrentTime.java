package exam.kita;

import java.util.Calendar;

public class CurrentTime {

	 static String strName;
	
	public String getTime()
	{
		return strName;
	}

	public static void main(String[] args) {
		Calendar rightNow = Calendar.getInstance();
		
		int hour = rightNow.get(Calendar.HOUR);
		int min = rightNow.get(Calendar.MINUTE);
		int sec = rightNow.get(Calendar.SECOND);
		int ampm = rightNow.get(Calendar.AM_PM);
		int Day = rightNow.get(Calendar.DATE);
		strName = Day +":" +hour + ":" + min + ":" + sec;
		
		if(ampm == Calendar.AM)
			System.out.print("현재 시간은 AM: ");
		else
			System.out.print("현재 시간은 PM: ");
		
		System.out.println(Day + "일 " + hour + "시" + min + "분" + sec + "초");
	}

}
