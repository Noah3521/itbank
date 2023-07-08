package array;

import java.util.Arrays;
import java.util.Random;

public class Quiz3 {
	public static void main(String[] args) {
		
		Random rand = new Random();
		int size = 10;
		int range = 100;
		int[] arr = new int[size];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(range);
		}
		System.out.println(Arrays.toString(arr));
		
		
		// 1) arr의 값에서 홀수와 짝수가 각각 몇개인지 파악하여 출력하세요
		
		int oddCnt = 0, evenCnt = 0;
		for(int num :  arr) {
			if (num%2==0) {
				evenCnt += 1;
			}
			else {
				oddCnt += 1;
			}
		}
		System.out.println("1) 홀수의 개수 : " + oddCnt);
		System.out.println("1) 짝수의 개수 : " + evenCnt);
		System.out.println();
		
		// 2) oddArray와 evenArray를 생성하여 각각 홀수와 짝수를 담아서 출력하세요
		
		int[] oddArray = new int[oddCnt];
		int[] evenArray= new int[evenCnt];
		int oddIdx = 0, evenIdx = 0;
		
		for(int i = 0; i < arr.length; i++) {
			int n = arr[i];
			if (n % 2 == 0) {
				evenArray[evenIdx++] = n;
			}
			else {
				oddArray[oddIdx++] = n;
			}
		}
		System.out.println("2) oddArray : " + Arrays.toString(oddArray));
		System.out.println("2) evenArray : " + Arrays.toString(evenArray));
		System.out.println();
		
		// 3) arr의 총합을 구하여 출력하세요
		int sum = 0;
		for(int num : arr) {
			sum += num;
		}
		System.out.println("3) 총합 : " + sum);
	}
}
