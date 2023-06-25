package collection;

import java.util.ArrayList;

abstract class Student {
	private String name;
	private int kor, eng, mat;
	private int sum;
	private double avg;
	
	public Student(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = kor + eng + mat;
		this.avg = sum / 3.0;
	}
	
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMat() {
		return mat;
	}
	public int getSum() {
		return sum;
	}
	public double getAvg() {
		return avg;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
}


class LiteralStudent extends Student {
	
	private int literature;
	
	public LiteralStudent(String name, int kor, int eng, int mat, int literature) {
		super(name, kor, eng, mat);
		this.literature = literature;
		setSum(kor + eng + mat + literature);
		setAvg(getSum() / 4.0);
	}

	public int getLiterature() {
		return literature;
	}

	public void setLiterature(int literature) {
		this.literature = literature;
	}
}

class ComputerScienceStudent extends Student {

	private int c, java;
	
	public ComputerScienceStudent(String name, int kor, int eng, int mat, int c, int java) {
		super(name, kor, eng, mat);
		this.c = c;
		this.java = java;
		setSum(kor + eng + mat + c + java);
		setAvg(getSum() / 5.0);
	}	
	
	public int getC() {
		return c;
	}
	public int getJava() {
		return java;
	}
	public void setC(int c) {
		this.c = c;
	}
	public void setJava(int java) {
		this.java = java;
	}	
}

public class Ex04 {
	
	public static void main(String[] args) {
		// 제네릭 타입을 Student로 지정하여 Student에 해당하는 객체만 넣을 수 있게 한 경우
		// 내부 객체는 모두 Student이므로, Student에 정의된 메서드를 형변환 없이 바로 호출할 수 있다.
		ArrayList<Student> list = new ArrayList<Student>();
		
		LiteralStudent st1 = new LiteralStudent("짱구", 67, 78, 89, 90);
		ComputerScienceStudent st2 = new ComputerScienceStudent("철수", 45, 56, 67, 89, 92);
		
		list.add(st1);
		list.add(st2);
		
		list.forEach(st -> System.out.printf("%s : %.2f\n", st.getName(),st.getAvg()));
		
		// 만약, 제네릭타입을 지정하지 않은 리스트에 동일한 작업을 수행한다면...
		ArrayList list2 = new ArrayList();
		
		list2.add(st1);
		list2.add(st2);
		
//		list2.forEach(st -> System.out.println("%s : %.2f\n", st.getName(), st.getAvg()));
		for(int i = 0 ; i < list.size(); i++) {
			Object o = list.get(i);
			Student st = (Student) o;
			System.out.printf("%s : %.2f\n", st.getName(), ((Student)list.get(i)).getAvg());
		}
	}
	
}
