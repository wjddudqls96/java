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

class Node {
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


public class Main {
	static int[][] map;
	static int N, M, min;
	static boolean[] visit;
	static List<Node> chickenList, houseList;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("input.txt"));
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][N];
    	
    	chickenList = new ArrayList<>();
    	houseList = new ArrayList<>();
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(in.readLine());
    		for(int j = 0; j < N; j++) {
    			int num = Integer.parseInt(st.nextToken());
    			map[i][j] = num;
    			
    			if(num == 2) {
    				chickenList.add(new Node(j, i));
    			}
    			if(num == 1) {
    				houseList.add(new Node(j, i));
    			}
    		}
    	}
    	
    	visit = new boolean[chickenList.size()];
    	min = Integer.MAX_VALUE;
    	combi(0, 0);
    	
    	System.out.println(min);
	}
	
	static void combi(int idx, int count) {
		if(count == M) {
	    // 스타트팀과 링크팀의 차이를 계산하는 함수 추가.
			int total = 0;
			
			for(int i = 0; i < houseList.size(); i++) {
				int temp = Integer.MAX_VALUE;
				
				for(int j = 0; j < chickenList.size(); j++) {
					if(visit[j]) {
						int dist = Math.abs(houseList.get(i).x - chickenList.get(j).x)
								+ Math.abs(houseList.get(i).y - chickenList.get(j).y);
						
						temp = Math.min(temp, dist);
					}
				}
				
				total += temp;
			}
			
			min = Math.min(min, total);
			return;
		}
		 
		for(int i = idx; i < chickenList.size(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				combi(i + 1, count + 1);
				visit[i] = false;
			}
		}
	}
}