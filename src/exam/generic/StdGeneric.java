/*
	[제네릭의 학습]
	- JDK1.5에서 추가
	- 자료구조를 다루는 collection클래스들은 모든 객체를 담을 수 있는 장점과,
	 	어떤 클래스가 담길지 모른다는 단점이 상존
	- 이러한 collection의 단점을 해결하기 위해 나론 이론
	
	- JDK1.4까지는 변수의 데이타형에 엄격함
		-> collection의 클래스들은 Object를 사용
		
	- 제너릭은 데이타형을 가상으로 정의 후 사용시 지정 가능
	
	[제네릭의 자료형]
		<T> : 전달되는 객체가 현 객체내에서 하나의 자료형으로 사용될 떄
		<E> : 전달되는 객체가 현 객체내에서 하나의 요소로 사용될 떄
		<K> : 전달되는 객체가 현 객체내에서  Key값으로 사용될 떄
		<V> : 전달되는 객체가 현 객체내에서 Value값으로 사용될 때
		
	[제네릭의 장점]
		-> 정의된 클래스나 메소드가 생성시에 데이타형을 지정하면,
		 	그 데이타형만을 위한 전용클래스로 사용 가능. 
 */


package exam.generic;

public class StdGeneric {

	public static void main(String[] args) {
		GenericEx<String> t = new GenericEx<String>();
		String strAry[] = {"박찬호", "박지성", "이영표"};
		t.set(strAry);
		t.print();
		
		GenericEx<Integer> i = new GenericEx<Integer>();
		Integer ii[] = {new Integer(10), new Integer(20), new Integer(30)};
		i.set(ii);
		i.print();
	}

}

class GenericEx<T> {
	T[] v;
	public void set(T[] n) {
		v = n;
	}
	
	public void print() {
		for(T s: v) {
			System.out.println(s);
		}
	}
}