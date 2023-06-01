package reference;

class Ball {
	
}

class Kid {
	// 필드
	private Ball ball;
	private String name;
	
	// 생성자
	public Kid(String name) {
		this.name = name;
	}
	
	// 메서드
	public void setBall(Ball ball) {
		this.ball = ball;
	}
	public Ball getBall() {
		return ball;
	}
	public String getName() {
		return name; 
	}
	public void throwBall(Kid other) {
		other.setBall(ball);
		ball = null;
		System.out.printf(":%s가 %s에게 공을 던졌다!\n", name, other.name);
	}
	public boolean hasBall() {
		return ball != null;
	}
}

public class Ex05 {
	public static void main(String[] args) {
		
		Kid ob1 = new Kid("김도기");
		Kid ob2 = new Kid("천지훈");
		Ball ball = new Ball();
		
		ob1.setBall(ball);
		System.out.println(ob1.getName() + "이 공을 가지고 있는가 : " + ob1.hasBall());
		System.out.println(ob2.getName() + "가 공을 가지고 있는가 : " + ob2.hasBall());
		System.out.println();
		
		ob1.throwBall(ob2);
		System.out.println(ob1.getName() + "이 공을 가지고 있는가 : " + ob1.hasBall());
		System.out.println(ob2.getName() + "가 공을 가지고 있는가 : " + ob2.hasBall());
		System.out.println();
		
		ob2.throwBall(ob1);
		System.out.println(ob1.getName() + "이 공을 가지고 있는가 : " + ob1.hasBall());
		System.out.println(ob2.getName() + "가 공을 가지고 있는가 : " + ob2.hasBall());
		System.out.println();
		
	
		
	}
}
