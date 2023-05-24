package loop;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		
		// 사용자에게 1 ~ 100 사이의 정수를 입력받아서
		// 전체 길이에서 입력한 수치 이전은 #을 출력하고
		// 이후는 공백을 출력한다
		// 단, 항상 가운데에는 입력한 수치를 % 형태로 출력해야 한다
		
		// [##########          50%            ]
		System.out.print("입력 : ");
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		int half = input/2;
		
		System.out.print("[");
		for (int i = 0; i < 50; i++) {	// # 혹은 공백을 출력하는 전체 칸은 50칸
			if (i==25) {				// 전체 칸 수의 절반 위치에서 퍼센트 출력
				System.out.printf(" %3d %% ", input);
			}
			if(i < half) // 입력값(절반)보다 작은 구간은 #
				System.out.print("#");
			else 		 // 입력값(절반)보다 크거나 같은 구간은 공백
				System.out.print(" ");
		}
		System.out.println("]");
		
		System.out.println("끝");
		
		sc.close();
	}
}
