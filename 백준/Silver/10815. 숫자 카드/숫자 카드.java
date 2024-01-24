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
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		M = Integer.parseInt(in.readLine());
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			sb.append(find(num) + " ");
		}
		
		System.out.println(sb);
	}
	
	static int find(int target) {
		int left = 0;
		int right = N - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(arr[mid] > target) {
				right = mid - 1;
			}
			else if(arr[mid] < target) {
				left = mid + 1;
			}
			else {
				return 1;
			}
		}
		
		return 0;
	}
}