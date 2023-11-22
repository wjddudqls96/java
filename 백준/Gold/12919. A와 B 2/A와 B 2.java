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
	static boolean isFind;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String S = in.readLine();
		String T = in.readLine();
		isFind = false;
		
		dfs(S, T);
		
		if(isFind) System.out.println(1);
		else System.out.println(0);
		
	}
	
	static void dfs(String S, String T) {
		
		if(isFind) return;
		
		if(T.length() == 0) return;
		
		if(S.equals(T)) {
			isFind = true;
			return;
		}
		
		if(T.charAt(0) == 'B') {
			StringBuffer sb = new StringBuffer(T.substring(1));
			dfs(S, sb.reverse().toString());
		}
		
		if(T.charAt(T.length() - 1) == 'A') {
			dfs(S, T.substring(0, T.length() - 1));
		}
	}
}