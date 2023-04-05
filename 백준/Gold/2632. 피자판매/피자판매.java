import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int size, M, N;
	static int[] aPiece, bPiece;
	static int[] dpA, dpB;
	
	public static void main(String[] args) throws Exception {
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = null;
		 
		 size = Integer.parseInt(in.readLine());
		 st = new StringTokenizer(in.readLine());
		 
		 M = Integer.parseInt(st.nextToken());
		 N = Integer.parseInt(st.nextToken());
		 
		 aPiece = new int[M];
		 bPiece = new int[N];
		 
		 int sumA = 0;
		 int sumB = 0;
		 
		 for(int i = 0; i < M; i++) {
			 aPiece[i] = Integer.parseInt(in.readLine());
			 sumA += aPiece[i];
		 }
		 
		 for(int i = 0; i < N; i++) {
			 bPiece[i] = Integer.parseInt(in.readLine());
			 sumB += bPiece[i];
		 }
		 
		 dpA = new int[size + 1];
		 dpB = new int[size + 1];
		 
		 dpA[0] = 0;
		 dpB[0] = 0;
		 
		 makePiece(dpA, aPiece);
		 makePiece(dpB, bPiece);
		 
		 
		 if(sumA <= size) {
			 dpA[sumA]++;
		 }
		 if(sumB <= size) {
			 dpB[sumB]++;
		 }
		 
		 int result = 0;
		 for(int i = 1; i <= size; i++) {
			 result += dpA[i] * dpB[size - i];
		 }
		 
		 
		 result += dpA[size] + dpB[size];
		 System.out.println(result);
	}
	
	static void makePiece(int[] dp, int[] piece) {
		for(int i = 0; i < piece.length; i++) {
			int sum = 0;
			// 범위를 piece.length 할경우 전체 선택 중복이 일어난다.
			for(int j = 0; j < piece.length - 1; j++) {
				if(piece[(i + j) % piece.length] + sum > size) break;
				sum += piece[(i + j) % piece.length];
				dp[sum]++;
			}
		}
	}
}




