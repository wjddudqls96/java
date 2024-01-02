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
import java.util.StringTokenizer;

class Route {
	int floor;
	int cnt;
	
	public Route(int floor, int cnt) {
		this.floor = floor;
		this.cnt = cnt;
	}
}


public class Main {
	static int F, S, G, U, D;
	static int[] dir;
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	
    	F = Integer.parseInt(st.nextToken());
    	S = Integer.parseInt(st.nextToken());
    	G = Integer.parseInt(st.nextToken());
    	U = Integer.parseInt(st.nextToken());
    	D = Integer.parseInt(st.nextToken());
    	
    	dir = new int[2];
    	dir[0] = U;
    	dir[1] = -D;
    	
    	// 만약 출발한 층이 목적지이면 바로 BFS을 돌지 않는다. 
    	if(S == G) {
    		System.out.println(0);
    	}
    	else {
    		bfs();	
    	}
    }
	
	static void bfs() {
		Queue<Route> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[2010000];
		
		queue.offer(new Route(S, 0));
		visit[S] = true;
		
		while(!queue.isEmpty()) {
			Route cur = queue.poll();
			
			for(int i = 0; i < 2; i++) {
				int next = cur.floor + dir[i];
				
				// 1. 만약 F층 위에 있거나 1층 밑이면 다음
				if(next > F || next < 1) continue;
				
				// 2. 만약 방문한 층이면 다음 
				if(visit[next]) continue;
				
				// 3. 만약 목적지에 도착하면 종료;
				if(next == G) {
					System.out.println(cur.cnt + 1);
					return;
				}
				
				queue.offer(new Route(next, cur.cnt + 1));
				visit[next] = true;
			}
		}
		
		System.out.println("use the stairs");
	}
}