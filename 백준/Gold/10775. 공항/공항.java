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
import java.util.Stack;
import java.util.StringTokenizer;



public class Main {
    static int G, P;
    static int[] gates;
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	G = Integer.parseInt(in.readLine());
    	P = Integer.parseInt(in.readLine());
    	gates = new int[G + 1];
    	
    	makeSet();
    	
    	int result = 0;
    	
    	for(int i = 0; i < P; i++) {
    		int destination = Integer.parseInt(in.readLine());
    		
    		if(findSet(destination) != 0) {
    			result++;
    			union(findSet(destination) - 1, findSet(destination));
    		}
    		else {
    			break;
    		}
    		
    	}
    	
    	System.out.println(result);
    	
	}
	
	static void makeSet() {
		for(int i = 0; i <= G; i++) {
			gates[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(gates[x] == x) {
			return x;
		}
		
		return gates[x] = findSet(gates[x]);
	}
	
	static void union(int x, int y) {
		if(x != y) {
			gates[findSet(y)] = findSet(x);
		}
	}
	
	
}