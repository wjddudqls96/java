import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pos{
    int x;
    int y;
    
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] map;
    static ArrayList<Pos> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
       
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        map = new int[9][9];
        
        for(int i = 0; i < 9; i++) {
            String line = in.readLine();
            for(int j = 0; j < 9; j++) {
                int num = line.charAt(j) - '0';
                if(num == 0) {
                    list.add(new Pos(j, i));
                }
                map[i][j] = num;
            }
        }
        
        dfs(0);
    }
    
    static void dfs(int index) {
    	
    	if(index == list.size()) {
    		
        	for(int[] m : map) {
        		for(int num : m) {
        			sb.append(num);
        		}
        		sb.append("\n");
        	}
        	System.out.println(sb);
        	System.exit(0);
    	}
        
        Pos cur = list.get(index);
        
        boolean[] arr1 = blockCheck(cur);
        
        boolean[] arr2 = rowCheck(cur);
        
        boolean[] arr3 = colCheck(cur);
        ArrayList<Integer> possible = getPossibleArr(arr1, arr2, arr3);
        

        for(int i = 0; i < possible.size(); i++) {
        	map[cur.y][cur.x] = possible.get(i);
        	dfs(index + 1);
    		map[cur.y][cur.x] = 0;
        } 
    }
    
    static ArrayList<Integer> getPossibleArr(boolean[] arr1, boolean[] arr2, boolean[] arr3) {
        boolean[] arr = new boolean[9];
        
        for(int i = 0; i < 9; i++) {
            if(arr1[i]) {
                arr[i] = true;
            }
            if(arr2[i]) {
                arr[i] = true;
               
            }
            if(arr3[i]) {
                arr[i] = true;
            }
        }
        ArrayList<Integer> possible = new ArrayList<>();
        
        for(int i = 0; i < 9; i++) {
            if(!arr[i]) {
                possible.add(i + 1);
            }
        }
       
        
        return possible;
    }
    
    
    static boolean[] blockCheck(Pos pos) {
        int position = getPosition(pos) - 1;
        int startX = (position % 3) * 3;
        int startY = (position / 3) * 3;
        
        boolean[] arr = new boolean[9];
        for(int i = startY; i < startY + 3; i++) {
            for(int j = startX; j < startX + 3; j++) {
                if(map[i][j] != 0) {
                    arr[map[i][j] - 1] = true;
                }
            }
        }
        
        return arr;
    }
    
    static boolean[] rowCheck(Pos pos) {
        boolean[] arr = new boolean[9];
        int y = pos.y;
        
        for(int i = 0; i < 9; i++) {
            if(map[y][i] != 0) {
                arr[map[y][i] - 1] = true;
            }
        }
        
        return arr;
    }
    
    static boolean[] colCheck(Pos pos) {
        boolean[] arr = new boolean[9];
        int x = pos.x;
        
        for(int i = 0; i < 9; i++) {
            if(map[i][x] != 0) {
                arr[map[i][x] - 1] = true;
            }
        }
        
        return arr;
    }
    
    static int getPosition(Pos pos) {
        int x = pos.x;
        int y = pos.y;
        
        if(3 > x) {
            if(3 > y) {
                return 1;
            }
            if(6 > y) {
                return 4;
            }
            if(9 > y) {
                return 7;
            }
        }
        else if(6 > x) {
            if(3 > y) {
                return 2;
            }
            if(6 > y) {
                return 5;
            }
            if(9 > y) {
                return 8;
            }
        }
        else if(9 > x) {
            if(3 > y) {
                return 3;
            }
            if(6 > y) {
                return 6;
            }
            if(9 > y) {
                return 9;
            }
        }
        
        return -1;
    }
}