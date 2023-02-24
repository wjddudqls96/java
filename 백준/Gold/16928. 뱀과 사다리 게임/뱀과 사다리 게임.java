import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;


class Pos{
	int index;
	int count;
	
	public Pos(int index, int count) {
		super();
		this.index = index;
		this.count = count;
	}
}

public class Main {
	static int N,M;
	static HashMap<Integer, Integer> map;
	static int MIN = Integer.MAX_VALUE;
	static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        map = new HashMap<>();
        visited = new boolean[150];
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i <= 100; i++) {
        	map.put(i, i);
        }
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(in.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	map.put(start, end);
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(in.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	map.put(start, end);
        }
        
        bfs();
        
        System.out.println(MIN);
        
    }
    
    static void bfs() {
    	Queue<Pos> queue = new ArrayDeque<>();
    	queue.offer(new Pos(map.get(1), 0));
    	visited[map.get(1)] = true;
    	
    	while(!queue.isEmpty()) {
    		Pos current = queue.poll();
    		
    		if(current.index == 100) {
    			MIN = current.count;
    			break;
    		}
    		
    		for(int i = 1; i <= 6; i++) {
    			int index = current.index + i;
    			
    			if(index <= 100 && !visited[map.get(index)]) {
    				queue.offer(new Pos(map.get(index), current.count + 1));
    				visited[map.get(index)] = true;
    			}
    		}
    	}
    }
}