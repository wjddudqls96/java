import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
	static int N;
	static int[][] map;
	static int wCount, bCount, cCount;
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(in.readLine());
    	map = new int[N][N];
    	wCount = 0;
    	bCount = 0;
    	cCount = 0;
    	
    	for(int i = 0; i < N; i++) {
    		String[] line = in.readLine().split(" ");
    		for(int j = 0; j < N; j++) {
    			map[i][j] = Integer.parseInt(line[j]);
    		}
    	}
    	
    	
    	recursion(0, 0, N);
    	
    	
    	System.out.println(cCount);
    	System.out.println(wCount);
    	System.out.println(bCount);
    }
    
    private static void recursion(int x, int y, int size) {
    	int color = map[y][x];
    	boolean flag = true;
    	for(int i = y; i < y + size; i++) {
    		for(int j = x; j < x + size; j++) {
    			if(color != map[i][j]) {
    				flag = false;
    			}
    		}
    	}
    	
    	if(flag) {
    		if(color == 0) {
    			wCount++;
    		}
    		else if(color == 1) {
    			bCount++;
    		}
    		else if(color == -1) {
    			cCount++;
    		}
    		return;
    	}
    	
    	int newSize = size / 3;
    	recursion(x, y, newSize); // 1
    	recursion(x + newSize, y, newSize); // 2
    	recursion(x + 2*newSize, y, newSize); // 3
    	recursion(x, y + newSize, newSize); // 4
    	recursion(x + newSize, y + newSize, newSize); // 5
    	recursion(x + 2*newSize, y + newSize, newSize); // 6
    	recursion(x, y + 2*newSize, newSize); // 4
    	recursion(x + newSize, y + 2*newSize, newSize); // 5
    	recursion(x + 2*newSize, y + 2*newSize, newSize); // 6
    	
    }
}