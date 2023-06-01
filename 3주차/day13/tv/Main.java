package tv;

public class Main {
	public static void main(String[] args) {
		TV tv = new TV("LG");
		TV tv1 = new TV("삼성");
		RemoteController remocon = new RemoteController(tv);
		RemoteController remocon1 = new RemoteController();
		tv.setChannel(150);
		System.out.println(tv);
		
	}
}
