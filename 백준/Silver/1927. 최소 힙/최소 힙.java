import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> queue = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < N; i++) {
			M = Integer.parseInt(in.readLine());
			
			if(M == 0) {
				if(queue.isEmpty()) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(queue.poll()).append("\n");
				}
			}
			else {
				queue.add(M);
			}
		}
		
		System.out.println(sb);
	}
}