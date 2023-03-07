import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	static int N;
	static double result;
	static double[] percentages;
	static boolean[][] visited;
	static int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		percentages = new double[4];
		visited = new boolean[2*N + 2][2*N + 2];
		for(int i = 0; i < 4; i++) {
			double percent = Double.parseDouble(st.nextToken()) / 100;
			percentages[i] = percent;
		}
		
		// x y 는 N + 1, N + 1, 시작값;
		visited[N + 1][N + 1] = true;
		dfs(N + 1, N + 1, 0, 1.0);
		
		BigDecimal bigDecimal = new BigDecimal(Double.toString(result));
		System.out.println(bigDecimal);
	}
	
	// 0 동 1 서 2 남 3 북
	static void dfs(int x, int y, int count, double percent){
		
		if(count == N) {
			result += percent;
			return;
		}
		
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + directions[i][0];
			int nextY = y + directions[i][1];
			
			if(visited[nextY][nextX]) continue;
			
			visited[nextY][nextX] = true;
			dfs(nextX, nextY, count + 1, percent * percentages[i]);
			visited[nextY][nextX] = false;
		}
	}
}