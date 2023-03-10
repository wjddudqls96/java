import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Node{
	int x;
	int time;
	
	Node(int x, int time){
		this.x = x;
		this.time = time;
	}
}

public class Main {
	static int N, K, min;
	static int[][] map, temp;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		min = Integer.MAX_VALUE;
		bfs(N);
		
		System.out.println(min);
	}
	
	static void bfs(int startIndex) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(startIndex, 0));
		visited[startIndex] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int index = node.x;
			
			if(index == K) {
				min = Math.min(min, node.time);
			}
			
			if(min < node.time) {
				continue;
			}
			
			if(2*index < 100001 && !visited[2*index]) {
				queue.offer(new Node(2*index, node.time));
				visited[2*index] = true;
			}
			
			if(index -1 >= 0 && !visited[index - 1]) {
				queue.offer(new Node(index-1, node.time + 1));
				visited[index - 1] = true;
			}
			
			if(index + 1 < 100001 && !visited[index + 1]) {
				queue.offer(new Node(index+1, node.time + 1));
				visited[index + 1] = true;
			}
			
			
			
		}
	}
}