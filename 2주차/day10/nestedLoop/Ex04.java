package nestedLoop;

public class Ex04 {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("[%di, %dj] ", i, j);
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
//				boolean flag = !(i + j < 2 || i + j > 6 || j < i - 2 || j > i + 2);
				boolean flag = i ==2 || j == 2 || (i%2!=0 && j%2!=0);
				System.out.print(flag ? "* " : "  ");
			}
			System.out.println();
		}
		System.out.println();
		
		int space = 2;
		int star = 1;
		int sp = -1;
		int st = 2;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < space; j++) {
				System.out.print("  ");
			}
			for (int j = 0; j < star; j++) {
				System.out.print("* ");
			}
			System.out.println();
			
			if (star > 4) {
				sp = 1;
				st = -2;
			}
			
			space += sp;
			star += st;
		}
		System.out.println();
	}
}
