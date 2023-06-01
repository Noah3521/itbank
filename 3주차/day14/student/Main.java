package student;

import java.util.Scanner;

public class Main {
	
	static void show(Student[] arr) {
		System.out.println("   이름	     총점	      평균");
		System.out.println("┌───────┬───────┬───────┐");
		for(int i = 0 ; i < arr.length;i++) {
			if(arr[i]!=null) {
				arr[i].show();
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 키보드 입력
		Handler handler = new Handler(); // 데이터 관리 및 기능 수행

		Student s1 = new Student("김철수", 100, 98, 89);
		Student s2 = new Student("김칠수", 66, 56, 74);
		Student s3 = new Student("김촐수", 74, 88, 64);
		handler.add(s1);
		handler.add(s2);
		handler.add(s3);

		int menu; // 사용자가 입력한 메뉴번호
		Student tmp = null; // 관리에 필요한 학생 임시 변수
		String keyword; // 검색어
		String name; // 생성시 필요한 이름
		int kor, eng, math; // 생성시 필요한 과목점수
		Student[] arr = null; // 검색 및 전체 목록을 받을 배열 변수
		int row = 0;

		while (true) {
			
			System.out.println("1. 전체목록");
			System.out.println("2. 추가");
			System.out.println("3. 검색");
			System.out.println("4. 삭제");
			System.out.println("5. 전체목록(상세)");			
			System.out.println("6. 점수순으로 보기");			
			System.out.println("0. 종료");
			
			System.out.print("선택 >>> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			
			case 1: // 전체 목록
				arr = handler.getArray();
				show(arr);
				break; // break switch
				
			case 2: // 추가
				System.out.print("이름 >> ");
				name = sc.nextLine();
				
				System.out.print("국어 점수 >> ");
				kor = Integer.parseInt(sc.nextLine());
				
				System.out.print("영어 점수 >> ");
				eng = Integer.parseInt(sc.nextLine());
				
				System.out.print("수학 점수 >> ");
				math = Integer.parseInt(sc.nextLine());
				
				tmp = new Student(name, kor, eng, math);
				
				row = handler.add(tmp);
				
				System.out.println(row != 0 ? "추가 성공" : "추가 실패");
				
				break;
				
			case 3: // 검색
				System.out.print("검색어 입력 >> ");
				keyword = sc.nextLine();
				
				arr = handler.search(keyword);
				
				show(arr);
				
				break;
				
			case 4: // 삭제
				System.out.print("삭제할 이름 >> ");
				
				keyword = sc.nextLine();
				
				row = handler.delete(keyword);
				
				System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
				
				break;
			
			case 5:
				arr = handler.getArray();
				System.out.println("   이름	      국어	      영어	      수학	      총점	      평균");
				System.out.println("┌───────┬───────┬───────┬───────┬───────┬───────┐");
				for(int i = 0; i < arr.length; i++) {
					if(arr[i]!=null)
						arr[i].showAll();
				}
				
				break;
			
			case 6:
				arr = handler.getSortedArray();
				show(arr);
				break;
				
			case 0: // 종료
				
				System.out.println("프로그램 종료");
				
				sc.close();
				
				return;
			}
			System.out.println();
		}	// end of while
	}	// end of main
}	// end of class