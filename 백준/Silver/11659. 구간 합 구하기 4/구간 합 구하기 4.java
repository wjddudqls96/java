import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tree, arr;
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		tree = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			update(i, arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int res = sum(b) - sum(a - 1);
			sb.append(res + "\n");
		}
		System.out.println(sb);
	}
	
	static void update(int i, int num) {
	    while (i <= n) {
	        tree[i] += num;
	        i += (i & -i);
	    }
	}
	
	static int sum(int a) {
		int sum = 0;
		while (a > 0) {
			sum += tree[a];
			a -= (a & -a);
		}
		return sum;
	}
}