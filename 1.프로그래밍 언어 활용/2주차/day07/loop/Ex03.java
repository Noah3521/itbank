package loop;

public class Ex03 {
	public static void main(String[] args) {

		// 1) 1부터 100 사이의 홀수의 합과 짝수의 합을 for문으로 계산하여 출력하세요

		int odd = 0, even = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				even += i;
			} 
			else {
				odd += i;
			}
		}
		System.out.printf("1) 홀수 : %d, 짝수 : %d%n", odd, even);

		// 2) A부터 Z까지 띄어쓰기로 구분하여 한 줄에 출력하세요
		
		// 알파벳 개수 26개
		System.out.printf("2) ");
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.printf("%c ", i);
		}
		System.out.println();

		// 3) 빈 문자열에 *기호를 5번 추가하여 출력하세요
		
		String s = "";
		for (int i = 0; i < 5; i++) {
			s += "*";
		}
		System.out.println("3) " + s);
		
	}
}