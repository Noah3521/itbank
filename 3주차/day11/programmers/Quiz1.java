package programmers;

import java.util.Arrays;

class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		int[] tmp = new int[moves.length];
		for (int i = 0; i < moves.length; i++) {
			int slot = moves[i] - 1;
			int item = 0;
			for (int j = 0; j < board.length; j++) {
				item = board[j][slot];
				if (item != 0) {
					String s = Arrays.toString(tmp).replaceAll(",", "").replace("[", "").replace("]", "");
					board[j][slot] = 0;
					System.out.printf("get : %d\t",item);
					System.out.println("\t"+s);
					break;
				}
			}
			
			for(int j = 0; j < tmp.length; j++) {
				if(tmp[j]==0) {
					tmp[j] = item;
					break;
				}
			}
			
			for(int j = 0; j < tmp.length;j++) {
				if(tmp[j] != 0 && tmp[j] == tmp[j+1]) {
					tmp[j] = 0;
					tmp[j+1] = 0;
					answer+=2;
				}
			}
		}
//		System.out.println();
		
//		for (int i = 0; i < tmp.length; i++) {
////			System.out.println(i);
//			if(tmp[i]==0) {
////				System.out.println("i==0");
//				continue;
//			}
//			for(int j = i+1; j < tmp.length; j++) {    
//				if(tmp[i]==tmp[j]) {
////					System.out.println("=="+Arrays.toString(tmp));
//					answer+=2;
//					tmp[i]=0; tmp[j]=0;
//					i = 0;
//					break;
//				}
//				else if(tmp[j]==0){
////					System.out.println("j==0");
//					continue;
//				}
//				else {
////					System.out.println(Arrays.toString(tmp));
//					break;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(tmp));

		return answer;
	}
}

public class Quiz1 {
	static void show(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				String s = "";
				switch (board[i][j]) {
				case 0:
					s = "     ";
					break;
				case 1:
					s = "😛";
					break;
				case 2:
					s = "😍";
					break;
				case 3:
					s = "😎";
					break;
				case 4:
					s = "😪";
					break;
				case 5:
					s = "😃";
					break;
				}
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 }, };
		int[] moves = { 1,5,3,5,1,2,1,4 };

		show(board);

		int answer = s.solution(board, moves);
		System.out.println("answer : "+ answer);

	}
}
