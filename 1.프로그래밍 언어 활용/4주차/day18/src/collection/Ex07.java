package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Ex07 {
	public static void main(String[] args) {
		Random rand = new Random();
		// 1 ~ 45 사이의 중복없는 숫자 6개를 뽑아서 오름차순으로 정렬하여 한줄에 출력하세요
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(set.size()<6) {
			set.add(rand.nextInt(45) + 1);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>(set);
//		set.forEach(num -> list.add(num));
		
		list.sort(null);
		
		System.out.println(list);
	}
}
