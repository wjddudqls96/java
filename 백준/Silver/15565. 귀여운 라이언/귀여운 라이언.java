import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static int N, K;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		
		int min = Integer.MAX_VALUE;

		two_pointer();
	}
	
	static void two_pointer() {
		int left = 0;
		int right = 0;
		int sum = 0;
		int length = Integer.MAX_VALUE;
		
		while(right < N) {
			if(sum<K) {
				if(arr[right]==1) {
					sum++;
				}
				right++;
			}
			else {
				if(arr[left]==1) {
					length = Math.min(length,right - left);
					sum--;
				}
				left++;
			}
		}
		
		while(left < N) {
			if(sum<K) break;
			if(arr[left]==1) {
				length = Math.min(length,right - left);
				sum--;
			}
			left++;
		}
		if(length==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(length);
	}
}