import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int personA;
	static int personB;
	static int M;
	static ArrayList<ArrayList<Integer>> map;
	static boolean[] visited;
	static int[] count;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		String[] split = in.readLine().split(" ");
		personA = Integer.parseInt(split[0]);
		personB = Integer.parseInt(split[1]);
		
		M = Integer.parseInt(in.readLine());
		map = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= N; i++) {
			map.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			String[] line = in.readLine().split(" ");
			int parent = Integer.parseInt(line[0]);
			int child = Integer.parseInt(line[1]);
			
			map.get(parent).add(child);
			map.get(child).add(parent);
		}
		
		visited = new boolean[N+1];
		count = new int[N+1];
		//bfs 시작
		bfs(personA);
		
		System.out.println(count[personB] - 1);
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		count[start] = 1;
		while(!queue.isEmpty()) {
			int index = queue.poll();

			if(index == personB) { 
				return;
			}
			for(int next : map.get(index)) {
				if(!visited[next]) {
					queue.add(next);
					visited[next] = true;
					count[next] = count[index] + 1;
				}
			}
			
		}
	}
}
