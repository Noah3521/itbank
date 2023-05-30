package oop;

public class Ex01 {

	public static void main(String[] args) {

		String[] nameArray = { "짱구", "유리", "훈이", "맹구", "철수" };
		double[] heightArray = { 105.9, 104.2, 106.2, 113.9, 108.7 };

		for (int i = 0; i < 5; i++) {
			String name = nameArray[i];
			double height = heightArray[i];
			System.out.printf("%s의 키는 %.1fcm입니다\n", name, height);
		}
		System.out.println();

		// 위 배열 데이터를 이용하여 이름 기준 오름차순으로 정렬하고 다시 출력하세요

		for (int i = 0; i < 5 - 1; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (nameArray[i].compareTo(nameArray[j]) > 0) {
					String tmp1 = nameArray[i];
					nameArray[i] = nameArray[j];
					nameArray[j] = tmp1;

					double tmp2 = heightArray[i];
					heightArray[i] = heightArray[j];
					heightArray[j] = tmp2;
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			String name = nameArray[i];
			double height = heightArray[i];
			System.out.printf("%s의 키는 %.1fcm입니다\n", name, height);
		}
		System.out.println();
	}
}
