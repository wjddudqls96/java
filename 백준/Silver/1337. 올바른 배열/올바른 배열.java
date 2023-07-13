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
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(in.readLine());
        }
        
        Arrays.sort(arr);
        
//        System.out.println(Arrays.toString(arr));
        
        int min = 4;
        
        for(int i = 0; i < N; i++) {
        	int start = arr[i];
        	int count = 0;
        	int index = i + 1;
        	
        	for(int j = start + 1; j < start + 5; j++) {
        		
        		if(index < N && arr[index] == j) {
        			index++;
        		}
        		else count++;
        	}
        	
        	if(count > 5) {
        		min = 0;
        		break;
        	}
        	else {
        		min = Math.min(count, min);
        	}
        	
        }
        
        System.out.println(min);
        
    }
    
}