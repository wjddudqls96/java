import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
	static int[] prices, plans;
	static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for(int t = 1; t <= T; t++) {
			prices = new int[4];
			plans = new int[12];
			
			st = new StringTokenizer(in.readLine().trim());
			for(int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(in.readLine().trim());
			for(int i = 0; i < 12; i++) {
				plans[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			dfs(0, 1, 0);
			dfs(0, 2, 0);
			dfs(0, 3, 0);
			sb.append("#" + t + " " + min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int startIndex, int type, int price) {
		
		
		
		// 1일권
		if(type == 0 && startIndex < 12) {
			price += plans[startIndex] * prices[0];
			startIndex++;
		}
		// 한달권
		if(type == 1) {
			price += prices[1];
			startIndex++;
		}
		// 세달권
		if(type == 2) {
			price += prices[2];
			startIndex += 3;
		}
		// 1년권
		if(type == 3) {
			price += prices[3];
			startIndex += 12;
		}
		
		if(startIndex >= 12) {
			
			if(min > price) {
				min = price;
			}
			return;
		}
		
		dfs(startIndex, 0, price);
		dfs(startIndex, 1, price);
		dfs(startIndex, 2, price);
		dfs(startIndex, 3, price);
	}
}