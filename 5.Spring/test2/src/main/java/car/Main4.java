package car;

public class Main4 {
	public static void main(String[] args) {
		
		Tire tire = new Tire("tire");
		Car car1=new Car();
		car1.setTire(tire);
		
		car1.drive();
		System.out.println();
	}
}
