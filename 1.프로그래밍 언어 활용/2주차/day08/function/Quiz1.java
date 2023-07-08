package function;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Quiz1 {
	static int abs(int num) {
		return num < 0 ? -num : num;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int[] arr = new int[3];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(15) + 1;
		}

		System.out.println(Arrays.toString(arr));
		// 3대의 엘리베이터가 있다
		// 사용자에게 현재 층수를 입력받아서 가장 가까운 엘리베이터가 움직이도록 출력하세요
		// 처음부터 순서대로, 엘리베이터의 이름을 A, B, C라고 하면
		// "%s 엘리베이터가 이동합니다" 라고 출력해야 합니다

		System.out.print("몇층? >> ");
		int currentFloor = sc.nextInt();

		int min = 14;
		int index = 0;

		for (int i = 0; i < arr.length; i++) {
			// i번째 엘리베이터의 층수와, 요청받은 층수의 차이를 출력
			int diff = abs(arr[i] - currentFloor);
			if (min > diff) {
				min = diff;
				index = i;
			}
			System.out.print(diff + " ");
		}

		System.out.println();
		System.out.printf("%c 엘리베이터가 이동합니다%n", 'A' + index);
		char ele = geteNearElebatorName(arr, currentFloor);
		System.out.printf("%c 엘리베이터가 이동합니다%n", ele);

		sc.close();
	}

	static char geteNearElebatorName(int[] arr, int currentFloor) {
		char ele = 'A';
		int index = 0;
		int min = 14;

		// 1) 현재층과 각 엘리베이터의 차이 구하기
		for (int i = 0; i < arr.length; i++) {
			int diff = arr[i] - currentFloor;

			// 2) 차이에 절대값 처리하기 (거리)
			if (diff < 0) {
				diff = -diff;
			}
			// 3) 거리중 최소값을 찾아서 index 구하기
			if (min > diff) {
				min = diff;
				index = i;
			}
		}
		// 4) index를 ele에 더하고 반환하기
		ele += index;
		return ele;
	}
}
