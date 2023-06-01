package student;

// 학생관리 프로그램에서 1명의 학생 정보를 저장할 객체의 클래스를 구성합니다
// 이름, 국어, 영어, 수학, 합계 평균 정보를 저장합니다
// 생성자에서는 이름과 국영수 점수만 전달받습니다
// 국영수 점수를 이용하여 합계와 평균을 계산하여 저장합니다
// show() 함수를 작성하여 이름과 합계 및 평균을 화면으로 출력합니다
// 필드는 private, 생성자와 메서드는 public으로 설정합니다.

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;

	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.avg = total / 3.0;
	}
	
	public double getAvg() {
		return avg;
	}

	public String getName() {
		return name;
	}

	public void showAll() {
		System.out.printf("│%5s\t│%5d\t│%5d\t│%5d\t│%5d\t│%5.2f\t│\n", name, kor, eng, math, total, avg);
		System.out.println("├───────┼───────┼───────┼───────┼───────┼───────┤");

	}

	public void show() {
		System.out.printf("│%5s\t│%5d\t│%5.2f\t│\n", name, total, avg);
		System.out.println("├───────┼───────┼───────┤");
	}
}
