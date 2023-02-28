import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos implements Comparable<Pos>{
	int index, count;
	
	Pos(int index, int count){
		this.index = index;
		this.count = count;
	}

	@Override
	public int compareTo(Pos o) {
		return o.index - this.index;
	}
}

public class Solution {
	static int start, N, last;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> matrix;
	static ArrayList<Pos> results;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  null;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			matrix = new ArrayList<>();
			
			for(int i = 0; i < 101; i++) {
				matrix.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			// 인접 리스트 생성.
			for(int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				matrix.get(from).add(to);
			}
			
			visited = new boolean[101];
			results = new ArrayList<>();
			
			bfs(start);
			
			Collections.sort(results);
			
			for(int i = 0; i < results.size(); i++) {
				Pos pos = results.get(i);
				if(pos.count == last) {
					sb.append("#" + t + " " + pos.index).append("\n");
					break;
				}
			}
		}
		
		System.out.println(sb);
		
	}
	
	static void bfs(int start) {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.offer(new Pos(start, 0));
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			Pos current = queue.poll();
			results.add(current);
			last = current.count;
			for(int i = 0; i < matrix.get(current.index).size(); i++) {
				int nextIndex = matrix.get(current.index).get(i);
				
				if(visited[nextIndex]) continue;

				queue.offer(new Pos(nextIndex, current.count + 1));
				visited[nextIndex] = true;
			}
		}
	}
}