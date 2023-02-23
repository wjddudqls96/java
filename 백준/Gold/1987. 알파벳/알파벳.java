import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N, M, MAX;
	static int[][] map;
	static int[] visited;
	static int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[26];
		MAX = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			String line = in.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - 65;
			}
		}
		
		dfs(0, 0, 0);
		System.out.println(MAX);
	}
	
	static void dfs(int startX, int startY, int count) {
		
		
		if(visited[map[startY][startX]] == 1) {
			if(MAX < count) {
				MAX = count;
			}
		}
		else {
			visited[map[startY][startX]] = 1;
			
			for(int i = 0; i < 4; i++) {
				int nextX = startX + directions[i][0];
				int nextY = startY + + directions[i][1];
				
				if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
	        		dfs(nextX, nextY, count + 1);
	        	}
			}
			visited[map[startY][startX]] = 0;
		}
	}
}