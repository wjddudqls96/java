import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        
        N = Integer.parseInt(in.readLine());
        
        map = new int[N][N];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(in.readLine());
        	for(int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int k = 0; k < N; k++) {
        	for(int i = 0; i < N; i++) {
        		for(int j = 0; j < N; j++) {
        			if(map[i][k] == 1 && map[k][j] == 1) {
        				map[i][j] = 1;
        			}
        		}
        	}
        }
        
        for(int[] nums : map) {
        	for(int num : nums) {
        		System.out.print(num + " ");
        	}
        	System.out.println();
        }
    }
}