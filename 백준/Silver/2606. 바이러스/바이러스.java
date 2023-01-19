import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static ArrayList<ArrayList<Integer>> map;
	static boolean[] visited;
	static int N;
	static int M;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		
		map = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[N+1];
		
		for(int i = 0; i <= N; i++) {
			map.add(new ArrayList<Integer>());
		}
		
		// 인접 리스트 만들기
		for(int i = 0; i < M; i++) {
			String[] split = in.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			
			map.get(a).add(b);
			map.get(b).add(a);
		}
		
		count = 0;
		// bfs
		bfs(1);
		
		System.out.println(count-1);
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int index = queue.poll();
			count++;
			for(int nextIndex : map.get(index)) {
				if(!visited[nextIndex]) {
					queue.add(nextIndex);
					visited[nextIndex] = true;
				}
			}
			
		}
	}
}
