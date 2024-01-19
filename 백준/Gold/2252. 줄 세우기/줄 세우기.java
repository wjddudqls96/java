import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
	int vertex;
	Node link;
	
	public Node(int vertex, Node link) {
		super();
		this.vertex = vertex;
		this.link = link;
	}
	
	@Override
	public String toString() {
		return this.vertex + " " + "link : " + this.link;
	}
}

public class Main {
	static int N, M;
	static Node[] adjList;
	static int[] inDegree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	adjList = new Node[N + 1];
    	inDegree = new int[N + 1];
    	
    	int from, to;
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(in.readLine());
    		

    		from = Integer.parseInt(st.nextToken());
    		to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
    		inDegree[to]++;
    			
    	}
    	
    	ArrayList<Integer> list = topologySort();
    	
    	if(list.size() == N) {
    		for(int num : list) {
    			sb.append(num + " ");
    		}
    	}
    	else {
    		System.out.println("0");
    	}
    	
    	System.out.println(sb);
	}
	
	static ArrayList<Integer> topologySort() {
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			list.add(cur);
			
			for(Node temp = adjList[cur]; temp != null; temp = temp.link) {
				if(--inDegree[temp.vertex] == 0) {
					queue.offer(temp.vertex);
				}
			}
		}
		
		return list;
	}
}