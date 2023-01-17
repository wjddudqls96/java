import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;



public class Main {
	static int[][] graph;
	static boolean[] visited;
	static int N;
	static int startIndex;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(in.readLine());
			int[][] arr = new int[2][N + 1];
			String[] split = in.readLine().split(" ");
			
			// 순열 완성
			for(int i = 1; i <= N; i++) {
				arr[0][i] = i;
				arr[1][i] = Integer.parseInt(split[i-1]);
			}
			
			graph = new int[N+1][N+1];
			visited = new boolean[N+1];
			
			// 인접 행렬 만들기
			for(int j = 1; j <= N; j++) {
				int start = arr[0][j];
				int end = arr[1][j];
				
				graph[start][end] = 1;
			}
			count = 0;
			for(int i = 1; i <= N; i++) {
				dfs(i,i);
			}
			
			System.out.println(count);
		}
		
	}
	
	static void dfs(int startIndex, int start) {
		int[][] test = graph;
		boolean[] test2 = visited;
		
		for(int i = 1; i <= N; i++) {
			if(graph[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				if(startIndex == i) {
					count++;
					break;
				}
				dfs(startIndex, i);
			}
		}
		
	}
}
