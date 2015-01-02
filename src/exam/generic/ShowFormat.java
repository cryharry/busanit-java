package exam.generic;
import java.util.*;

public class ShowFormat {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Formatter f = new Formatter(sb);
		
		f.format("숫자는 %d, %f, %e, %x, %o\n", 255, 34.2, 34.2, 255, 255);
		System.out.println(sb);
		
		sb.delete(0, sb.length());
		Calendar now = Calendar.getInstance();
		f.format("현재 날짜는 %tY년 %tB %te일 %n", now, now, now);
		System.out.println(sb);
		
		sb.delete(0, sb.length());
		f.format("현재 시간은 %tk:%tM:%tS %n", now, now, now);
		System.out.println(sb);
	}

}
