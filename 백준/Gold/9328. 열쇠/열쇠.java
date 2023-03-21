import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

class Pos{
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + "]";
	}
	
	
}

public class Main {
	static int H, W, cnt;
	static char[][] map;
	static Queue<Pos> startQueue, doorQueue;
	static HashSet<Character> set;
	static boolean[][] visited;
	static Pattern lowPattern = Pattern.compile("[a-z]");
	static Pattern upPattern = Pattern.compile("[A-Z]");
	
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine());
        
        for(int t = 1; t <= T; t++) {
        	st = new StringTokenizer(in.readLine());
        	H = Integer.parseInt(st.nextToken());
        	W = Integer.parseInt(st.nextToken());
        	startQueue = new ArrayDeque<>();
        	doorQueue = new ArrayDeque<>();
        	set = new HashSet<>();
        	cnt = 0;
        	
        	map = new char[H][W];
        	visited = new boolean[H][W];
        	
        	for(int i = 0; i < H; i++) {
        		String line = in.readLine();
        		for(int j = 0; j < W; j++) {
        			char c = line.charAt(j);
        			map[i][j] = c;
        			if((i == 0 || i == H - 1 || j == 0 || j == W - 1)) {
        				if(c == '.') {
        					startQueue.add(new Pos(j, i));
        					visited[i][j] = true;
        				}
        				else if(c == '$') {
        					cnt++;
        					startQueue.add(new Pos(j, i));
        					visited[i][j] = true;
        				}
        				else if(lowPattern.matcher(Character.toString(c)).find()) {
            				set.add(Character.toUpperCase(c));
            				startQueue.add(new Pos(j, i));
            				visited[i][j] = true;
            			}
            			// if door
            			else if(upPattern.matcher(Character.toString(c)).find()) {
            				doorQueue.add(new Pos(j, i));
            				visited[i][j] = true;
            			}
        			}
        		}
        	}
        	
        	
        	
        	String keys = in.readLine();
        	
        	if(!keys.equals("0")) {
        		for(int i = 0; i < keys.length(); i++) {
        			char upperC = Character.toUpperCase(keys.charAt(i));
        			set.add(upperC);
        		}
        	}
        
        	
        	while(true) {
        		while(!startQueue.isEmpty()) {
            		Pos pos = startQueue.poll();
            		bfs(pos);
            	}
            	
            	int size = doorQueue.size();
            	
            	for(int i = 0; i < size; i++) {
            		Pos pos = doorQueue.poll();
            		
            		if(!set.contains(map[pos.y][pos.x])) {
            			doorQueue.offer(pos);
            		}
            		else {
            			startQueue.offer(pos);
            		}
            	}
            	
            	if(startQueue.size() == 0) break;
            	
        	}
        	
        	System.out.println(cnt);
        }
        
    }
    
    static void bfs(Pos start) {
    	int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    	
		
    	Queue<Pos> queue = new ArrayDeque<>();
    	visited[start.y][start.x] = true;
    	queue.offer(start);
    	
    	while(!queue.isEmpty()) {
    		Pos current = queue.poll();

    		for(int i = 0; i < 4; i++) {
    			int nextX = current.x + directions[i][0];
    			int nextY = current.y + directions[i][1];
    			
    			if(nextX < 0 || nextX >= W || nextY < 0 || nextY >= H) continue;
    			
    			if(visited[nextY][nextX] || map[nextY][nextX] == '*') continue;
    			
    			if(map[nextY][nextX] == '$') cnt++;
    			
    			
    			
    			// if key
    			if(lowPattern.matcher(Character.toString(map[nextY][nextX])).find()) {
    				set.add(Character.toUpperCase(map[nextY][nextX]));
    				queue.offer(new Pos(nextX, nextY));
    			}
    			// if door
    			else if(upPattern.matcher(Character.toString(map[nextY][nextX])).find()) {
    				doorQueue.add(new Pos(nextX, nextY));
    			}
    			// if route
    			else {
    				queue.offer(new Pos(nextX, nextY));
    			}
    			
    			visited[nextY][nextX] = true;
    		}
    		
    	}
    }
}