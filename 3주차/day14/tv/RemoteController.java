package tv;

public class RemoteController {
	
	TV tv;	// TV 객체를 참조할 수 있는 참조변수
	
	RemoteController() {
		System.out.println("TV 연결안됨");
	}
	
	RemoteController(TV tv) {
		this.tv = tv;
		System.out.println("TV 연결됨");
	}
	
	void setTV(TV tv) {
		this.tv = tv;
	}
	
	boolean conn() {
		if(tv==null) {
			System.out.println("TV 연결x");
		}
		return tv==null;
	}
	
	void volUp() {
		if(conn()) return;
		tv.volUp();
	}
	void volDown() {
		if(conn()) return;
		tv.volDown();
	}
	void chUp() {
		if(conn()) return;
		tv.chUp();
	}
	void chDown() {
		if(conn()) return;
		tv.chDown();
	}
	void setCh(int channel) {
		tv.setChannel(channel);
	}
	void mute() {
		if(conn()) return;
		tv.mute();
	}
	void turn() {
		if(conn()) return;
		tv.turn();
	}
	
}
