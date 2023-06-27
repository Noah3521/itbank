package socket;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Test implements Runnable {
	ServerSocket ss;
	
	public Test(ServerSocket ss) {
		this.ss = ss;
	}
	
	@Override
	public void run()  {
		try {
		Socket so = ss.accept();
		while(true) {
			
			String remoteAddr = so.getInetAddress().toString();
			Scanner sc = new Scanner(so.getInputStream());
			String data = sc.nextLine();
			PrintWriter pw = new PrintWriter(so.getOutputStream());
			pw.write(data);
			pw.flush();
			pw.close();
			System.out.println(remoteAddr + " : " + data);
			sc.close();
			if(data.equals("exit")) {
				break;
			}
		}
		so.close();
		} catch (Exception e) {
		}
	}
}

public class Server {
	static String getLocalIpaddr() throws Exception {
		Runtime rt = Runtime.getRuntime();
		Process pro = rt.exec("ipconfig");
		InputStream is = pro.getInputStream();
		Scanner sc = new Scanner(is, "CP949");
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.contains("IPv4")) {
				sc.close();
				return line.split(" : ")[1];
			}
		}
		sc.close();
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		String localAddr = getLocalIpaddr();
		System.out.println(localAddr);
		ServerSocket ss = new ServerSocket(7777);
		Test t=new Test(ss);
		System.out.println("접속 대기중...");
		System.out.println(ss.getInetAddress() + " : " + "에서 접속함");
		try {
			while(true) {
				Socket o = ss.accept();
				new Thread(t).start();
			}
		} catch (Exception e) {
		}
		ss.close();
		
	}
}
