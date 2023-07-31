package test2;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		
//		Socket so = new Socket("192.168.112.7", 8080);
		Socket so = new Socket("localhost", 8080);
		PrintWriter out = new PrintWriter(so.getOutputStream(), true);
		Scanner in = new Scanner(so.getInputStream(), "UTF-8");
		Scanner sc = new Scanner(System.in);
		/*
		 GET /test/index.jsp HTTP/1.1
		Host: localhost:8080
		GET /test/index.jsp HTTP/1.1
		Host: 192.168.112.7:8080
		 */
		String input = null;
		System.out.println("=== request ===\n");
		while("".equals(input) == false ) {
			input = sc.nextLine();
			out.write(input + "\r\n");
		}
		out.flush();
		System.out.println("===============\n");
		System.out.println();
		
		System.out.println("=== response ===\n");
		while(in.hasNextLine()) {
			System.out.println(in.nextLine());
		}
		System.out.println("===============\n");
		System.out.println();
		
		out.close();
		sc.close();
		in.close();
		so.close();
		
		 
	}
}
