import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class Main {
	static int[][] graph;
	static boolean[] visited;
	static int N;
	static int M;
	static int V;
	
	static void dfs(int startIndex) {
		visited[startIndex] = true;
		System.out.print(startIndex + " ");
		for(int i = 1; i <= N; i++) {
			if(graph[startIndex][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int startIndex) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startIndex);
		visited[startIndex] = true;
		while(!queue.isEmpty()) {
			int index = queue.poll();
			System.out.print(index + " ");
			for(int i = 1; i <= N; i++) {
				if(graph[index][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		V = Integer.parseInt(split[2]);
		
		graph = new int[N+1][N+1];
		visited = new boolean[N + 1];
		
		for(int i = 0; i < M; i++) {
			String[] splitLine = in.readLine().split(" ");
			int a = Integer.parseInt(splitLine[0]);
			int b = Integer.parseInt(splitLine[1]);
			graph[a][b] = 1;
			graph[b][a] = 1;
			
		}
		
		dfs(V);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(V);
	}
}
