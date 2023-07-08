package function;

public class Ex03 {
	
	static int abs(int num) {
		int answer = 0;
		// 여기에 코드를 작성한다 (매개변수를 활용한 코드)
		if(num < 0) answer = -num;
		else 		answer = num;
		return answer; 
	}
	
	// main함수가 static 속성이므로, main에서 바로 호출하려면 함수도 static이여야 한다
	
	public static void main(String[] args) {
		// 1)
		// 정수를 하나 전달받아서 정수의 절대값을 반환하는 함수
		// int를 하나 전달받아서, int를 반환한다 (반환값은 하나만 가능)
		System.out.println("abs(-3) : " + abs(-3));
		System.out.println("abs(3) : " + abs(3));
		
		
		// 2)
		// 정수로 반지름을 전달받아서, 원의 넓이를 계산하여 반환하는 함수를 작성하세요 
		// 원의 넓이 = 반지름 * 반지름 * 3.14
		double s1 = getCircleSize(3);
		double s2 = getCircleSize(4);
		System.out.printf("s1 : %.2f%n", s1);
		System.out.printf("s2 : %.2f%n", s2);
		
		
		// 3)
		// 두 정수를 전달하여, 큰 값을 반환하는 함수를 작성하세요
		int n1 = getBigNumber(5, 3);
		int n2 = getBigNumber(-5, 3);
		System.out.println("n1 : " + n1);
		System.out.println("n2 : " + n2);
	}
	
	static int getBigNumber(int n1, int n2) {
		// return n1 > n2 ? n1 : n2;
		int answer = 0;
		if (n1 > n2) answer = n1;
		else 		 answer = n2;
		return answer;
	}
	
	static double getCircleSize(int radius) {
		double answer = 0;
		answer = radius * radius * 3.14;
		return answer;
	}
}
