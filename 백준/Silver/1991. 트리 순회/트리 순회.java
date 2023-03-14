import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, max, maxIndex;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adjList;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(in.readLine());
       
        adjList = new ArrayList<>();
        
        
        for(int i = 0; i < 30; i++) {
        	adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(in.readLine());
        	int index = st.nextToken().charAt(0) - 'A';
        	for(int j = 0; j < 2; j++) {
        		char c = st.nextToken().charAt(0);
        		
        		if(c == '.') {
        			adjList.get(index).add(-1);
        		}
        		else {
        			adjList.get(index).add(c - 'A');
        		}
        		
        	}
        }
        
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }
    
    static void preOrder(int index) {
    	if(adjList.get(index).isEmpty()) {
    		return;
    	}
    	
    	
    	ArrayList<Integer> list = adjList.get(index);
    	
    	System.out.print((char)(index + (int) 'A'));
    	
    	if(list.get(0) != -1) {
    		preOrder(list.get(0));
    	}
    	
    	if(list.get(1) != -1) {
    		preOrder(list.get(1));
    	}
    }
    
    static void inOrder(int index) {
    	if(adjList.get(index).isEmpty()) {
    		return;
    	}
    	
    	
    	ArrayList<Integer> list = adjList.get(index);
    	
    	
    	
    	if(list.get(0) != -1) {
    		inOrder(list.get(0));
    	}
    	
    	System.out.print((char)(index + (int) 'A'));
    	
    	if(list.get(1) != -1) {
    		inOrder(list.get(1));
    	}
    }
    
    static void postOrder(int index) {
    	if(adjList.get(index).isEmpty()) {
    		return;
    	}
    	
    	
    	ArrayList<Integer> list = adjList.get(index);
    	
    	
    	
    	if(list.get(0) != -1) {
    		postOrder(list.get(0));
    	}
    	
    	if(list.get(1) != -1) {
    		postOrder(list.get(1));
    	}
    	
    	System.out.print((char)(index + (int) 'A'));
    }
   
}