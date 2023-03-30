import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewel implements Comparable<Jewel>{
	int w;
	int v;
	
	Jewel(int w, int v){
		this.w = w;
		this.v = v;
	}

	@Override
	public String toString() {
		return "Jewel [w=" + w + ", v=" + v + "]";
	}

	public int compareTo(Jewel o) {
		if(this.w == o.w) {
			return o.v - this.v;
		}
		return this.w - o.w;
	}
}

public class Main {
	static int N, K;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ArrayList<Jewel> jewels = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			jewels.add(new Jewel(weight, value));
		}
		
		ArrayList<Integer> bags = new ArrayList<>();
		
		for(int i = 0; i < K; i++) {
			bags.add(Integer.parseInt(in.readLine()));
		}
		
		Collections.sort(jewels);
		Collections.sort(bags);
		
		int cnt = 0;
		Long result= (long) 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>((e1, e2) -> {
			return e2 - e1;
		});
		
		for(int i = 0; i < bags.size(); i++) {
			int cur = bags.get(i);
			
			while(cnt < N && jewels.get(cnt).w <= cur) {
				queue.offer(jewels.get(cnt++).v);
			}
			
			if(!queue.isEmpty()) {
				result += queue.poll();
			}
		}
		
		System.out.println(result);
	}
}