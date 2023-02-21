import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static boolean flag;
	static int count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String line = in.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			flag = false;
			dfs(0, i);
		}
		
		
//		for(char[] n : map) {
//			System.out.println(Arrays.toString(n));
//		}
		
		System.out.println(count);
		
	}
	
	static void dfs(int startX, int startY) {
		
		if(startX < 0 || startX >= C || startY < 0 || startY >= R) {
			return;
		}
		
		if(flag) return;
		
		if(map[startY][startX] == 'x') return;
		
		if(visited[startY][startX]) return;
		
		if(startX == C - 1) {
//			System.out.println("찾음");
			flag = true;
			map[startY][startX] = '^';
			visited[startY][startX] = true;
			count++;
			return;
		}
		
		map[startY][startX] = '^';
		visited[startY][startX] = true;
		
		dfs(startX + 1, startY - 1); // 오른 위 대각선
		dfs(startX + 1, startY); // 오른쪽
		dfs(startX + 1, startY + 1); // 오른 아래 대각선
	}
}