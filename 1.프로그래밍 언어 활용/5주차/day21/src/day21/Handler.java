package day21;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Handler {

	private ArrayList<PhoneBookInfo> list = new ArrayList<PhoneBookInfo>();
	private final String fileName = "phoneBook.txt";

	// 저장
	public void save() throws IOException {
		// 파일 객체 생성
		File f = new File(fileName);

		// 파일을 초기화 후 내용을 추가
		FileWriter fw = new FileWriter(f, false);

//		list.forEach(info->{fw.append(info.toString());});
		
		// 리스트의 전체 내용을
		for (PhoneBookInfo info : list) {
			// 버퍼에 저장
			fw.append(info.toString());
		}

		// 파일에 저장
		fw.flush();

		fw.close();
	}

	// 불러오기
	public void load() throws Exception {
		File f = new File(fileName);
		if (!f.exists()) {
			f.createNewFile();
			return;
		}
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String name = line.split(", ")[0];
			int age = Integer.parseInt(line.split(", ")[1]);
			String pnum = line.split(", ")[2];
			list.add(new PhoneBookInfo(name, age, pnum));
		}
		sc.close();
	}

	// 전체 목록
	public List<PhoneBookInfo> select() {
		return list;
	}

	// 추가
	public int insert(String name, int age, String pnum) throws IOException {
		// 매개변수로 받은 값을 저장하는 info객체
		PhoneBookInfo info = new PhoneBookInfo(name, age, pnum);

		// 전체 리스트 중
		for (PhoneBookInfo p : list) {
			// 같은 번호가 있다면
			if (p.getPnum().equals(pnum)) {
				// 추가하지 않고 반환
				return 0;
			}
		}
		// 추가에 성공했다면 true
		return list.add(info) ? 1 : 0;
	}

	// 전화번호 단일 검색
	public String selectOne(String pnum) {
		String find = "";
		
		for (PhoneBookInfo info : list) {
			String s = info.getPnum();
			if (s.equals(pnum)) {
				find += info.toString();
				break;
			};
		}
		
		return find;
	}
	
	// 검색
	public String search(String keyword) {
		// 검색된 값을 담을 변수
		String find = "";

		// 전체 리스트에서
		for (PhoneBookInfo info : list) {
			String s = info.toString();
			// keyword가 포함된 값을
			if (s.contains(keyword)) {
				// 추가한다
				find += s;
			}
			;
		}
		// 검색된 값을 반환
		return find;
	}

	// 삭제
	public int delete(String keyword) {
		// 전화번호가 일치하는 행을 제거 후 성공여부 반환
		return list.removeIf(s -> s.getPnum().equals(keyword))?1:0;
	}

	// 수정
	public int modify(String keyword, String name, int age, String pnum) {
		int row = 0;
		// 전체 리스트 중
		for(PhoneBookInfo info : list) {
			// 전화번호가 같은 객체를 찾는다면
			if(info.getPnum().equals(keyword)) {
				// 인덱스를 저장한 후
				int idx = list.indexOf(info);
				// 삭제
				list.remove(idx);
				// 삭제한 자리에 수정한 객체 저장
				list.add(idx, new PhoneBookInfo(name, age, pnum));
				row = 1;
				break;
			}
		}
		return row;
	}
}
