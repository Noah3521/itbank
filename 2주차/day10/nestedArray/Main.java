package nestedArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int size = Integer.parseInt(br.readLine());
	    int find = Integer.parseInt(br.readLine());
	    StringBuilder print = new StringBuilder();
	    int[][] arr = new int[size][size];

	    int num = size * size;
	    int x = -1, y = 0, sign = 1;
	    String find_ans = "";
	    while (size > 0) {
	        if (x < 0) {
	            for (int i = 0; i < size; i++) {
	            	if(num == find) {
	            		find_ans = String.format("%d %d\n", x+1+1, y+1);
	            	}
	                arr[++x][y] = num--;
	            }
	            size--;
	        }
	        for (int i = 0; i < size; i++) {
	            arr[x][y += sign] = num--;
	            if(num+1 == find) {
	            	find_ans = String.format("%d %d\n", x+1, y+1);
	            }
	        }
	        for (int i = 0; i < size; i++) {
	            arr[x -= sign][y] = num--;
	            if(num+1 == find) {
	            	find_ans = String.format("%d %d\n", x+1, y+1);
	            }
	        }
	        size--;
	        sign *= -1;
	    }
	    br.close();

	    for (int i = 0; i < arr.length; i++) {
	        for (int j = 0; j < arr[i].length; j++) {
	        	 print.append(arr[i][j]).append(" ");
	        }
	        print.append("\n");
	    }
	    System.out.print(print);
	    System.out.println(find_ans);
	}

}
