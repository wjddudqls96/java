import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> mapList;
	static int N;
	static int M;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = in.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		
		mapList = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[N + 1];
		for(int i = 0; i <= N; i ++) {
			mapList.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			String[] split = in.readLine().split(" ");
			mapList.get(Integer.parseInt(split[0])).add(Integer.parseInt(split[1]));
			mapList.get(Integer.parseInt(split[1])).add(Integer.parseInt(split[0]));
		}
		
		count = 0;
		bfs();
		
		System.out.println(count);
		
	}
	
	static void bfs() {
		for(int i = 1; i <= N; i++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			if(!visited[i]) {
				visited[i] = true;
				queue.add(i);
				count++;
			}
			
			while(!queue.isEmpty()) {
				int index = queue.poll();
				for(int nexIndex : mapList.get(index)) {
					if(!visited[nexIndex]) {
						queue.add(nexIndex);
						visited[nexIndex] = true;
					}
				}
			}
		}
	}
}
