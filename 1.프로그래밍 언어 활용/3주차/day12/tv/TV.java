package tv;

// 필드와 메서드
// 필요하다면 생성자를 활용하여
// TV객체의 구성을 클래스로 나타냅니다

// 속성(명사형)은 필드
// 기능(동사형)은 메서드로 나타냅니다

public class TV {
	
	// 필드
	boolean power;	// 초기값 false
	boolean mute;
	int channel;	// 초기값 0 (채널범위 0~999)
	int volume=50; 	// 초기값 50 (범위 0~100)
	int volSave;	
	String model = "TV";
	
	TV() {}
	
	TV(String model) {
		this.model = model;
	}
	
	void state() {
		System.out.println("\n=======================================\n");
		System.out.println("전원 : " + (power ? "켜짐" : "꺼짐"));
		System.out.println("현재채널 : " + channel);
		if(mute)
			System.out.println("음소거");
		else {
			showVol("볼륨");
		}
		System.out.println("=======================================");
		System.out.println();
	}
	
	// 전원이 꺼져있다면 true
	boolean check() {
		if(power)
			return !power;
		
		System.out.println("전원이 꺼져있습니다.");		
		return true;
	}
	
	// 볼륨 출력
	void showVol(String msg) {
		if(check()) return;
			
		int input = volume;
		int half = input/3;
		
		System.out.printf("\t\t %4s\n", msg);
		System.out.print("[");
		for (int i = 0; i < 33; i++) {	// # 혹은 공백을 출력하는 전체 칸은 50칸
			if (i==33/2) {				// 전체 칸 수의 절반 위치에서 퍼센트 출력
				System.out.printf("%3d%%", input);
			}
			if(i < half) // 입력값(절반)보다 작은 구간은 #
				System.out.print("#");
			else 		 // 입력값(절반)보다 크거나 같은 구간은 공백
				System.out.print(" ");
		}
		System.out.println("]\n");
	}
	
	// 음소거
	void mute() {
		if(check()) return;
		
		mute = !mute;	// 처음 실행은 무조건 true
		if(mute) {	
			volSave = volume;
			volume=0;
		}
		else {
			volume = volSave;
		}
	}
	
	// 볼륨업
	void volUp() {
		volUp(1);
	}
	void volUp(int n) {
		if(check()) return;
		
		if(volume+n>100) {
			volume = 100;
			return;
		}
		if(mute) {
			// 음소거를 해제
			mute();
		}
		volume+=n;
	}
	
	// 볼륨다운
	void volDown() {
		volDown(1);
	}
	void volDown(int n) {
		if(check()) return;
		if(mute) {
			// 음소거를 해제
			mute();
		}
		
		if(volume-n<0) {
			volume = 0;
			return;
		}
		volume-=n;
	}
	
	// 채널업
	void chUp() {
		chUp(1);
	}
	void chUp(int n) {
		if(check()) return;
		
		channel+=n;
		if(channel>999) {
			channel%=1000;
			System.out.println("마지막 채널입니다.");
		}
	}
	
	// 채널다운
	void chDown() {
		chDown(1);
	}
	void chDown(int n) {
		if(check()) return;
		
		channel-=n;
		if(channel<0) {
			channel+=1000;
			System.out.println("마지막 채널입니다.");
		}
	}
	
	// 전원
	void turn() {
		power = !power;
		if(power) {
			System.out.println("powerOn");
		}
		else {
			System.out.println("powerOff");			
		}
	}
	
	@Override
	public String toString() {
		String info = "=======================\n";
		info += "Tv 모델: " + model + "\n";
		info += "Tv의 현재 상태: " + (power ? "켜짐" : "꺼짐")+ "\n";
		info += "채널: " + channel + "\n";
		info += "볼륨: " + (mute ? "음소거" : volume) + "\n";
		info += "=======================";
		return info;
	}
	
	
}
