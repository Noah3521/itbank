package book;

import java.util.Scanner;

public class Main {

	static Handler getTmp() {
		Handler handler = new Handler();
		
		Book b1 = new Book("세이노의 가르침", "세이노", "2023-03", 4, 7200);
		Book b2 = new Book("역행자 확장판", "자청", "2023-05", 4, 19500);
		Book b4 = new Book("최애의 아이 10", "아카사카 아카", "2023-05", 5, 6000);
		Book b5 = new Book("사장학개론", "김승호", "2023-04", 4, 25000);
		Book b6 = new Book("모든 삶은 흐른다", "로랑스 드빌레르", "2023-04", 4, 16800);
		Book b7 = new Book("돈은, 너로부터다", "김종봉", "2023-05", 4, 17100);
		Book b8 = new Book("도둑맞은 집중력", "요한 하리", "2023-04", 4, 18800);
		Book b9 = new Book("메리골드 마음 세탁소", "윤정은", "2023-03", 4, 15000);
		Book b10 = new Book("원피스 ONE PIECE 105", "오다 에이이치로", "2023-05", 4, 5500);
		Book[] arr = { b1, b2, b4, b5, b6, b7, b8, b9, b10 };
		
		for(int i = 0 ; i < arr.length; i++) {	// 더미데이터 추가
			handler.add(arr[i]);
		}
		
		return handler;	// 더미데이터가 포함된 handler 반환
	}

	private static void show(Book[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null) {	// 해당 Book 객체가 비어있지 않다면
				System.out.println("┌───────────────────────────────┐");
				arr[i].show();		// 해당 Book 객체 값 출력
				System.out.println("└───────────────────────────────┘");
			}
		}
	}
	
	public static void main(String[] args) {
		Handler handler = getTmp();		// 관리 및 기능 (더미데이터)
		Scanner sc = new Scanner(System.in);	// 입력
		Book[] arr;		// 책 목록을 받을 배열
		int menu;		// 사용자가 입력한 메뉴 번호
		Book tmp;		// 관리에 필요한 책 임시 변수
		String title, writer, publishDate;	// 책 생성시
		int rating, price;					// 필요한 정보
		String keyword;	// 검색어
		int searchType;	// 검색할 조건
		int row; // 기능 수행 여부 확인
		
		do {	// 일단 한번 실행
			System.out.println("1. 도서 목록");
			System.out.println("2. 도서 추가");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 전체 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >>> ");
			menu = Integer.parseInt(sc.nextLine());	// 입력한 값을 menu에 저장
			
			switch (menu) {
			case 1:
				arr = handler.getArray();	// 전체 배열을 arr에 저장
				show(arr);					// show함수로 전체 출력
				break;
			case 2:
				System.out.print("책 제목\t>> ");
				title = sc.nextLine();					 // 입력 받은 값 저장
				
				System.out.print("저자\t>> ");
				writer = sc.nextLine();					 // 입력 받은 값 저장
				
				System.out.print("출판일자\t>> ");
				publishDate = sc.nextLine();			 // 입력 받은 값 저장
				
				System.out.print("평점\t>> ");
				rating = Integer.parseInt(sc.nextLine());// 입력 받은 값 저장
				
				System.out.print("가격\t>> ");
				price = Integer.parseInt(sc.nextLine()); // 입력 받은 값 저장
				
				// 입력받은 값으로 Book 객체 생성
				tmp = new Book(title, writer, publishDate, rating, price);
			
				// 생성한 Book 객체를 handler에 추가
				row = handler.add(tmp); 
				
				System.out.println(row != 0 ? "추가 성공" : "추가 실패");
				System.out.println();
				
				break;
			case 3:
				System.out.println("	1. 제목으로 검색 ");
				System.out.println("	2. 저자로 검색 ");
				System.out.print(">>> ");
				searchType = Integer.parseInt(sc.nextLine());	// 입력 받은 값 저장
				if(searchType==1) {		// 제목으로 검색
					System.out.print("검색할 책 제목 입력 >>> ");
					keyword = sc.nextLine(); 					// 입력 받은 값 저장
					arr = handler.search(searchType, keyword);  // 입력할 타입, 키워드로 검색한 결과를 배열에 저장
					show(arr);	// 저장된 배열 출력
				}
				else if(searchType==2) {// 저자로 검색
					System.out.print("검색할 저자 이름 입력 >>> ");
					keyword = sc.nextLine();					// 입력 받은 값 저장
					arr = handler.search(searchType, keyword); 	// 입력할 타입, 키워드로 검색한 결과를 배열에 저장
					show(arr);	// 저장된 배열 출력
				}
				else {	// 1, 2 이외의 값 입력시
					System.err.println("잘못된 번호입니다.");
				}
				
				break;
			case 4:
				System.out.print("삭제할 책 제목 >> ");
				keyword = sc.nextLine(); 		// 입력 받은 값 저장
				
				row = handler.delete(keyword);	// 입력한 책이 삭제되었다면 1 아니라면 0을 반환
				
				System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
				System.out.println();
				
				break;
			case 5:
				handler.clear();		// 전체 초기화
				break;
			}
			System.out.println();
		}while(menu != 0);	// menu가 0이 아닐동안 반복
		
		sc.close();	// 스캐너 사용이 끝난다면 닫아주기
		System.out.println("프로그램 종료");
		
	}


}
