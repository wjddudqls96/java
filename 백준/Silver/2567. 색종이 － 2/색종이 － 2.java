import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N, M, cnt;
	static int[][] map;
	static ArrayList<ArrayList<Integer>> matrix;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        
        map = new int[101][101];
        
        N = Integer.parseInt(in.readLine());
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(in.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	for(int j = y; j < y + 10; j++) {
        		for(int k = x; k < x + 10; k++) {
        			map[j][k] = 1;
        		}
        	}
        }
        
        
        
        for(int i = 0; i < 100; i++) {
    		for(int j = 0; j < 100; j++) {
    			if(map[i][j] == 1) {
    				bfs(j, i);
    			}
    		}
    	}
       
        System.out.println(cnt);
    }
    
    
    static void bfs(int startX, int startY) {
    	int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    	Queue<Pos> queue = new ArrayDeque<Pos>();
    	map[startY][startX] = 3;
    	queue.offer(new Pos(startX, startY));
    	
    	while(!queue.isEmpty()) {
    		Pos current = queue.poll();
    		
    		for(int i = 0; i < 4; i++) {
    			int nextX = current.x + directions[i][0];
    			int nextY = current.y + directions[i][1];
    			
    			if(nextX < 0 || nextX >= 101 || nextY < 0 || nextY >= 101) {
    				continue;
    			}
    			
    			
    			if(map[nextY][nextX] == 1) {
    				queue.offer(new Pos(nextX, nextY));
    				map[nextY][nextX] = 3;
    			}
    			else {
    				if(map[nextY][nextX] == 0) {
    					cnt++;
    				}
    			}
    		}
    	}
    }
}