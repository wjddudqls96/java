package solution_D4_maze1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Node{
	int value;
	boolean visted;
	
	Node(int value){
		this.value = value;
		this.visted = false;
	}
	
	void setVisit() {
		this.visted = true;
	}
}

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 0; test_case < 10; test_case++) {
			int T;
			int result = 0;
			T = Integer.parseInt(in.readLine());
			sb.append("#"+T+" ");
			
			// ? ?‹±ë¡œëªŒ?˜™? ?™?˜™? ï¿?
			Node[][] maze = new Node[16][16];
			for(int i = 0; i < 16; i++) {
				String line = in.readLine();
				for(int j = 0; j < line.length(); j++) {
					int value = line.charAt(j) - '0';
					Node node = new Node(value);
					maze[i][j] = node;
				}
			}
				
			dfs(maze, 1, 1);
			
			if(maze[1][1].value == 5) {
				result = 1;
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void dfs(Node[][] maze, int x, int y) {
		
		
		if(x < 0 || x >= 16 || y < 0 || y >= 16) return;
		
		Node node = maze[y][x];
		
		
		if(node.visted || node.value == 1) return;
		
		if(node.value == 3) {
			maze[1][1] = new Node(5);
		}
		
		node.setVisit();
		maze[y][x] = node;
		
		dfs(maze, x + 1, y);
		dfs(maze, x - 1, y);
		dfs(maze, x, y + 1);
		dfs(maze, x, y - 1);
		
	}
}
