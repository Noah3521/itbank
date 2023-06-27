package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Scanner sc = new Scanner(System.in);
		String target = "192.168.112.24";
		String data;
		
		System.out.println("접속할 서버의 IP를 입력 : ");
//		target = sc.nextLine();
		
		
		
		Socket so = new Socket(target, 7777);
		while(true) {
			PrintWriter pw = new PrintWriter(so.getOutputStream());
			System.out.print("보낼 메시지 입력 >>> ");
			data = sc.nextLine();
			pw.write(data);
			pw.flush();
			pw.close();
			Scanner sc1 = new Scanner(so.getInputStream());
			String data1 = sc1.nextLine();
			System.out.println(so.getInetAddress() + " : " + data1);
			sc1.close();
			if(data.equals("exit")) {
				break;
			}
		}
		so.close();
		sc.close();
		
	}
}
