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
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	String str = in.readLine();
    	Deque<Character> q = new ArrayDeque<>();
    	
    	int zeroCount = 0;
    	int oneCount = 0;
    	
    	for(int i = 0; i < str.length(); i++) {
    		char c = str.charAt(i);
    		
    		if(str.charAt(i) == '0') {
    			zeroCount++;
    		}
    		
    		q.offer(c);
    	}
    	
    	oneCount = (str.length() - zeroCount) / 2;
    	zeroCount /= 2;
    	int size = str.length();
    	
    	// 맨앞에서  1 반만큼 제거
    	for(int i = 0; i < size; i++) {
    		char c = q.pollFirst();
    		
    		if(c == '1' && oneCount != 0) {
    			oneCount--;
    		}
    		else {
    			q.offerLast(c);
    		}
    	}
    	
    	// 맨뒤에서 0 반만큼 제거
    	size = q.size();
    	for(int i = 0; i < size; i++) {
    		char c = q.pollLast();
    		
    		if(c == '0' && zeroCount != 0) {
    			zeroCount--;
    		}
    		else {
    			q.offerFirst(c);
    		}
    	}
    	
    	String result = "";
    	
    	while(!q.isEmpty()) {
    		result += q.pollFirst();
    	}
    	
    	System.out.println(result);
    }
}