import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	private static int N, Q;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		String testCase;
		
		while((testCase = in.readLine()) != null) {
			int x = Integer.parseInt(testCase) * 10000000;
			int n = Integer.parseInt(in.readLine());
			int[] legos = new int[n];
			
			for(int i = 0; i < n; i++) {
				int lego = Integer.parseInt(in.readLine());
				legos[i] = lego;
			}
			
			// 이분탐색 시작.
			Arrays.sort(legos);
			
			int left = 0;
			int right = n - 1;
			boolean ans = false;
			
			while(left < right) {
				int sum = legos[left] + legos[right];
				
				if(sum > x) {
					right--;
				}
				else if(sum < x) {
					left++;
				}
				else {
					ans = true;
					break;
				}
			}
			
			if(ans) {
				sb.append("yes " + legos[left] + " " + legos[right]).append("\n");
			}
			else {
				sb.append("danger").append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
}