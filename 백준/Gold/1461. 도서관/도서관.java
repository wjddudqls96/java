import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
       
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        ArrayList<Integer> minus = new ArrayList<>();
        ArrayList<Integer> plus = new ArrayList<>();
       
       st = new StringTokenizer(in.readLine());
       
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       int max = Integer.MIN_VALUE;
       
       st = new StringTokenizer(in.readLine());
       
       for(int i = 0; i < N; i++) {
    	   int num = Integer.parseInt(st.nextToken());
    	   
    	   max = Math.max(max, Math.abs(num));
    	   
    	   if(num < 0) {
    		   minus.add(Math.abs(num));
    	   }
    	   else {
    		   plus.add(num);
    	   }
       }
       
       
       minus.sort(Collections.reverseOrder());
       plus.sort(Collections.reverseOrder());
       
       int result = 0;
       
       for(int i = 0; i < plus.size(); i++) {
    	   if(i % M == 0 && plus.get(i) == max) {
    		   result += plus.get(i);
    	   }
    	   else if(i % M == 0) {
    		   result += plus.get(i) * 2;
    	   }
       }
       
       for(int i = 0; i < minus.size(); i++) {
    	   if(i % M == 0 && minus.get(i) == max) {
    		   result += minus.get(i);
    	   }
    	   else if(i % M == 0) {
    		   result += minus.get(i) * 2;
    	   }
       }
       
       System.out.println(result);
    }
    
}