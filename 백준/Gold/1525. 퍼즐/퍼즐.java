import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String start = "";
		for(int i = 0; i < 3; i++) {
			String[] line = in.readLine().split(" ");
			for(int j = 0; j < 3; j++) {
				start += line[j];
			}
		}
		
		bfs(start);
	}
	
	static void bfs(String start) {
		int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
		Queue<String> queue = new LinkedList<>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int index = start.indexOf("0");
		map.put(start, 0);
		queue.add(start);
		
		while(!queue.isEmpty()) {
			String line =  queue.poll();
			int currentIndex = line.indexOf("0");
			int x = currentIndex % 3;
			int y = currentIndex / 3;
			
			for(int i = 0; i < 4; i++) {
				
				int nextX = x + direction[i][0];
				int nextY = y + direction[i][1];
				int nextIndex = nextY * 3 + nextX;
				
				//인덱스를 벗어나지 안을경우.
				if(nextX >= 0 && nextX < 3 && nextY >= 0 && nextY < 3 && nextIndex >= 0 && nextIndex < 9) {
					StringBuilder next = new StringBuilder(line);
					char temp = next.charAt(nextIndex);
					next.setCharAt(currentIndex, temp);
					next.setCharAt(nextIndex, '0');
					
					String nextString = next.toString();
					
					if(!map.containsKey(nextString)) {
						map.put(nextString, map.get(line) + 1);
						queue.add(nextString);
					}
					
				}
			}
		}
		
		if(map.containsKey("123456780")) {
			System.out.println(map.get("123456780"));
		}else {
			System.out.println(-1);
		}
		
	}
	
	
}