package exam.generic;

public class NewGen<T> {
	
	private T tMember;
	
	public NewGen() {
		
	}
	
	public T getMember() {
		return tMember;
	}
	
	public void setMamber(T member) {
		tMember = member;
	}

	public static void main(String[] args) {
		NewGen<String> sGen = new NewGen<String>();
		sGen.setMamber("하하하");
		String str = sGen.getMember();
		System.out.println("돌려받은 값은 " + str);
		
		NewGen<Integer> iGen = new NewGen<Integer>();
		iGen.setMamber(100);
		int val = iGen.getMember();
		System.out.println("돌려받은 값은 " +val);
	}

}
