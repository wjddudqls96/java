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
		
		String line = in.readLine();
		int aCount = 0;
		int min = Integer.MAX_VALUE;
		
		// 1. 전체 a수를 구한다,
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			
			if(c == 'a') aCount++;
		}
		
		
		for(int i = 0; i < line.length(); i++) {
			int result = 0;
			
			for(int j = i; j < i + aCount; j++) {
				int index = j % line.length();
				char c = line.charAt(index);
				
				if(c == 'a') {
					result++;
				}
			}
			
			min = Math.min(min, aCount - result);
		}
		
		System.out.println(min);
	}
	
}