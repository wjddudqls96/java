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

class Pos{
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N, M, count;
	static int[][] map;
	static boolean[][] visited;
	
    public static void main(String[] args) throws Exception {
       
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(in.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
       
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(in.readLine());
        	
        	for(int j = 0; j < M; j++) {
        		int num = Integer.parseInt(st.nextToken());
        		map[i][j] = num;
        	}
        }
        
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		if(map[i][j] != 0 && visited[i][j]==false) { 
        			bfs(j, i);
				}
        	}
        }
        
        System.out.println(count);
    }
    
    public static void bfs(int startX, int startY) {
    	int[][] dir = {{-1, -1},{-1, 0},{-1, 1}, {0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};
    	Queue<Pos> queue = new ArrayDeque<>();
    	List<Pos> topList = new ArrayList<>();
    	boolean[][] found = new boolean[N][M];
    	
    	queue.offer(new Pos(startX, startY));
    	found[startY][startX] = true;
    	
    
    	while(!queue.isEmpty()) {
    		Pos cur = queue.poll();
    		
    		for(int i = 0; i < 8; i++) {
    			int nextX = cur.x + dir[i][0];
    			int nextY = cur.y + dir[i][1];
    			
    			if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
    			
    			if(found[nextY][nextX]) continue;
    			
    			
    			if(map[cur.y][cur.x] < map[nextY][nextX]) {
    				return;
    			}
    			else if (map[cur.y][cur.x] == map[nextY][nextX]){
    				queue.offer(new Pos(nextX, nextY));
    				topList.add(new Pos(nextX, nextY));
    			}
    
    			found[nextY][nextX] = true;
    		}
    	}
    	
    	
    	for(int i=0; i<topList.size(); i++) {
			Pos cur = topList.get(i);
			visited[cur.y][cur.x]=true;
		}
    	
    	count++;
    }
    
}