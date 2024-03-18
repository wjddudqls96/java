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

class Pos {
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		List<Pos> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new Pos(x, y));
		}
		
		// 마지막 좌표를 강제로 넣어준다.
		list.add(new Pos(list.get(list.size() - 1).x + 1, 0));
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		
		for(Pos pos : list) {
			
			while(!stack.isEmpty() && pos.y < stack.peek()) {
				result++;
				stack.pop();
			}
			
			if(!stack.isEmpty() && stack.peek() == pos.y) continue;
			
			stack.push(pos.y);
		}
		
		System.out.println(result);
		
	}
}