package abstractClass;

class TestButton2 {

	protected void onClick() throws Exception {
		System.out.println("Test");
	}
}

class SquareButton2 {

	private int size;

	public SquareButton2(int size) {
		this.size = size;
	}

	protected void onClick() throws Exception {
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

// Ex02에서 상속과 오버라이딩이 빠진 코드
public class Ex03 {
	public static void main(String[] args) throws Exception {
		
		TestButton2 btn1 = new TestButton2();
		btn1.onClick();

		SquareButton2 btn2 = new SquareButton2(5);
		btn2.onClick();

		Object[] arr = { btn1, btn2 };
		
//		for(Object ob : arr) {
//			ob.onclick();
//			ob.click();
//		}
		// Object 클래스에는 click() 혹은 onclick()이라는 함수가 없어서 호출 불가
		// 개별 실행은 가능하지만, 일괄 처리는 불가능하다
		
	}
}
