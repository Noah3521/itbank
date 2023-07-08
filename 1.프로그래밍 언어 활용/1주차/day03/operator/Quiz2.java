package operator;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		long cardNumber;
		Scanner sc = new Scanner(System.in);
		String answer = "";
		
		System.out.print("카드번호 16자리를 입력 >> ");
		cardNumber = Long.parseLong(sc.nextLine());
		
		// 위 숫자를 4자리씩 분리하여 사이에 "-"를 더하여 다시 출력하세요
		
		for(int i = 0; i < 4; i++) {
			answer += cardNumber % 10000;
			if(i!=3)answer += "-";
			cardNumber /= 10000;
		}
		
		System.out.println("answer :  " + answer);
		sc.close();
	}
}
