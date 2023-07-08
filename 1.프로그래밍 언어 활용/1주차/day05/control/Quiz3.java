package control;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		// 서로 다른 두 정수를 입력받아서 큰 수를 출력하세요
		// 만약 같으면 아무 수나 출력해도 됩니다
		
		Scanner sc = new Scanner(System.in);
		int n1, n2, max;
		
		System.out.print("n1 입력 >> ");
		n1 = sc.nextInt();
		System.out.print("n2 입력 >> ");
		n2 = sc.nextInt();
		
		if(n1>n2) {
			max = n1;
		}
		else {
			max = n2;
		}
		System.out.println("큰 값 : " + max);
		sc.close();
	}
}
