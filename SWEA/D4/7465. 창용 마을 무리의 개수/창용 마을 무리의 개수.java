import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] deep;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> matrix;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        
        int T = Integer.parseInt(in.readLine());
        for(int t = 1; t <= T; t++) {
        	st = new StringTokenizer(in.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	
        	matrix = new ArrayList<>();
        	for(int i = 0; i <= N; i++) {
        		matrix.add(new ArrayList<>());
        	}
        	
        	visited = new boolean[N + 1];
        	
        	for(int i = 0; i < M; i++) {
        		st = new StringTokenizer(in.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		matrix.get(a).add(b);
        		matrix.get(b).add(a);
        	}
        	
        	int count = 0;
        	for(int i = 1; i <= N; i++) {
        		if(!visited[i]) {
        			count++;
        			dfs(i);        		
        		}
        	}
        	
        	sb.append("#" + t + " " + count).append("\n");
        }
        System.out.println(sb);
    }
    
    static void dfs(int index) {
    	if(visited[index]) {
    		return;
    	}
    	
    	ArrayList<Integer> list = matrix.get(index);
    	for(int i = 0; i < list.size(); i++) {
    		visited[index] = true;
    		dfs(list.get(i));
    	}
    }
}