import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] eat = new int[d + 1];
		int[] sushi = new int[N + 1];
		
		for(int i = 0; i < N; i++) {
			int s = Integer.parseInt(in.readLine());
			sushi[i] = s;
		}
		
		int max = 0;
		int count = 0;
		
		for(int i = 0; i < k; i++) {
			if(eat[sushi[i]]++ == 0) count++;
		}
		
		
		for(int i = 0; i < N; i++) {
			if(max <= count) {
				if(eat[c] == 0) max = count + 1;
				else max = count;
			}
			
			int j = (i + k) % N;
			
			if(eat[sushi[j]]++ == 0) count++;
			if(--eat[sushi[i]] == 0) count--;
		}
		
		System.out.println(max);
	}
	
}