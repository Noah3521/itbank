package nestedLoop;

public class Ex05 {
	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			int num = i + 1;
			for (int j = 0; j < 5; j++) {
				System.out.printf("%2d ", num);
				num += 5;
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int num = j * 5 + i + 1;
				System.out.printf("%2d ", num);
			}
			System.out.println();
		}
	}
}
