import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] parents;
	static ArrayList<ArrayList<Integer>> matrix;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        
        int T = Integer.parseInt(in.readLine());
        
        for(int t = 1; t <= T; t++) {
        	st = new StringTokenizer(in.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	
        	parents = new int[N + 1];
        	makeSet(N);
        	
        	for(int i = 0; i < M; i++) {
        		st = new StringTokenizer(in.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		union(a, b);
        	}
        	
        	
        	HashSet<Integer> set = new HashSet<>();
        	
        	for(int i = 1; i < parents.length; i++) {
        		findSet(i);
        	}
        	
        	for(int i = 1; i < parents.length; i++) {
        		set.add(parents[i]);
        	}
        	
        	sb.append("#" + t + " " + set.size()).append("\n"); 
        }
        System.out.println(sb);
    }
    
    static void makeSet(int N) {
    	for(int i = 1; i <= N; i++) {
    		parents[i] = i;
    	}
    }
    
    static int findSet(int a) {
    	if(parents[a] == a) {
    		return a;
    	}
    	
    	return parents[a] = findSet(parents[a]);
    }
    
    static boolean union(int a, int b) {
    	int aRoot = findSet(a);
    	int bRoot = findSet(b);
    	
    	if(aRoot == bRoot) {
    		return false;
    	}
    	
    	parents[bRoot] = aRoot;
    	return true;
    }
}