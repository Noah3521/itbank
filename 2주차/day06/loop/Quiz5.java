package loop;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1;
		String tmp = "";
		
		System.out.println("입력 : ");
		n1 = sc.nextInt();
		
		while(n1 != 0) {
			tmp += n1 % 10;
			n1 /= 10;
		}
		System.out.println("tmp : " + tmp);
		sc.close();
		
		
		
		StringBuffer tmp2 = new StringBuffer(tmp);
		int cnt = 0;
		while(cnt <= tmp.length()) {
			if(cnt%3==0) {
				tmp2.insert(cnt, ',');
			}
			cnt++;
		}
		
		String res = "";
		
		cnt = 1;
		while(cnt <= tmp.length()) {
			res += tmp2.charAt(tmp2.length() - cnt);
			cnt++;
		}
		System.out.println(res);
	}
}
