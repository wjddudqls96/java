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

		N = Integer.parseInt(in.readLine());
		char[] cArr = in.readLine().toCharArray();
		
		int redCount = 0;
		int blackCount = 0;
		
		for(int i = 0; i < cArr.length; i++) {
			char c = cArr[i];
			
			if(c == 'R') redCount++;
			else blackCount++;
		}
		
		int result = Integer.MAX_VALUE;
		
		// 1. R 맨앞으로 보내는 수
		result = Math.min(result, redCount - moveFrontCount('R', cArr));
		// 1. R 맨뒤으로 보내는 수
		result = Math.min(result, redCount - moveBackCount('R', cArr));
		// 1. B 맨앞으로 보내는 수
		result = Math.min(result, blackCount - moveFrontCount('B', cArr));
		// 1. B 맨뒤으로 보내는 수
		result = Math.min(result, blackCount - moveBackCount('B', cArr));
		
		
		System.out.println(result);
	}
	
	static int moveFrontCount(char c, char[] arr) {
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			if(arr[i] == c) count++;
			else break;
		}
		
		return count;
	}
	
	static int moveBackCount(char c, char[] arr) {
		int count = 0;
		
		for(int i = N - 1; i >= 0; i--) {
			if(arr[i] == c) count++;
			else break;
		}
		
		return count;
	}
}