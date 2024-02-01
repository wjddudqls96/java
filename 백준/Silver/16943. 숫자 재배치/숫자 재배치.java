import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	private static int n, result;
	private static String A, B;
    private static int[] arr; // 원소를 저장할 배열
    private static boolean[] visited; // 중복을 제거하기 위한 방문 처리
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		
		A = st.nextToken();
		B = st.nextToken();
		
		n = A.length();
        arr = new int[n];
        visited = new boolean[n + 1];
        result = -1;
        permutation(0);
        
        System.out.println(result);
		
	}
	
	// 순열
    private static void permutation(int cnt) {
        if (cnt == n) {
            String str = "";
            
            for(int num : arr) {
            	str += A.charAt(num);
            }
            
            if(str.charAt(0) == '0') return;
            
            int value = Integer.parseInt(str);
            
            if(Integer.parseInt(B) > value) {
            	result = Math.max(result, value);
            }
            
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    }
}