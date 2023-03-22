import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int num;
	int distance;
	
	Node(int num, int distance){
		this.num = num;
		this.distance = distance;
	}
	
	public int compareTo(Node o) {
		return this.distance - o.distance;
	}
}

public class Main {
	static int N, M, R;
	static int[] weaponCnt;
	static ArrayList<ArrayList<Node>> adjList;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		weaponCnt = new int[N + 1];
		adjList = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(in.readLine());
		
		for(int i = 1; i <= N; i++) {
			weaponCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		// adjlist init
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			adjList.get(to).add(new Node(from, distance));
			adjList.get(from).add(new Node(to, distance));
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i <= N; i++) {
			int[] result = dijkstra(i);
			int sum = 0;
			for(int j = 0; j < result.length; j++) {
				if(result[j] <= M) {
					sum += weaponCnt[j];
				}
			}
			
			if(max < sum) {
				max = sum;
			}
		}
		
		System.out.println(max);
	}
	
	static int[] dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		int[] distances = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[start] = 0;
		
		queue.offer(new Node(start, 0));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(visited[cur.num]) continue;
			
			visited[cur.num] = true;
			
			ArrayList<Node> list = adjList.get(cur.num);
			
			for(Node next : list) {
				if(!visited[next.num] && distances[next.num] > distances[cur.num] + next.distance) {
					distances[next.num] = distances[cur.num] + next.distance;
					queue.offer(new Node(next.num, distances[next.num]));
				}
			}
		}
		
		return distances;
	}
}
