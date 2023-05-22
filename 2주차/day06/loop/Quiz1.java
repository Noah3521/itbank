package loop;

import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		
		// 정수를 하나 입력받아서, 1부터 입력받은 정수까지 한 줄에 출력하는 코드를 작성하세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 하나 입력 >> ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	
		sc.close();
		System.out.println("프로그램 종료");
	}
}
