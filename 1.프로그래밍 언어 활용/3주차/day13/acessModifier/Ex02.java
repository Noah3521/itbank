package acessModifier;

class Test2 { // 접근제한자를 사용하지 않은 크래스
	String name;
	int age;

	public void setName(String name) { // 외부에서 넘어온 값을 저장하는 매개변수
		this.name = name; // 매개변수의 값을 멤버필드에 저장한다
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

public class Ex02 {
	public static void main(String[] args) {
		Test2 ob = new Test2();
		ob.name = "이지은";
		ob.age = 31;
		System.out.printf("%s의 나이는 %d살입니다\n", ob.name, ob.age);

		Test2 ob2 = new Test2();
//		ob2.name = "홍진호"
		ob2.setName("홍진호");
//		ob2.age = 42
		ob2.setAge(42);

		System.out.printf("%s의 나이는 %d살입니다\n", ob2.getName(), ob2.getAge());
	}
}
