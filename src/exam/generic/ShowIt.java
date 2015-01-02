package exam.generic;

import java.util.*;

public class ShowIt {
  
  public static void main(String[] args) {
    
    // 1. 제네릭간에 상속이 있고, 같은 인자형인 경우
    // 일반적인 상하위 클래스의 관계가 성립
    List<String> list1 = new Vector<String>();
    
    // 2. 제네릭간에 상속이 있고, 인자가 다른 경우
    // 서로 다른 데이터형이 되버림
 //   List<String> list2 = new Vector<Random>();
    
    // 3. 제네릭간에 관련이 없고, 인자가 같은 경우
    // 인자가 같아도, 제네릭간의 관계가 우선됨
 //   Vector<String> list3 = new LinkedList<String>();
    
    // 4. 인자간에 상속이 있는 경우
    // 인자간의 상하위 클래스 관계보다는 제네릭간의 관계가 우선됨
 //   Vector<Object> list4 = new Vector<String>();
    
    // 5. ? 키워드를 사용하는 경우 
    // 인자로 지정한 상위 클래스의 하위 클래스로 만들어진 인자화 데이터형은 가능
    Vector<? extends Object> list5 = new Vector<String>();
    Vector<? extends Object> list6 = new Vector<Random>();
  }
}
