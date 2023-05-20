package control;

import java.util.Scanner;

public class Quiz6_1 {
	
	/*
	 * 놀이기구 이용시간에 따른 요금은 계산하여 출력하세요
	 * 
	 * 기본 요금은 3천원이며 10분당 500원의 요금이 추가로 발생합니다
	 * 기본 요금이 적용되는 구간은 0 ~ 30분입니다 
	 * 
	 * 시간		금액
	 *  0 ~ 30	3,000원
	 * 31 ~ 40	3,500원
	 * 41 ~ 50	4,000원
	 * 51 ~ 60	4,500원
	 * ...
	 * 
	 * 이후 시간대에서도 동일한 규칙으로 적용되어야 합니다
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int time;
		int cost = 3000;

		System.out.print("몇분? >>");
		time = sc.nextInt();
		
		if(time > 30) {
			cost += (((time-31) / 10) + 1) * 500;
		}
		
		System.out.printf("요금 : %,d원\n", cost);
		sc.close();	
	}	
}
