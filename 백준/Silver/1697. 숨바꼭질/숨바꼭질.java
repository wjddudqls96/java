import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] count;
	static int N;
	static int K;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		N = Integer.parseInt(split[0]);
		K = Integer.parseInt(split[1]);
		
		count = new int[100001];
		if(N >= K) {
			System.out.println(N - K);
		}else {
			bfs(N);
			System.out.println(count[K]-1);
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		count[start] = 1;
		while(!queue.isEmpty()) {
			int index = queue.poll();
			
			for(int i = 0; i < 3; i++) {
				int nextIndex = 0;
				if(i == 0) {
					nextIndex = index + 1;
				}
				if(i == 1) {
					nextIndex = index -1;
				}
				if(i == 2) {
					nextIndex = 2*index;
				}
				
				if(nextIndex == K) {
					count[nextIndex] = count[index] + 1;
					return;
				}
				
				
				if(nextIndex >= 0 && nextIndex < count.length  && count[nextIndex] == 0) {
					queue.add(nextIndex);
					count[nextIndex] = count[index] + 1;
				}
			}
		}
		
	}
}
