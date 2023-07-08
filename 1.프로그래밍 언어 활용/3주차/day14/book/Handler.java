package book;

public class Handler {
	private int size = 10;
	private Book[] arr = new Book[size];

	// 책 추가
	public int add(Book book) {
		int row = 0;	// 기능 수행 여부
		for (int i = 0; i < size; i++) {// size 번 반복
			if (arr[i] == null) {		// 해당 Book 객체가 비어있을 때
				arr[i] = book;			// 해당 index에 매개변수로 받은 Book 객체 저장
				row = 1;				// 기능을 수행하였으므로 1로 변경
				break;					// 반복 종료
			}
		}
		return row;
	}

	// 전체 배열 반환
	public Book[] getArray() {
		return arr;	
	}

	// 책 삭제
	public int delete(String title) {
		int row = 0;	// 기능 수행 여부
		for (int i = 0; i < arr.length; i++) {	
			// 해당 Book 객체가 null이 아니고, 해당 Book객체의 title이 매개변수로 받은 title과 일치할 때
			if (arr[i] != null && arr[i].getTitle().equals(title)) {
				row = 1;		// 기능을 수행하였으므로 1로 변경
				arr[i] = null;	// 해당 index에 저장된 Book 객체를 삭제
				break;			// 반복 종료
			}
		}
		return row;
	}

	// 검색
	public Book[] search(int searchType, String keyword) {
		// searchType)
		// 	1. 제목으로 검색
		// 	2. 저자로 검색
		
		int count = 0;	// 검색어가 포함된 데이터의 개수를 저장하기 위한 변수
		
		for(int i = 0 ; i < size; i++) {
			// 해당 Book객체가 null이 아니면서, 검색 타입이 1이면서, 해당 Book객체의 title에 keyword가 포함되어있다면
			if(arr[i] != null && searchType==1 && arr[i].getTitle().contains(keyword)) {
				count++;	// 개수를 하나 증가
			}
			// 해당 Book객체가 null이 아니면서, 검색 타입이 1이면서, 해당 Book객체의 title에 keyword가 포함되어있다면
			else if(arr[i] != null && searchType==2 && arr[i].getWriter().contains(keyword)) {
				count++;	// 개수를  하나 증가
			}
		}
		
		// 검색된 데이터를 담을 result 배열, 크기는 검색어가 포함된 개수만큼만 
		Book[] result = new Book[count]; 
		int index = 0; // result변수에 검색된 Book객체를 하나씩 담기 위한 변수
		for(int i = 0 ; i < size; i++) {
			// 해당 Book객체가 null이 아니면서, 검색 타입이 1이면서, 해당 Book객체의 title에 keyword가 포함되어있다면
			if(arr[i] != null && searchType==1 && arr[i].getTitle().contains(keyword))
				result[index++] = arr[i];	// result의 index번째에 검색된 Book객체를 저장 후 index +=1
			// 해당 Book객체가 null이 아니면서, 검색 타입이 1이면서, 해당 Book객체의 title에 keyword가 포함되어있다면
			else if(arr[i] != null && searchType==2 && arr[i].getWriter().contains(keyword))
				result[index++] = arr[i];	// result의 index번째에 검색된 Book객체를 저장 후 index += 1 
			
		}
		
		// 검색된 데이터를 담은 result 반환
		return result;
	}

	// 전체 초기화
	public void clear() {
		// 새로운 객체를 바라보게 함으로써 사용하던 객체는 소멸 
		arr = new Book[size];
	}

}
