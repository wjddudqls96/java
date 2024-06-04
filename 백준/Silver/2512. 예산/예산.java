import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("./input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;
        
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        
        st = new StringTokenizer(in.readLine());
        
        for(int i = 0; i < N; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	arr[i] = num;
        }
        
        long M = Long.parseLong(in.readLine());
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = arr[N - 1];
        
        while(left <= right) {
        	int mid = (left + right) / 2;
        	long sum = 0;
        	
        	for(int i = 0; i < N; i++) {
        		
        		if(arr[i] <= mid) {
        			sum += arr[i];
        		}
        		else {
        			sum += mid;
        		}
        	}
        	
        	
        	if(sum <= M) {
        		left = mid + 1;
        	}
        	else {
        		right = mid -1;
        	}
        }
        
        System.out.println(right);
    }
}