import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


class Node implements Comparable<Node> {
	int idx;
	int cost;
	
	public Node (int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o1) {
		return this.cost - o1.cost;
	}
}

public class Main {
    static int N,M;
    static int[] arr;
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	
    	ArrayList<Node>[] nodes = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        
    	
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(in.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		int cost = Integer.parseInt(st.nextToken());
    		
    		nodes[start].add(new Node(end, cost));
    		nodes[end].add(new Node(start, cost));
    	}
    	
    	boolean[] visited = new boolean[N + 1];
    	int total = 0;
    	int max = 0;
    	
    	pq.add(new Node(1, 0));
    	
    	while(!pq.isEmpty()) {
    		Node cur = pq.poll();
    		
    		if(visited[cur.idx]) continue;
    		
    		visited[cur.idx] = true;
    		max = Math.max(max, cur.cost);
    		total += cur.cost;
    		
    		for (Node v : nodes[cur.idx]) {
                if (!visited[v.idx]) {
                    pq.add(new Node(v.idx, v.cost));
                }
            }
    	}
    	
    	System.out.println(total - max);
    }
	
}