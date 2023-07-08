package thread;

import java.util.Scanner;

class Timer2 implements Runnable {
	
	private boolean over = false;
	
	@Override
	public void run() {
		try { Thread.sleep(500); } catch (Exception e) {}
		for(int i = 5; i != -1; i--) {
			if(over) {
				break;
			}
			System.out.printf("\n%02d : %02d\t", i/60, i%60);
			try { Thread.sleep(1000); } catch (Exception e) {}
		}
		over = true;
	}

	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}
	
}

class Question implements Runnable {
	
	private Scanner sc = new Scanner(System.in);
	private int answer = 4;
	private int input = -1;
	private Timer2 timer;
	private Thread th;
	
	public Question(Timer2 timer, Thread th) {
		this.timer = timer;
		this.th = th;
	}
	
	@Override
	public void run() {
		System.out.println("문제) 다음 중 출연 작품이 서로 다른 하나는?");
		System.out.println("1. 짱구");
		System.out.println("2. 유리");
		System.out.println("3. 철수");
		System.out.println("4. 코난");
		System.out.println("5. 훈이");
		System.out.print("입력 >>> ");
		input = sc.nextInt();
		boolean flag = !timer.isOver()&&input==answer;
		System.out.println(flag ? "정답" : "오답");
		timer.setOver(true);
	}
}

public class Ex04 {
	public static void main(String[] args) {
		
		// 타이머가 시작된 후 문제를 낸다
		// 문제는 객관식으로 1번에서 5번까지의 선택지가 있다
		// 답을 입력하면 정답/오답을 판별하여 출력해야 한다
		// 정답/오답 여부에 상관없이 타이머가 종료되었다면 오답으로 판정한다
		// 이미 입력이 끝났다면 더 이상 타이머를 진행하지 않아야 한다
		
		Timer2 timer = new Timer2();
		Thread th1 = new Thread(timer);
		Question q = new Question(timer, th1);
		Thread th2 = new Thread(q);
		
		th2.start();
		th1.start();
	}
}
