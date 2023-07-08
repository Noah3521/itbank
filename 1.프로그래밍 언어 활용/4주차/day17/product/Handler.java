package product;

import java.util.Arrays;
import java.util.Comparator;

public class Handler {


	Product[] arr = new Product[10];

	Object[] compArray = new Object[4];
	
	// 기본 생성자
	public Handler() {
		Comparator<Product> comp1 = (a, b) -> a != null && b != null ? a.name.compareTo(b.name) : 0;
		Comparator<Product> comp2 = (a, b) -> a != null && b != null ? b.name.compareTo(a.name) : 0;
		Comparator<Product> comp3 = (a, b) -> a != null && b != null ? a.price - b.price : 0;
		Comparator<Product> comp4 = (a, b) -> a != null && b != null ? b.price - a.price : 0;
		compArray[0] = comp1;
		compArray[1] = comp2;
		compArray[2] = comp3;
		compArray[3] = comp4;
	}

	// 1. 전체 목록
	public Product[] getArray() {
		return arr;
	}

	// 2. 추가
	public int insert(Product pro) {
		int row = 0; // 추가 실패 = 0
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				arr[i] = pro;
				row += 1;// 추가 성공 = 1
				break;
			}
		}
		return row;
	}

	// 3. 검색
	public Product[] search(String name) {
		int count = 0; // 배열 중 검색된 데이터의 개수
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null && arr[i].name.contains(name)) {
				count += 1;
			}
		}

		Product[] tmp = new Product[count]; // 검색된 배열을 저장할 배열
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			Product p = arr[i];
			// 상품(p)의(.) 이름(this.name)이 검색어(name)를 포함(contains)하면
			if (p != null && p.name.contains(name)) {
				tmp[index++] = arr[i];
			}
		}
		return tmp;
	}

	public int delete(String name) {
		int row = 0; // 성공 = 1, 실패 = 0
		for (int i = 0; i < arr.length; i++) {
			Product p = arr[i];
			// 상품(p)의(.) 이름(this.name)이 검색어(name)를 포함(contains)하면
			if (p != null && p.name.contains(name)) {
				arr[i] = null;
				row += 1;
			}
		}
		return row;
	}

	// 정렬
	@SuppressWarnings("unchecked")
	public Product[] sort(int option) { // 1:이름순, 2:가격순
		
		if(0 <= option && option < compArray.length) {
			Arrays.sort(arr, (Comparator<Product>)compArray[option]);
			Arrays.toString(arr);
		}
			
		return arr;
	}

}
