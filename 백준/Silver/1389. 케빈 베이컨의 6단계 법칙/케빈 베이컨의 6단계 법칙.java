import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[] count;
	static ArrayList<ArrayList<Integer>> map;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		
		map = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <= N; i ++) {
			map.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			String[] line = in.readLine().split(" ");
			int friend1 = Integer.parseInt(line[0]);
			int friend2 = Integer.parseInt(line[1]);
			map.get(friend1).add(friend2);
			map.get(friend2).add(friend1);
		}
		
		int minIndex = -1;
		
		for(int i = 1; i <= N; i++) {
			count = new int[N+1];
			visited = new boolean[N+1];
			int cnt = bfs(i);
			if(min > cnt) {
				min = cnt;
				minIndex = i;
			}
		}
		
		
		System.out.println(minIndex);
	}
	
	static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		int cnt = 0;
		
		queue.add(start);
		visited[start] = true;
		count[start] = 0;
		
		while(!queue.isEmpty()) {
			int index = queue.poll();
			
			for(int nextIndex : map.get(index)) {
				if(!visited[nextIndex]) {
					queue.add(nextIndex);
					visited[nextIndex] = true;
					count[nextIndex] = count[index] + 1;
					cnt += count[nextIndex];
				}
			}
		}
		return cnt;
	}
}
