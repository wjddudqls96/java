import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static long[] arr;
	
    public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("./input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        N = Integer.parseInt(in.readLine());
        
        arr = new long[N];
        
        st = new StringTokenizer(in.readLine());
        
        for(int i = 0; i < N; i++) {
        	arr[i] = Long.parseLong(st.nextToken());
        }
        
        // 이분 탐색 시작
        
        // 1. 정렬
        Arrays.sort(arr);
        
        int M = Integer.parseInt(in.readLine());
        
        st = new StringTokenizer(in.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < M; i++) {
        	boolean result = isFind(Long.parseLong(st.nextToken()));
        	
        	if(result) {
        		sb.append("1").append("\n");
        	}
        	else {
        		sb.append("0").append("\n");
        	}
        }
        
        System.out.println(sb);
    }
    
    static boolean isFind(long target) {
    	
    	int left = 0;
        int right = N - 1;
        boolean isFind = false;
        
        while(left <= right) {
        	int mid = (left + right) / 2;
        	
        	if(arr[mid] > target) {
        		right = mid - 1;
        	}
        	else if(arr[mid] < target) {
        		left = mid + 1;
        	}
        	else {
        		isFind = true;
        		break;
        	}
        }
        
        return isFind;
    }
}