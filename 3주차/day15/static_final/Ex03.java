package static_final;

class Test2 {
	// final : 한번 정하면 변경할 수 없다. 마지막 값이다
	// 			절 대 바 꿀 수 없 다
	// 지역변수에 사용가능, 처음 설정한 값을 이후 변경할 수 없다
	// 멤버필드에 사용가능, 처음 설정한 값을 이후 변경할 수 없다
	// 메서드에 사용가능, 함수의 내용을 변경할 수 없다 (오버라이딩 불가)
	// 클래스에 사용가능, 클래스의 구성을 변경할 수 없다 (상속 불가)
	
	final int n3 = 10;
	final int n4;
	private final int n5 = 30;
	public static final String ACADEMY_NAME = "ITBANK";
	// static final 필드 : 대문자, 언더바 조합
//	ex)
//	final int n6 = Integer.MAX_VALUE;
	
	Test2(int n4) {		// final 멤버필드는 생성자를 통한 초기화가 가능하다
		this.n4 = n4;
	}
	
	public int getN5() {	// final 필드에 대한 getter는 생성 가능
		return n5;			// setter는 값을 대입하는 함수이므로 생성 불가
	}
	
}

public class Ex03 {
	public static void main(String[] args) {
		int n1 = 10;
		final int n2 = 20;

		System.out.println(n1);
		System.out.println(n2);

		n1 += 1;
//		n2 += 1;
//		The final local variable n2 cannot be assigned. 
//		It must be blank and not using a compound assignment

		System.out.println("학원 이름 : " + Test2.ACADEMY_NAME);
	}
}
