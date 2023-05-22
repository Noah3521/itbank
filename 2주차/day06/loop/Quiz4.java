package loop;

import java.util.Random;
import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int answer = rand.nextInt(100) + 1;
		int input = -1;
		int cnt = 1;
		
		while(answer != input) {
			System.out.print("답? >> ");
			input = sc.nextInt();
			
			if (input == answer) {
				System.out.println(cnt + "번만에 맞춤!!");		
			}
			else if(input > answer) {
				System.out.println("다운");
			}
			else {
				System.out.println("업");				
			}
			cnt++;
		}
		sc.close();
	}
}
