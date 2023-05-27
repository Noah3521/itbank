package nestedLoop;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int N = Integer.parseInt(sc.next());
		int M = Integer.parseInt(sc.next()) - 1;
//		System.out.println(N + " / "+ M);
		sc.nextLine();
		String[] arr = new String[N];
		String[] save = new String[N];
        
		for (int i = 0; i < N; i++) {
			String tmp = sc.nextLine();
//			System.out.println("tmp : " + i + " / " + tmp);
			save[i] = tmp;
			arr[i] = tmp;
		}

		Arrays.sort(arr, Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			if(save[i].equals(arr[M])) {
				answer = i + 1;
				if(i != 0 && save[i].equals(save[i-1])) {
					answer = i;
				}
			}
		}

		System.out.println(answer);
	
		sc.close();
	}
}
