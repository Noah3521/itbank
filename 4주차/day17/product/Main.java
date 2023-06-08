package product;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		Handler handler = new Handler();
		Handler handler = test();
		Product tmp = null;
		Product arr[] = null;
		int row = 0;
		int menu;
		String name;
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("1. 전체 목록");
			System.out.println("2. 추가");
			System.out.println("3. 검색");
			System.out.println("4. 삭제");
			System.out.println("5. 정렬");
			System.out.println("0. 종료");
			System.out.print("선택>>> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			
			case 1:		// 1. 전체 메뉴
				arr = handler.getArray();
				showArr(arr);	
				break;
				
			case 2:		// 2. 상품 추가
				System.out.println("상품 유형을 선택하세요");
				System.out.println("1. 식품 | 2. 공산품");
				System.out.print(">>>");
				menu = Integer.parseInt(sc.nextLine());
				if	   (menu == 1)		tmp = makeFood(sc);
				else if(menu == 2)		tmp = makeIndustProduct(sc);
				else 					tmp = null;	// null이면 무조건 추가 실패
				row = handler.insert(tmp);
				System.out.println(row != 0 ? "추가성공" : "추가실패");
				break;
				
			case 3:		// 3. 검색
				System.out.print("검색할 이름 >> ");
				name = sc.nextLine();
				arr = handler.search(name);
				showArr(arr);
				break;
				
			case 4:		// 4. 삭제
				System.out.print("삭제할 이름 >> ");
				name = sc.nextLine();
				row = handler.delete(name);
				System.out.println(row != 0 ? row+"개 삭제성공" : "삭제실패");
				break;
				
			case 5:		// 5. 정렬
				System.out.println("정렬 기준을 선택하세요");
				System.out.println("1. 이름순 ↑| 3. 가격순↑");
				System.out.println("2. 이름순 ↓| 4. 가격순↓");
				System.out.print(">>> ");
				menu = Integer.parseInt(sc.nextLine());
				arr = handler.sort(menu-1);
				showArr(arr);
				break;
				
			case 0:		// 0. 종료
				sc.close();
				System.out.println("프로그램 종료");
				return;
				
			default:
				System.err.println("잘못된 번호입니다.");
				break;
			}
			System.out.println();
		}
	}

	static void showArr(Product[] arr) {
		for(Product pro : arr) {
			if(pro!=null) System.out.println(pro);
		}
	}

	static Product makeFood(Scanner sc) {
		System.out.print("이름 입력 \t>> ");
		String name = sc.nextLine();
		System.out.print("가격 입력 \t>> ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.print("유통기한 입력 \t>> ");
		String expireDate = sc.nextLine();
		
		Food tmp = new Food(name, price, expireDate); 
		
		return tmp;
	}

	static Product makeIndustProduct(Scanner sc) {
		System.out.print("이름 입력 \t>> ");
		String name = sc.nextLine();
		System.out.print("가격 입력 \t>> ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.print("생산지 입력\t>> ");
		String madeIn = sc.nextLine();
		
		IndustrialProduct tmp = new IndustrialProduct(name, price, madeIn); 
		
		return tmp;
	}
	
	static Handler test() {
		Handler h = new Handler();
		
		h.insert(new Food("사과", 1000, "2023-10-01"));
		h.insert(new Food("감자", 2000, "2023-09-12"));
		h.insert(new Food("포도", 3999, "2024-12-29"));
		h.insert(new Food("고등어", 20000, "2022-01-05"));
		h.insert(new IndustrialProduct("컴퓨터", 2000000, "중국"));
		h.insert(new IndustrialProduct("아이폰", 20000000, "미국"));
		h.insert(new IndustrialProduct("키보드", 2000000, "대만"));
		
		return h;
	}
}
