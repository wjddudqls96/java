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


public class Main {
	static int T, K;
	static int[] arr;
	static final int BORDER = 100001;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			K = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			
			for(int i = 0; i < K; i++) {
				pq.offer(Long.parseLong(st.nextToken()));
			}
			
			long result = 0;
			
			while(pq.size() > 1) {
				long a = pq.poll();
				long b = pq.poll();
				
				result += a + b;
				pq.offer(a + b);
			}
			
			System.out.println(result);
		}
		
	}
}