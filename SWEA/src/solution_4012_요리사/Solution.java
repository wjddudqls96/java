package solution_4012_요리사;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] table;
	static int[] numbers;
	static int[] combi;
	static List<Integer> flavors;
	static int sum;
	static int min;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(in.readLine());
			table = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 구현
			numbers = new int[N/2];
			flavors = new ArrayList<Integer>();
			// N이 4보다 클경우만 가능함
			combi = new int[2];
			min = Integer.MAX_VALUE;
			combination(0,0);
			
			for(int i = 0; i < flavors.size(); i++) {
				int gap = Math.abs(flavors.get(i) - flavors.get(flavors.size() - 1 - i));
				if(min > gap) {
					min = gap;
				}
			}
			
			sb.append("#" + testCase + " " + min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void combination(int cnt, int count) {
		
		if(cnt == N/2) {
			sum = 0;
			combination2(numbers, 0, 0);
			flavors.add(sum);
			return;
		}
		
		for(int i = count; i < N; i++) {
			
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	
	static void combination2(int[] arr, int cnt, int count) {
		if(cnt == 2) {
			sum += getTasteSum(combi);
			return;
		}
		
		for(int i = count; i < arr.length; i++) {
			combi[cnt] = arr[i];
			combination2(arr, cnt + 1, i + 1);
		}
	}
	
	static int getTasteSum(int[] ingredients ) {
		int a = ingredients[0];
		int b = ingredients[1];
		
		return Math.abs(table[a][b] + table[b][a]);
	}
}
