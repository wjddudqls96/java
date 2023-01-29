import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int count;
	static int[] arr;
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(in.readLine());
    	
    	arr = new int[N];
		
		dfs(0);
		System.out.println(count);
    }
    
public static void dfs(int depth) {
		
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i = 0 ; i < N; i++) {
			arr[depth] = i;
			if(possible(depth)) {
				dfs(depth+1);
			}
		}	
	}
	
	public static boolean possible(int col) {
		
		for(int i = 0 ; i < col ; i++) {
		//행에 일치하는게 있는지 판별
		if(arr[i]==arr[col]) {
			return false;
		}
		//대각선에 일치하는게 있는지 판별
		else if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])) {
			return false;
		}
			
		}
		
		return true;
	}
}