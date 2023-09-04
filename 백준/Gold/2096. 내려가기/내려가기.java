import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int N = Integer.parseInt(in.readLine());
    	int[][] arr = new int[N][3];
    	
    	for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(in.readLine());
        	
        	arr[i][0] = Integer.parseInt(st.nextToken());

        	arr[i][1] = Integer.parseInt(st.nextToken());

        	arr[i][2] = Integer.parseInt(st.nextToken());
    	}
    	
    	int[][] dpMax = new int[N][3];
    	int[][] dpMin = new int[N][3];
    	
    	dpMax[0][0] = dpMin[0][0] = arr[0][0];
    	dpMax[0][1] = dpMin[0][1] = arr[0][1];
    	dpMax[0][2] = dpMin[0][2] = arr[0][2];
    	
    	for(int i = 1; i < N; i++) {
    		dpMax[i][0] += arr[i][0] + Math.max(dpMax[i - 1][0], dpMax[i - 1][1]);
    		dpMin[i][0] += arr[i][0] + Math.min(dpMin[i - 1][0], dpMin[i - 1][1]);
    		
    		dpMax[i][1] += arr[i][1] + Math.max(Math.max(dpMax[i - 1][0], dpMax[i - 1][1]), dpMax[i - 1][2]);
    		dpMin[i][1] += arr[i][1] + Math.min(Math.min(dpMin[i - 1][0], dpMin[i - 1][1]), dpMin[i - 1][2]);
    		
    		dpMax[i][2] += arr[i][2] + Math.max(dpMax[i - 1][1], dpMax[i - 1][2]);
    		dpMin[i][2] += arr[i][2] + Math.min(dpMin[i - 1][1], dpMin[i - 1][2]);
    	}
    	
    	int max = Math.max(Math.max(dpMax[N - 1][0], dpMax[N - 1][1]), dpMax[N - 1][2]);
    	int min = Math.min(Math.min(dpMin[N - 1][0], dpMin[N - 1][1]), dpMin[N - 1][2]);
    	
    	System.out.println(max + " " + min);
    }
}