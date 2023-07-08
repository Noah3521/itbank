package tv;

// 필드와 메서드
// 필요하다면 생성자를 활용하여
// TV객체의 구성을 클래스로 나타냅니다

// 속성(명사형)은 필드
// 기능(동사형)은 메서드로 나타냅니다

public class TV {
	
	int MAXCHNNAL = 200;
	
	// 필드
	boolean power;	// 초기값 false
	boolean mute;
	int channel = 1;	// 초기값 0 (채널범위 1~200)
	int volume=50; 	// 초기값 50 (범위 0~100)
	int volSave;	
	String model = "TV";
	
	TV() {}
	
	TV(String model) {
		this.model = model;
	}
	
	// 전원이 꺼져있다면 true
	boolean check() {
		if(power)
			return !power;
		
		System.out.println("전원이 꺼져있습니다.");		
		return true;
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
		if(channel>MAXCHNNAL) {
			channel%=MAXCHNNAL;
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
		if(channel<1) {
			channel+=MAXCHNNAL;
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
	
	// 리모컨에서 숫자로 입력한 채널을 처리하는 함수
	public void setChannel(int channel) {
		if(channel < 0 || 200 < channel || check())
			return;
		this.channel = channel;
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
