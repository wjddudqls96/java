import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Node implements Comparable<Node>{
	int start;
	int end;
	int distance;
	
	public Node(int start, int end, int distance) {
		this.start = start;
		this.end = end;
		this.distance = distance;
	}
	
	@Override
	public int compareTo(Node o1) {
		return this.distance - o1.distance;
	}
}


public class Main {
	static int N, D;
	static ArrayList<Node> adjList;
	static int[] distances;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			if(end > D) continue;
			
			if(distance >= (end - start)) continue;
			
			Node node = new Node(start, end, distance);
			adjList.add(node);
		}
		
		dijkstra(0);
		
		System.out.println(distances[D]);
		
	}
	
	static void dijkstra(int start) {
		distances = new int[D + 1];

		for(int i = 0; i < D + 1; i++) {
			distances[i] = i;
		}

		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0, 0));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for(Node next : adjList) {
				
				if(next.start >= cur.end) {
					int tmp = next.start - cur.end;
					if(distances[next.end] > distances[cur.end] + next.distance + tmp) {
						distances[next.end] = distances[cur.end] + next.distance + tmp;
						queue.offer(new Node(next.start, next.end, distances[next.end]));
					}
				}
			}
			
			distances[D] = Math.min(distances[D], distances[cur.end] + D - cur.end);
		}
	}
}