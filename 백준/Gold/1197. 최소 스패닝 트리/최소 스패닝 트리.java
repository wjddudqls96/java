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
	
	public Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o1) {
		return this.cost - o1.cost;
	}
}


public class Main {
    static int V, E;
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	
    	V = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	
    	ArrayList<Node>[] nodes = new ArrayList[V + 1];
    	
    	for(int i = 1; i <= V; i++) {
    		nodes[i] = new ArrayList<Node>();
    	}
    	
    	for(int i = 0; i < E; i++) {
    		st = new StringTokenizer(in.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		int cost = Integer.parseInt(st.nextToken());
    		
    		nodes[start].add(new Node(end, cost));
    		nodes[end].add(new Node(start, cost));
    	}
    	
    	boolean[] visit = new boolean[V + 1];
    	int result = 0;
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	
    	pq.add(new Node(1, 0));
    	
    	while(!pq.isEmpty()) {
    		Node cur = pq.poll();
    		
    		if(visit[cur.idx]) continue;
    		
    		visit[cur.idx] = true;
    		result += cur.cost;
    		
    		for(Node n : nodes[cur.idx]) {
    			
    			if(visit[n.idx]) continue;
    			
    			pq.offer(new Node(n.idx, n.cost));
    		}
    	}
    	
    	System.out.println(result);
    	
	}
}