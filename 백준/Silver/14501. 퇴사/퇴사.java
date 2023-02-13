import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	int day;
	int money;
	
	Node(int day, int money){
		this.day = day;
		this.money = money;
	}
}
public class Main {
	static int N;
	static boolean[] visited;
	static Node[] nodes;
	static int MAX = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		visited = new boolean[N];
		nodes = new Node[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			nodes[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		set(1, 0);
		System.out.println(MAX);
	}
	
	static void set(int cnt, int sum) {
			
		if(cnt == N + 1) {
			if(MAX < sum) {
				MAX = sum;
			}
			return;
		}
		
		if(cnt > N + 1) {
			return;
		}
		
		
		set(cnt + nodes[cnt - 1].day, sum + nodes[cnt - 1].money);
		set(cnt + 1, sum);
	}
}