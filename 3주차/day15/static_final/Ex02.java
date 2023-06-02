package static_final;

class Guest {
	String name; 		// non-static 필드
	static int count;	// static 필드
	
	Guest(String name) {	// 생성자
		this.name = name;
		count += 1;			// 객체를 생성할 때 마다, count의 값을 1증가시킨다
	}
	
	void show() {
		System.out.println(name + " 입장!!");
		System.out.println("현재까지 입장한 손님의 인원 수 : " + count);
	}
}

public class Ex02 {
	public static void main(String[] args) {
		Guest ob1 = new Guest("이지은");
		ob1.show();
		
		Guest ob2 = new Guest("홍진호");
		ob2.show();
		ob2.show();
		
		System.out.println("현재까지의 손님 수 : " + Guest.count);
	}
}
