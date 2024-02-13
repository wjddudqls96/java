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
	private static int H, W;
	private static int[] arr;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		arr = new int[W];
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		
		for(int i = 1; i < W - 1; i++) {
			int maxLeft = 0;
			int maxRight = 0;
			
			for(int j = 0; j < i; j++) {
				maxLeft = Math.max(maxLeft, arr[j]);
			}
			
			for(int j = i + 1; j < W; j++) {
				maxRight = Math.max(maxRight, arr[j]);
			}
			
			
			if(arr[i] < maxLeft && arr[i] < maxRight) {
				result += Math.min(maxLeft, maxRight) - arr[i];
			}
		}
		
		System.out.println(result);
        
	}
}