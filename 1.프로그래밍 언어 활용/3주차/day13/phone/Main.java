package phone;

public class Main {
	public static void main(String[] args) {
		Phone ph1 = new Phone("짱구폰", "짱구");
		Phone ph2 = new Phone("철수폰", "철수");
		ph1.send(ph2, "ㅎㅇ");
		ph2.send(ph1, "♥");
		
	}
}
