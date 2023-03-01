package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	int num;
	
	Pos(int x, int y, int num){
		this.x = x;
		this.y = y;
		this.num = num;
	}
}

public class Main {
	static int N, MIN, MAX;
	static int[] input;
	static int[] nums;
	static HashMap<Integer, Integer> map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			
			st = new StringTokenizer(in.readLine());
			
			map = new HashMap<>();
			
			for(int i = 0; i < 4; i++) {
				map.put(i, Integer.parseInt(st.nextToken()));
			}
			
			nums = new int[N];
			
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			input = new int[N-1];
			MAX = Integer.MIN_VALUE;
			MIN = Integer.MAX_VALUE;
			
			permutation(0);
			sb.append("#" + t + " " + (MAX - MIN)).append("\n");
		}
		System.out.println(sb);
	}
	
	static void permutation(int cnt) {
		if(cnt == N - 1) {
			int result = nums[0];
			for(int i = 1; i < N; i++) {
				result = operation(result, nums[i], input[i - 1]);
			}
			if(MIN > result) {
				MIN = result;
			}
			
			if(MAX < result) {
				MAX = result;
			}
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(map.get(i) > 0) {
				input[cnt] = i;
				map.put(i, map.get(i) - 1);
				permutation(cnt + 1);
				map.put(i, map.get(i) + 1);
			}
		}
		
	}
	
	static int operation(int a, int b, int type) {
		switch (type) {
		case 0:
			return a + b;
		case 1:
			return a - b;
		case 2:
			return a * b;
		case 3:
			return a / b;
		}
		return Integer.MAX_VALUE;
	}
}
