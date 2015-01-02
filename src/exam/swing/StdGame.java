package exam.swing;

import java.io.*;

public class StdGame {

	private boolean gameFlg = true;
	private int catchNum;
	private int iCatchIdx [] = new int[3];
	private static String aryStr[] = {"박찬호", "설기현", "박지성"};
	
	private void startGame() {
		BufferedReader br = null;
		String strInput = null;
		boolean catchBool = false;
		for( ; ; )
		{
			System.out.println("범인의 이름을 입력하시오: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			
			try 
			{
				strInput = br.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			catchBool = compareStr(strInput);
			
			if(catchBool)
			{
				System.out.println("잡았습니다");
				System.out.println("잡은 범인의 수: " + catchNum+ "명");
			}
			else
			{
				System.out.println("놓쳤습니다");
			}
			
			if(catchNum > 2) break;
		}
	}
	
	public boolean compareStr(String strVal) {
		boolean resFlg = false;
		for(int i=0; i<aryStr.length; i++)
		{
			if(aryStr[i].equals(strVal))
			{
				resFlg = true;
				catchNum++;
				iCatchIdx[i] = i;
				
				break;
			}
		}
		
		return resFlg;
	}
	
	public static void main(String[] args) {
		StdGame sg = new StdGame();
		sg.startGame();
	}	

}
