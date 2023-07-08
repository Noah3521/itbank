package nestedArray;

public class Quiz1 {

	static void show(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%2d ", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int size = 3;
		int num = 1;
		int[][] arr = new int[size][size];
		int[][] answer = new int[size][size];

		// 다음 형태로 출력하세요
		// 1 2 3
		// 8 9 4
		// 7 6 5

		arr[0][0] = 1;	arr[0][1] = 2;	arr[0][2] = 3;
		arr[1][0] = 8;	arr[1][1] = 9;  arr[1][2] = 4;	
        arr[2][0] = 7;  arr[2][1] = 6;  arr[2][2] = 5;	
		show(arr);
		

		num = 1;
		int x = -1, y = 0;
		int sign = 1;
		while (size>0) {
			if (x < 0) {
				for (int i = 0; i < size; i++) {
					answer[y][++x] = num++;
				}
				size--;
			}
			for (int i = 0; i < size; i++) {
				answer[y+=sign][x] = num++;
			}
			for (int i = 0; i < size; i++) {
				answer[y][x-=sign] = num++;
			}
			size--;
			sign*=-1;
		}
		show(answer);
//		
//		while (size>0) {
//			
//
//			System.out.println("size : " + size);
//			if (x < 0) {
//				for (int i = 0; i < size; i++) {
//					answer[y][++x] = num++;
//					show(answer);
//					System.out.println("x : " + x + ", y : " + y);
//				}
//				size--;
//			}
//
//				System.out.println("size : " + size);
//				for (int i = 0; i < size; i++) {
//					answer[y+=sign][x] = num++;
//					show(answer);
//					System.out.println("x : " + x + ", y : " + y);
//				}
//				for (int i = 0; i < size; i++) {
//					answer[y][x-=sign] = num++;
//					show(answer);
//					System.out.println("x : " + x + ", y : " + y);
//				}
//				size--;
//				sign*=-1;
//
//		}
//		show(answer);

	}
}
