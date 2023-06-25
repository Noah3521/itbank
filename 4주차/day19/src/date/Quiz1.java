package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Quiz1 {
	public static void main(String[] args) throws ParseException {
		// 매월 2주, 4주 일요일은 대형마트 휴무일입니다
		// 2023년 대형마트 휴무일은 총 몇일인지 계산하여 출력하세요

		SimpleDateFormat sdf1 = new SimpleDateFormat("MM:E");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");

		String begin = "2023-01-01";
		String end = "2023-12-31";

		// 날짜형태로 변환
		Date d1 = sdf2.parse(begin);
		Date d2 = sdf2.parse(end);

		int totalDay = 0; // 총 일수 담을 변수

		// begin ~ end 까지 하루단위로 증가
		int month = 1;
		int sun = 0;
		for (long i = d1.getTime(); i <= d2.getTime(); i += 1000 * 60 * 60 * 24) {

			String s = sdf1.format(new Date(i)); // n월:n일로 변환

			int mm = Integer.parseInt(s.split(":")[0]);
			String dd = s.split(":")[1];

			if (dd.equals("일")) {	
				sun += 1;
				if (sun == 2 || sun == 4) {	// 2번째 혹은 4번째일때 출력 및 합계 증가
					totalDay++;
					System.out.printf("%s (%d)\t", sdf3.format(i), sun);
				}
			}

			if (month != mm) {
				System.out.println();
				month = mm;
				sun = 0;
			}

		}
		System.out.println();
		System.out.println();
		System.out.println("2023년 대형 마트 휴무일은 총" + totalDay + "일입니다 ");

	}
}