package exam.collection;
import java.util.*;

class Member {
	private String name;
	private String id;
	private String telephone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}

class Product {
	private String pname;
	private String pid;
	private String price;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
public class AppVector {
	
	public static void main(String[] args) {
		Member mb1 = new Member();
		Member mb2 = new Member();
		mb1.setId("mcdonald");
		mb1.setName("박찬호");
		mb1.setTelephone("051-631-1175");
		mb2.setId("usnsol");
		mb2.setName("권종만");
		mb2.setTelephone("051-123-1234");
		
		Vector<Member> memvec = new Vector<Member>();
		memvec.add(mb1);
		memvec.add(mb2);
		
		// 출력
		Member mb3 = memvec.get(0);
		
		System.out.println(mb3.getId());
		System.out.println(mb3.getName());
		System.out.println(mb3.getTelephone());
		
		Vector<Product> provec = new Vector<Product>();
		Product pr1[] = new Product[2];
//		Product pr2 = new Product();
		for(int i=0; i<pr1.length; i++)
		{
			pr1[i] = new Product();
		}
		pr1[0].setPid("001");
		pr1[0].setPname("네비게이션");
		pr1[0].setPrice("10000");
		pr1[1].setPid("002");
		pr1[1].setPname("PDP");
		pr1[1].setPrice("20000");
		
		for(int i=0; i<pr1.length; i++)
		{
			provec.add(pr1[i]);
		}
		//provec.add(mb1); <--에러 : 벡터의 타입 에러
		//provec.add(pr2);
		
		for(int i=0; i<2; i++)
		{
			System.out.println(provec.get(i).getPid());
			System.out.println(provec.get(i).getPname());
			System.out.println(provec.get(i).getPrice());
		}
	}
}
