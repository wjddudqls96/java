import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        Map<Long, Set<Integer>> map = new HashMap<>();
        Map<Long, Boolean> isGoodMap = new HashMap<>();
        
        int N = Integer.parseInt(in.readLine());
        long[] arr = new long[N];
        boolean[] isGoods = new boolean[N];
        st = new StringTokenizer(in.readLine());
        
        for(int i = 0; i < N; i++) {
        	long num = Long.parseLong(st.nextToken());
        	arr[i] = num;
        	
        	if(!map.containsKey(num)) {
        		Set<Integer> set = new HashSet<>();
        		set.add(i);
        		map.put(num, set);
        	}
        	else {
        		Set<Integer> set = map.get(num);
        		set.add(i);
        		map.put(num, set);
        	}
        	
        	
        	isGoodMap.put(num, false);
        }
        
        
        int count = 0;
        
        for(int i = 0; i < N; i++) {
        	long num = arr[i];
        	
        	for(int j = i + 1; j < N; j++) {
        		long next = arr[j];
        		
        		if(map.containsKey(num + next)) {
        			int flag = 0;
        			
        			if(map.get(num + next).contains(i)) flag++;
        			
        			if(map.get(num + next).contains(j)) flag++;
        			
        			if(flag == 0) isGoodMap.put(num + next, true);
        			
        			else {
        				if(map.get(num + next).size() > flag) {
        					isGoodMap.put(num + next, true);
        				}
        			}
        		}
        	}
        }
        
        
        for(Long key : isGoodMap.keySet()) {
        	if(isGoodMap.get(key)) {
        		count += map.get(key).size();
        	}
        }
        
        System.out.println(count);
    }
    
}