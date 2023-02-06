import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
	static int N;
	static int[][] map;
	static int wCount;
	static int bCount;
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(in.readLine());
    	map = new int[N][N];
    	wCount = 0;
    	bCount = 0;
    	
    	for(int i = 0; i < N; i++) {
    		String[] line = in.readLine().split(" ");
    		for(int j = 0; j < N; j++) {
    			map[i][j] = Integer.parseInt(line[j]);
    		}
    	}
    	
    	
    	recursion(0, 0, N);
    	
    	System.out.println(wCount);
    	System.out.println(bCount);
    }
    
    private static void recursion(int x, int y, int size) {
    	int color = map[y][x];
    	boolean flag = true;
    	
    	for(int i = y; i < y + size; i++) {
    		for(int j = x; j < x + size; j++) {
    			if(map[i][j] != color) {
    				flag = false;
    			}
    		}
    	}
    	
    	
    	if(flag) {
    		if(color == 1) {
    			bCount++;
    		}
    		else {
    			wCount++;
    		}
    		return;
    	}
    	
    	int newSize = size/2;
    	
    	recursion(x, y, newSize);
    	recursion(x + newSize, y, newSize);
    	recursion(x, y + newSize, newSize);
    	recursion(x + newSize, y + newSize, newSize);
    }
}