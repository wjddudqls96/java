import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr, nums;
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("./input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        
        st = new StringTokenizer(in.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(in.readLine());
        
        arr = new int[N];
        select = new boolean[N];
        
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        nums = new int[M];
        
        permutation(0);
        
        System.out.println(sb);
    }
    
    static void permutation(int cnt) {
    	if(cnt == M) {
    		for(int num : nums) {
    			sb.append(num + " ");
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	for(int i = 0; i < N; i++) {
    		if(!select[i]) {
    			select[i] = true;
    			nums[cnt] = arr[i];
    			permutation(cnt + 1);
    			select[i] = false;
    		}
    	}
    }
}