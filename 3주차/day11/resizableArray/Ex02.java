package resizableArray;

import java.util.ArrayList;

class MyList {
	private int[] arr = new int[0];
	private int[] tmp;
	private int length = 0;

	public int size() {
		return length;
	}

	public boolean add(int element) {
		boolean flag = true;
		int i = 0;
		length += 1;
		tmp = new int[length];
		for (i = 0; i < arr.length; i++) {
			tmp[i] = arr[i];
		}
		tmp[i] = element;
		arr = tmp;
		return flag;
	}

	public boolean remove(int index) {
		boolean flag = false;	// 지정한 index의 값을 찾아서 제거하면 true로 바꿔야 한다
		if(index < 0 || length <= index) {	// 범위를 벗어나면
			System.out.println("false");	// 함수를 종료한다
			return flag;
		}
		length -= 1;
		int cnt = 0;
		tmp = new int[length];
		for (int i = 0; i < arr.length; i++) {
			if (i == index) {
				flag = true;
				continue;
			}
			tmp[cnt++] = arr[i];
		}
		arr = tmp;
		return flag;
	}

	public String toString() {
		String s = "[";
		for (int i = 0; i < arr.length; i++) {
			s += arr[i];
			s += i != arr.length - 1 ? ", " : "]";
		}
		return s;
	}
}

public class Ex02 {
	public static void main(String[] args) {
		MyList list = new MyList();

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(20);
		System.out.println("list.size() : " + list.size());
		System.out.println("list : " + list);
		
		list.remove(1);
		System.out.println("list.size() : " + list.size());
		System.out.println("list : " + list);
		System.out.println();
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();

		list2.add(10);
		list2.add(20);
		list2.add(30);
		list2.add(20);
		System.out.println("list2.size() : " + list2.size());
		System.out.println("list2 : " + list2);
		
		list2.remove(1);
		System.out.println("list2.size() : " + list2.size());
		System.out.println("list2 : " + list2);
		System.out.println();
	}
}
