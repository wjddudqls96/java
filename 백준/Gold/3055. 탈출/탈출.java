import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pos{
	int x;
	int y;
	String type;
	
	Pos(int x, int y, String type){
		this.x = x;
		this.y = y;
		this.type = type;
	}
}

public class Main {
	static boolean[][] visited;
	static int[][] count;
	static int R;
	static int C;
	static int xDo, yDo;
	static int xStart, yStart;
	static ArrayList<Pos> floods;
	
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        String[] split = in.readLine().split(" ");
        
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        
        visited = new boolean[R][C];
        floods = new ArrayList<>();
        count = new int[R][C];
        
        for(int i = 0; i < R; i++) {
        	String line = in.readLine();
        	for(int j = 0; j < C; j++) {
        		char c = line.charAt(j);
        		if(c == 'D') {
        			xDo = j;
        			yDo = i;
        		}
        		else if(c == '*') {
        			floods.add(new Pos(j, i, "flood"));
        		}
        		else if(c == 'S') {
        			xStart = j;
        			yStart = i;
        		}
        		else if(c == 'X') {
        			visited[i][j] = true;
        		}
        	}
        }
        
        bfs();
        
        if(count[yDo][xDo] == 0) {
        	System.out.println("KAKTUS");
        }
        else {
        	System.out.println(count[yDo][xDo]);
        }      
    }    
    
    static void bfs() {
    	int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    	Queue<Pos> queue = new LinkedList<>();
    	
    	for(Pos flood : floods) {
    		queue.add(flood);
    		visited[flood.y][flood.x] = true;
    	}
    	
    	queue.add(new Pos(xStart, yStart, "normal"));
    	visited[yStart][xStart] = true;
    	count[yStart][xStart] = 0;
    	
    	while(!queue.isEmpty()) {
    		Pos pos = queue.poll();
    		
    		if(pos.type.equals("normal") && pos.x == xDo && pos.y == yDo && !visited[pos.y][pos.x]) {
    			count[yDo][xDo] = count[pos.y][pos.x] + 1;
    			return;
    		}
    		
    		for(int i = 0; i < 4; i++) {
    			int nextX = pos.x + direction[i][0];
    			int nextY = pos.y + direction[i][1];
    			
    			if(nextX >= 0 && nextX < C && nextY >= 0 && nextY < R && !visited[nextY][nextX]) {
    				if(pos.type.equals("flood")) {
    	    			if(nextX == xDo && nextY == yDo) continue;
    	    			else {
    	    				visited[nextY][nextX] = true;
    	    				queue.add(new Pos(nextX, nextY, "flood"));
    	    			}
    	    		}
    	    		else {
    	    			queue.add(new Pos(nextX, nextY, "normal"));
    	    			visited[nextY][nextX] = true;
    	    			count[nextY][nextX] = count[pos.y][pos.x] + 1;
    	    		}
    			}
    		}
    	}
    }
}