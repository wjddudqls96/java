import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, min;
	static int[] arr;
	static int[][] matrix;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		matrix = new int[N][N];
		
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i, i, 0, 0);
		}
		
		System.out.println(min);
	}
	
	static void dfs(int originIndex, int startIndex, int weight, int count) {
		
		if(count == N-1) {
			if(matrix[startIndex][originIndex] != 0) {
				int result = weight + matrix[startIndex][originIndex];
				if(min > result) {
					min = result;
				}
			}
			return;
		}
		
		visited[startIndex] = true;
		
		for(int i = 0; i < N; i++) {
			int nextW = matrix[startIndex][i];
			if(nextW == 0) continue;
			
			if(visited[i]) continue;
			
			visited[i] = true;
			dfs(originIndex, i, weight + nextW, count + 1);
			visited[i] = false;
		}
	}
}