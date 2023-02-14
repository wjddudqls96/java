import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int testCase = 1; testCase <= 10; testCase++) {
			int N = Integer.parseInt(in.readLine());
			String[] tree = new String[201];
			
			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				tree[Integer.parseInt(st.nextToken())] = st.nextToken();
			}
			
			int isSucees = 1;
			for(int i = 1; i < tree.length; i++) {
				// 만약 루트 노드가 연산자라면 -> 자식 노드 둘다 null 이면 실패
				if(tree[i] == null) continue;
				
				if(tree[i].equals("+") || tree[i].equals("/") || tree[i].equals("*") || tree[i].equals("-")) {
					if(tree[2*i + 1] == null || tree[2*i] == null) {
						isSucees = 0;
						break;
					}
				}
				// 루트 노드가 숫자라면 -> 자식 노드가 존재하면 안된다. 즉 null 이거나 범위를 벗어나야된다.
				else {
					if(2*i + 1 < tree.length && 2*i < tree.length && tree[2*i] != null && tree[2*i + 1] != null) {
						isSucees = 0;
						break;
					}
				}
			}
			
			sb.append("#" + testCase + " " + isSucees).append("\n");
		}
		
		System.out.println(sb);
	}
}

