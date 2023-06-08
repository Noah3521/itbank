package day17;

class Car {
	private Tire tire1;

	public Tire getTire1() {
		return tire1;
	}

	public void setTire1(Tire tire1) {
		this.tire1 = tire1;
	}
	public void run() {
		System.out.println(tire1 == null ? "작동불가" : "작동가능");
	}
	@Override
	public String toString() {
		return "자동차에 장착된 타이어 : " + tire1;
	}
}

abstract class Tire {					// 슈퍼클래스가 추상클래스이고
	public abstract String toString();	// 어떤 추상메서드를 포함한다면
}

class SnowTire extends Tire {			// 상속에서 그 서브클래스는
	@Override							// 추상클래스의 추상메서드를 반드시 구현해야 한다
	public String toString() {
		return "스노우 타이어";
	}
}

class OffroadTire extends Tire {
	@Override
	public String toString() {
		return "오프로드 타이어";
	}
}

class NormalTire extends Tire {
	@Override
	public String toString() {
		return "일반 타이어";
	}
}



public class Ex01 {
	public static void main(String[] args) {
		Car car = new Car();
		car.run();

		SnowTire snowTire = new SnowTire();
		OffroadTire offRoadTire = new OffroadTire();
		NormalTire normalTire = new NormalTire();
		
		car.setTire1(normalTire);	// 자동차에 일반 타이어를 장착한다
		System.out.println(car);	// 자동차 상태 확인
		car.run();					// 자동차 테스트

		car.setTire1(offRoadTire);	// 자동차에 오프로드 타이어를 장착한다
		System.out.println(car);	// 자동차 상태 확인
		car.run();
	
		car.setTire1(snowTire);		// 자동차에 타이어를 해제 한다
		System.out.println(car);	// 자동차 상태 확인
		car.run();					// 자동차 테스트
		
		car.setTire1(null);			// 의존성
		System.out.println(car);
		car.run();
	
	}
}
