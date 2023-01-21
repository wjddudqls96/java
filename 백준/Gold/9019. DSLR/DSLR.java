import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static String[] route;
	static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine());
        
        for(int testCase = 0; testCase < T; testCase++) {
        	String[] split = in.readLine().split(" ");
        	int A = Integer.parseInt(split[0]);
        	int B = Integer.parseInt(split[1]);
        	route = new String[10000];
        	visited = new boolean[10000];
        	
        	bfs(A, B);
        	System.out.println(route[B]);
        	
        }
        
        
    }

    static void bfs(int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        route[start] = "";
        while(!queue.isEmpty()) {
        	int number = queue.poll();
        	int nextNumber;
        	String command = "";
        	
        	for(int i = 0; i < 4; i++) {
        		if(i == 0) {
        			command = "D";
        			nextNumber = commandD(number);
        		}
        		else if(i == 1) {
        			command = "S";
        			nextNumber = commandS(number);
        		}
        		else if(i == 2) {
        			command = "L";
        			nextNumber = commandL(number);
        		}
        		else {
        			command = "R";
        			nextNumber = commandR(number);
        		}
        		if(nextNumber == goal) {
        			visited[nextNumber] = true;
        			route[nextNumber] = route[number] + command;
        			return;
        		}
        		else if(!visited[nextNumber]) {
        			visited[nextNumber] = true;
        			route[nextNumber] = route[number] + command;
        			queue.add(nextNumber);
        		}
        		
        	}
        	
        	
        	
        }
    }
    
    
    static int commandD(int num) {
    	int result = 2 * num;
    	
    	if(result > 9999) {
    		result = result % 10000;
    	}
    	return result;
    }
    
    static int commandS(int num) {
    	int result = num - 1;
    	
    	if(num == 0) {
    		result = 9999;
    	}
    	return result;
    }

    static int commandL(int num) {
    	StringBuffer strNum = new StringBuffer(Integer.toString(num));
    	if(strNum.length() < 4) {
    		while(strNum.length() < 4) {
    			strNum.insert(0, "0");
    		}
    	}
    	
    	String s = Character.toString(strNum.charAt(0));
    	strNum.append(s);
    	
    	return Integer.parseInt(strNum.substring(1));
    }

    static int commandR(int num) {
    	StringBuffer strNum = new StringBuffer(Integer.toString(num));
    	if(strNum.length() < 4) {
    		while(strNum.length() < 4) {
    			strNum.insert(0, "0");
    		}
    	}
    	
    	String s = Character.toString(strNum.charAt(strNum.length() - 1));
    	strNum.insert(0, s);
    	
    	return Integer.parseInt(strNum.substring(0, 4));
    	
    	
    }
    
    
}