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
	double x;
	double y;
	double cost;
	
	public Node(int idx, double x, double y, double cost) {
		this.idx =  idx;
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o1) {
		return (int) (this.cost - o1.cost);
	}
}


public class Main {
    static int N;
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	N = Integer.parseInt(in.readLine());
    	
    	Node[] nodes = new Node[N];
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(in.readLine());
    		double x = Double.parseDouble(st.nextToken());
    		double y = Double.parseDouble(st.nextToken());
    		
    		nodes[i] = new Node(i, x, y, 0);
    	}
    	
    	boolean[] visit = new boolean[N];
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(nodes[0]);
    	
    	double sum = 0;
    	
    	while(!pq.isEmpty()) {
    		Node cur = pq.poll();
    		
    		if(visit[cur.idx]) continue;
    		
    		visit[cur.idx] = true;
    		sum += cur.cost;
    		
    		for(int i = 0; i < nodes.length; i++) {
    			if(cur.idx == i) continue;
    			
    			if(visit[i]) continue;
    			
    			Node next = nodes[i];
    			
    			// 거리를 구해야함.
    			int dy = (int) Math.pow((next.y - cur.y),2);
    			int dx = (int) Math.pow((next.x - cur.x),2);
    			double distance = Math.sqrt(dy + dx);
    			
    			pq.offer(new Node(i, next.x, next.y, distance));
    		}
    	}
    	
    	System.out.println(sum);
	}
}