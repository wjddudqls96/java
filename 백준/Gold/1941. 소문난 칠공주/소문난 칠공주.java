import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int x;
	int y;
	int count;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
	
}
public class Main {
	static int N, result;
	static char[][] map;
	static ArrayList<Node> nodeList;
	static Node[] input;
	static boolean[][] visited;
	
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        map = new char[5][5];
        nodeList = new ArrayList<>();
        
        for(int i = 0; i < 5; i++) {
        	String line = in.readLine();
        	for(int j = 0; j < 5; j++) {
        		char c = line.charAt(j);
        		map[i][j] = c;
        		nodeList.add(new Node(j, i));
        	}
        }
        
        input = new Node[7];
        
        combination(0, 0);
        
        System.out.println(result);
       
    }
    
    static void combination(int cnt, int start) {
    	if(cnt == 7) {
    		bfs(input);
    		return;
    	}
    	
    	for(int i = start; i < nodeList.size(); i++) {
    		input[cnt] = nodeList.get(i);
    		combination(cnt + 1, i + 1);
    	}
    }
    
    static void bfs(Node[] input) {
    	int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    	int cnt = 0;
    	int sCnt = 0;
    	Queue<Node> queue = new ArrayDeque<>();
    	visited = new boolean[5][5];
    	
    	queue.offer(input[0]);
    	visited[input[0].y][input[0].x] = true;
    	
    	while(!queue.isEmpty()) {
    		Node cur = queue.poll();
    		
    		cnt++;
    		if(map[cur.y][cur.x] == 'S') {
    			sCnt++;
    		}
    		
    		for(int i = 0; i < 4; i++) {
    			int nextX = cur.x + directions[i][0];
    			int nextY = cur.y + directions[i][1];
    			
    			if(nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5) continue;
    			
    			if(visited[nextY][nextX]) continue;
    			
    			for(int j = 1; j < input.length; j++) {
    				Node nextNode = input[j];
    				
    				if(nextX == nextNode.x && nextY == nextNode.y) {
    					visited[nextY][nextX] = true;
    					queue.offer(nextNode);
    				}
    			}
    		}
    	}
    	
    	if(cnt == 7 && sCnt >= 4) {
    		result++;
    	}
    }
}