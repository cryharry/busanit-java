package exam.swing;

public class MathRan {

	public MathRan()
	{
		int xAry[] = new int[10];
						
		for(int i=0; i<xAry.length; i++)
		{
			
			int x =(int)(Math.random()*9);
			
			for(int j=0; j<10; j++)
			{
				if(x == xAry[j])
				{
					x = (int)(Math.random()*9);
					break;
				}
			}
			xAry[i] = x;
			System.out.println(xAry[i]);
		}
	}
	public static void main(String[] args) {
		new MathRan();
	}

}
