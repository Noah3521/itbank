package function;

public class Quiz2 {
	// 1) 정거장 구간 수에 따른 걸린 시간을 문자열로 반환하기
	// (구간당 4분으로 계산하며, 60분을 초과하면 시간과 분으로 구분하여 반환하기)
	
	// 2) 놀이기구 이용 시간에 따른 요금을 문자열로 반환하기
	// 기본 30분까지는 3천원, 이후 10분당 500원의 추가 요금 발생
	// (천단위 구분기호를 찍어서 처리해야함)
	
	// 3) 두 정수를 전달받아서, 두 정수 사이의 모든 수의 합을 구하여 반환하기
	// (두 정수의 대소관계는 정해져있지 않음)
	
	public static void main(String[] args) {
		System.out.println(quiz1(12));
		System.out.println(quiz1(16));
		
		System.out.println(quiz2(25));		
		System.out.println(quiz2(40));
		System.out.println(quiz2(41));
		
		System.out.println(quiz3(1, 10));
		System.out.println(quiz3(10, 1));
	}
	
	static int quiz3(int n1, int n2) {
		int sum = 0;
		if (n2 < n1) {
			int tmp = n1;
			n1 = n2;
			n2 = tmp;
		}
//		for(int i = n1; i <= n2; i++) 
//			sum += i;
		sum = (n1 + n2) * (n2 - n1 + 1) / 2;
		return sum;
	}
	
	static String quiz2(int time) {
		int cash = 3000; 
		if (time > 30) 
			cash += (((time - 31) / 10) + 1) * 500;
		String s = String.format("%,d원", cash);
		return s;
	}
	
	static String quiz1(int perStation) {
		int time = perStation * 4;
		int hh = time / 60;
		int mm = time % 60;
		String s = "걸린시간 : ";
		if (hh > 0) s+=(hh+"시간 ");
		s+=(mm+"분");
		return s;
	}
	
}
