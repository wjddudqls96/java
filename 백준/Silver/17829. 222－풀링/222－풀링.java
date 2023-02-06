import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	static int N;
	static int[][] map;
	static int result;
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(in.readLine());
    	
    	map = new int[N][N];
    	
    	for(int i = 0; i < N; i ++) {
    		String[] line = in.readLine().split(" ");
    		for(int j = 0; j < N; j++) {
    			map[i][j] = Integer.parseInt(line[j]);
    		}
    	}
    	
    	recursion(map, N);
    	
    	System.out.println(result);
    }
    
    private static void recursion(int[][] map, int size) {
    	
    	if(size == 1) {
    		result = map[0][0];
    		return;
    	}
    	
    	int[][] newMap = new int[size/2][size/2];
    	int x = 0;
    	int y = 0;
    	int newSize = size/(size/2);
    	
    	while(true) {
    		if(x == size) {
    			x = 0;
    			y += newSize;
    		}
    		
    		if(y == size) {
    			break;
    		}
    		
    		List<Integer> list = new ArrayList<>();
    		
    		for(int i = y; i < y + newSize; i++) {
        		for(int j = x; j < x + newSize; j++) {
        			list.add(map[i][j]);
        		}
        	}
    		
    		Collections.sort(list);
    		
    		newMap[y/newSize][x/newSize] = list.get(list.size() - 2);
    		x += newSize;
    	}
    	
    	
    	
    	recursion(newMap, size/2);
    	
    }
}

