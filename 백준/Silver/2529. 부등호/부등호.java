import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int K;
	static long min, max;
	static String strMin, strMax;
	static String[] split;
	static int[] numbers;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	K = Integer.parseInt(in.readLine());
    	split = in.readLine().split(" ");
    	visit = new boolean[10];
    	numbers = new int[K + 1];
    	min = Long.MAX_VALUE;
    	max = Long.MIN_VALUE;
    	
    	// 수열문제.
    	permutation(0);
    	
    	System.out.println(strMax);
    	System.out.println(strMin);
    }
	
	static void permutation(int count) {
		if(count == K + 1) {
//			System.out.println(Arrays.toString(numbers));
			if(isMatch()) {
				String strNumber = getNumber();
				long number = Long.parseLong(strNumber);
				
				if(min > number) {
					min = number;
					strMin = strNumber;
				}
				
				if(max < number) {
					max = number;
					strMax = strNumber;
				}
			}
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			
			if(visit[i]) continue;
			
			numbers[count] = i;
			visit[i] = true;
			permutation(count + 1);
			visit[i] = false;
		}
	}
	
	static boolean isMatch() {
		for(int i = 0; i < split.length; i++) {
			String arrow = split[i];
			
			if(arrow.equals(">")) {
				if(numbers[i] <= numbers[i + 1]) {
					return false;
				}
			}
			else {
				if(numbers[i] >= numbers[i + 1]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static String getNumber() {
		String number = "";
		for(int i = 0; i < numbers.length; i++) {
			number += Integer.toString(numbers[i]);
		}
		
		return number;
	}
}