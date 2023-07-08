package control;

import java.util.Scanner;

public class Quiz2 {
	/*
	 *  지하철 1구간 당 평균 이동시간이 4분이라고 가정한다
	 *  이동한 구간 수를 입력받아서, 걸린 시간을 출력하세요
	 *  단, 시간이 60분 이상이면 시간과 분을 구분하여 출력하고
	 *  시간이 60분 미만이면 분만 출력하세요
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int perStation = 4;
		int time;
		int hh;
		int mm;
		
		System.out.print("이동한 구간 수 >> ");
		time = sc.nextInt() * perStation;
		
		if(time >= 60) {
			hh = time / 60;
			mm = time % 60;
			System.out.printf("%d시간 %d분%n", hh, mm);
		}
		else {
			System.out.printf("%d분%n", time);			
		}
		sc.close();
	}	
}
