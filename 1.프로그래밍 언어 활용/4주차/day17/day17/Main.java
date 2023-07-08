package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		String input = bf.readLine(); 	// x y...z 형태로 입력
		String[] tmp = input.split(" ");// arr[0] = x, arr[1] = y ... arr[N - 1] = z;
		
		// key = 입력한 값, value = 입력한 값의 개수
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		// N번 반복
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(tmp[i]); 
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1); // n이 존재한다면 value를 += 1
			} 
			else {
				map.put(n, 1);
			}
		}
//		System.out.println(map);

		int M = Integer.parseInt(bf.readLine());
		String input2 = bf.readLine(); 	  // x y...z 형태로 입력
		String[] tmp2 = input2.split(" ");// arr[0] = x, arr[1] = y ... arr[M - 1] = z;
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(tmp2[i]); 
			System.out.print(map.get(n) !=null ? map.get(n) + " " : "0 ");
		}
	}
}
