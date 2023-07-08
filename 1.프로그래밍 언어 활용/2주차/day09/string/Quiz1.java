package string;

public class Quiz1 {
	public static void main(String[] args) {
		// Luhn 알고리즘

		/*
		 카드번호 16자리의 글자를 이용하여 카드번호의 유효성을 검증하는 알고리즘
		 우측부터 세어서 홀수번째는 그대로 두고 짝수번째는 두배로 만든다
		 만약 두배로 만들어진 값이 두자리수가 되면 각 자릿수를 합한다 
		 이렇게 만들어진 16자리의 정수를 모두 더하여 그 합이 
		 10으로 나누어 떨어지면 유효한 카드번호, 그렇지 않으면 유효하지 않은 카드번호이다
		  
		 문자열로 카드번호를 xxxx-xxxx-xxxx-xxxx 형식으로
		 전달받아서 유효성을 true/false로 반환하는 함수를 작성하고 테스트하세요
		 */
		String card1 = "4481-2581-2620-9117";
		String card2 = "4854-8002-5204-7826";
		String card3 = "1720-1234-5678-1357";
		String card4 = "1720-1234-5678-13571";
			
		System.out.println(luhn(card1));
		System.out.println(luhn(card2));
		System.out.println(luhn(card3));
		System.out.println(luhn(card4));
		
	}

	static boolean luhn(String input) {
		boolean answer = false;
		input = input.replace("-", ""); // - 제거
		
		if(input.length()!=16)	// -를 뺀 카드번호의 길이가 16이 아니면 
			return false;		// 함수를 중단하면서 false반환

		int sum = 0;
		for (int i = input.length() - 1; i >= 0; i--) { 
			int n = input.charAt(i)-'0';
			if (i % 2 == 0) { // 짝수번째
				n *= 2;
				if (n > 9)
					n = n % 10 + 1;
			} 
			sum += n;
		}
		answer = sum % 10 == 0;
		return answer;
	}

}
