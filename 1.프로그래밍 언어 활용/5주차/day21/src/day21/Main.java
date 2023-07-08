package day21;


import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Handler handler = new Handler();
		// handler객체에 txt 로드
		handler.load();	
		// 로드된 txt파일 내용 list에 저장
		List<PhoneBookInfo> list = handler.select();
		
		Scanner sc = new Scanner(System.in);
		int menu;
		int row;
		String name;
		int age;
		String pnum;
		
		
		while(true) {
			// 메뉴
			System.out.println("1. 전체 목록 출력");
			System.out.println("2. 데이터 추가");
			System.out.println("3. 검색");
			System.out.println("4. 삭제");
			System.out.println("5. 저장");
			System.out.println("0. 종료");
			System.out.print("선택 >>> ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			
			case 1:		
				System.out.println("\n\n\t\t[전체 목록 출력]\n\n");
				// 전체 리스트 출력
				list.forEach(ob -> System.out.println(ob));
				System.out.println("\n\n");
				break;

			case 2:
				// 추가할 정보 입력
				System.out.print("이름 입력 >> ");
				name = sc.nextLine();
				
				System.out.print("나이 입력 >> ");
				age = Integer.parseInt(sc.nextLine());
				
				System.out.print("전화번호 입력 >> ");
				pnum = sc.nextLine();
				
				// 추가되었으면 true
				row = handler.insert(name, age, pnum);
				System.out.println(row!=0 ? "추가 완료\n" :"이미 저장된 번호입니다\n");
				break;
				
			case 3:
				
				System.out.println("1. 이름으로 검색");
				System.out.println("2. 전화번호로 검색");
				System.out.print(">>> ");
				menu = Integer.parseInt(sc.nextLine());
				
				if(menu == 1) {
					System.out.print("이름 입력 >> ");
					name = sc.nextLine();
					
					// 검색결과를 s에 저장
					String s = handler.search(name);
					
					// 검색된 결과 출력
					System.out.println("\n\n\t\t검색된 내용");
					System.out.println(s);
				}
				else if(menu == 2) {
					
					System.out.print("전화번호 입력 >> ");
					pnum = sc.nextLine();
					
					// 검색결과를 s에 저장
					String s = handler.search(pnum);
					
					// 검색된 결과 출력
					System.out.println("\n\n\t\t검색된 내용\n\n");
					System.out.println(s);
				}
				break;
				
			case 4:		
				System.out.print("전화번호 입력 ex)010-1111-1111 >> ");
				pnum = sc.nextLine();
				
				// 삭제
				row = handler.delete(pnum);
				System.out.println(row!=0 ? "삭제 성공\n" :"삭제 실패\n");
				break;
				
			case 5:		
				// 저장
				handler.save();
				System.out.println("저장완료!\n");
				break;
			
			case 6:
				// 수정
				System.out.print("수정할 전화번호 입력 >> ");
				pnum = sc.nextLine();
				
				String s = handler.selectOne(pnum);
				if(s.equals("")) {
					System.out.println("검색된 정보가 없습니다.\n");
					break;
				}
				System.out.println("현재 정보 ");
				System.out.println(s);
				
				System.out.print("변경할 이름 입력 >> ");
				name = sc.nextLine();
				
				System.out.print("변경할 나이 입력 >> ");
				age = Integer.parseInt(sc.nextLine());
				
				System.out.print("변경할 전화번호 >> ");
				String newPnum = sc.nextLine();
				
				handler.modify(pnum, name, age, newPnum);
				break;
				
			case 0:		
				
				sc.close();
				System.out.println("프로그램이 종료되었습니다.");
				return;
				
			default:
				System.err.println("잘못된 번호를 입력하셨습니다.\n");
				break;
			}
		}
		
	}
}
