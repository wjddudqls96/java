import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Main {
	static char[] whiteChessLine = {'W','B','W','B','W','B','W','B'};
	static char[] blackChessLine = {'B','W','B','W','B','W','B','W'};
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		
		char[][] board = new char[N][M];
		
		// 보드 만들기
		for(int i = 0; i < N; i++) {
			String inputLine = in.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = inputLine.charAt(j);
			}
		}
		
		// 8*8 모든경우의 체스판 분리
		int minValue = Integer.MAX_VALUE;
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				char[][] chess = new char[8][8];
				int yIndex = 0;
				for(int y = i; y < 8 + i; y++) {
					int xIndex = 0;
					for(int x = j; x < 8 + j; x++) {
						chess[yIndex][xIndex++] = board[y][x];
					}
					yIndex++;
				}
				// 하나의 경우의 체스판이 만들어짐 그 이후 로직
				int count = checkChess(chess);
				
				if(minValue > count) {
					minValue = count;
				}
				
			}
		}
		System.out.println(minValue);
	}
	
	static int checkChess(char[][] chess) {
		int count1 = 0;
		int count2 = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(i%2 == 0) {
					if(whiteChessLine[j] != chess[i][j]) {
						count1++;
					}
				}else {
					if(blackChessLine[j] != chess[i][j]) {
						count1++;
					}
				}
			}
		}
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(i%2 == 0) {
					if(blackChessLine[j] != chess[i][j]) {
						count2++;
					}
				}else {
					if(whiteChessLine[j] != chess[i][j]) {
						count2++;
					}
				}
			}
		}
		if(count1 < count2) {
			return count1;
		}
		return count2;
	}
}
