package oop;

// 기본에 없던, 내가 새로 정의한 자료형 (클래스)

class Kid {
	// 서로 다른 자료형의 변수
	String name;
	double height;

	// 함수
	void show() {
		System.out.printf("%s의 키는 %.1f입니다\n", name, height);
	}

	void setData(String name, double height) {
		this.name = name;
		this.height = height;
	}
}

public class Ex02 {
	public static void main(String[] args) {
		Kid o1 = new Kid();
		Kid o2 = new Kid();
		Kid o3 = new Kid();
		Kid o4 = new Kid();
		Kid o5 = new Kid();

		o1.setData("짱구", 105.9);
		o2.setData("유리", 104.2);
		o3.setData("훈이", 106.2);
		o4.setData("맹구", 113.9);
		o5.setData("철수", 108.7);

		// 같은 자료형(kid)의 데이터가 여러개 있으므로, 배열로 묶을 수 있다

		Kid[] arr = { o1, o2, o3, o4, o5 };
		
		for(int i = 0 ; i < arr.length-1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i].name.compareTo(arr[j].name) > 0) {
					Kid tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		for(int i = 0 ; i < arr.length;i++) {
			arr[i].show();
		}
		System.out.println();
		
		
	}
}
