import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			
			int[] arr = new int[N];
			
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = num;
			}
			
			int max = arr[N - 1];
			long sum = 0;
			
			for(int i = N - 2; i >= 0; i--) {
				int cur = arr[i];
				
				if(cur < max) {
					sum += (long) (max - cur);
				}
				else if(cur > max){
					max = cur;
				}
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}