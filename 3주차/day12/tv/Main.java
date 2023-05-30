package tv;

public class Main {
	static void d() {
		for (int i = 0; i < 88; i++) {
			System.out.println();
		}
	}

	public static void main(String[] args) {
		TV tv = new TV("LG");
		tv.turn();
		
		for(int i = 0 ; i < 1500; i++)
			tv.chUp();
		System.out.println(tv);

		for(int i = 0 ; i < 105; i++)
			tv.volUp();
		System.out.println(tv);
		
		tv.mute();
		System.out.println(tv);
		
		tv.volDown();
		System.out.println(tv);
		
		tv.turn();
		System.out.println(tv);
		
		tv.volUp();
	}
}
