import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(in.readLine());
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	
    	for(int i = 0; i < N; i++) {
    		pq.offer(Integer.parseInt(in.readLine()));
    	}
    	
    	int sum = 0;
    	
    	while(pq.size() >= 2) {
    		int A = pq.poll();
    		int B = pq.poll();
    		
    		sum += A + B;
    		pq.offer(A + B);
    	}
    	
    	System.out.println(sum);
	}
}