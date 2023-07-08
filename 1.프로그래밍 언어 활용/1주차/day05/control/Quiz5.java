package control;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		
		/*
		 * 사탕 1개에 500원 입니다.
		 * 50개 이상 구매하면 전체의 8%를 할인하고
		 * 100개 이상 구매하면 전체의 12%를 할인합니다
		 * 
		 * 구매 수량을 입력하여 결제할 금액을 계산하여 출력하세요
		 * (단, 각각의 할인율은 중복해서 적용할 수 없습니다)
		 */
		
		Scanner sc = new Scanner(System.in);
		int candyCnt;
		int price = 500;
		double sale = 1;
		
		System.out.print("사탕 개수 >> ");
		candyCnt = sc.nextInt();
		
		if (candyCnt >= 100) {
			sale -= 12/100f;
		} 
		else if(candyCnt >= 50) {
			sale -= 8/100f;
		}
		
		System.out.printf("결제 금액 : %,d원\n", (int)(candyCnt * price * sale));
		
		sc.close();
	}
}
