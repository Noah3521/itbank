package file;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) throws Exception{

		// 1) 한국배우목록.txt 파일을 부럴올 수 있도록 파일 객체를 생성하세요
		// 파일 객체를 바로 출력해보세요
		
		File file = new File("한국배우목록.txt");
		System.out.println(file);
		System.out.println(file.toString());
		System.out.println(file.getName());			// 파일 이름
		System.out.println(file.getAbsolutePath());	// 절대 경로
		System.out.println(file.length());			// 용량, 파일 크기
		
		// 2) 파일 내용을 이용하여 이름이 3글자인 사람만 대상으로 하여
		// 성씨별로 인원수가 몇명인지 확인할 수 있는 HashMap을 만들어주세요
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		if(file.exists()) {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				if(s.length()==3) {
					char key = s.charAt(0);
					map.put(key, map.getOrDefault(key, 0)+1);
				}
			}
			sc.close();
		}
		
		ArrayList<Character> list = new ArrayList<Character>(map.keySet());
		
		System.out.println("\n\n\t\t가나다 순으로 정렬하여 출력 !!\n");
		list.sort(null);
		list.forEach(key->{System.out.println(key + "씨 : " + map.get(key));});
		
		
		System.out.println("\n\n\t\t인원수 순으로 정렬하여 출력 !!\n");
		list.sort((o1,o2)-> map.get(o2) - map.get(o1));
		list.forEach(key->{System.out.println(key + "씨 : " + map.get(key));});
	}
}










