import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static int[][] DP;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        // init
        N = Integer.parseInt(in.readLine());
        arr = new int[N + 1];
        
        st = new StringTokenizer(in.readLine());
        
        for(int i = 1; i <= N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        M = Integer.parseInt(in.readLine());
        DP = new int[N +1][N + 1];
        
        
        // 펠린드롬 인지 확인하는 메서드 만들기
        Palin();
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(in.readLine());
        	int S = Integer.parseInt(st.nextToken());
        	int E = Integer.parseInt(st.nextToken());
        	
        	sb.append(DP[S][E]).append("\n");
        }
        
        System.out.println(sb);
    }
    
    static void Palin() {
    	for(int i = 1; i <= N; i++) {
    		DP[i][i] = 1;
    	}
    	
    	for(int i = 1; i <= N - 1; i++) {
    		if(arr[i] == arr[i + 1]) {
    			DP[i][i + 1] = 1;
    		}
    	}
    	
    	// 마지막 위치
    	for(int i = 2; i < N; i++) {
    		// 시작 위치
    		for(int j = 1; j <= N - i; j++) {
    			if(arr[j] == arr[j + i] && DP[j + 1][j + i - 1] == 1) {
    				DP[j][j + i] = 1;
    			}
    		}
    	}
    }
    
}