import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			
			if(num == 0) {
				if(queue.isEmpty()) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(queue.poll()).append("\n");
				}
			}
			else {
				queue.offer(num);
			}
		}
		
		System.out.println(sb);
	}
	
}