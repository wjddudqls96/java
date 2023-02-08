import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static int N, M;
    static boolean[][] visited;
    static int[][] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(in.readLine());
        
        for(int testCase = 1; testCase <= T; testCase++) {
        	sb.append("#"+testCase).append("\n");
            N = Integer.parseInt(in.readLine());
            result = new int[N][N];
            visited = new boolean[N][N];
            
            snail(result, 0, 0, 1, 1);
            
            for(int[] nums : result) {
                for(int num : nums) {
                	sb.append(num + " ");
                }
                sb.append("\n");
            }
        }
        
        System.out.println(sb);
        
    }
    static void snail(int[][] matrix, int y, int x, int count, int direction) {
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        
        if(count == N*N) {
            matrix[x][y] = count;
            return;
        }
        visited[x][y] = true;
        matrix[x][y] = count;
        
        if(direction == 1 && (y + 1 >= N  || visited[x][y+1])) {
            snail(matrix, y, x + 1, count + 1, 3);
        }
        else if(direction == 2 && (y -1 < 0 || visited[x][y-1])) {
            snail(matrix, y , x - 1, count + 1, 4);
        }
        else if(direction == 3 && (x + 1 >= N || visited[x+1][y])) {
            snail(matrix, y - 1, x, count + 1, 2);
        }
        else if(direction == 4 && (x - 1 < 0 || visited[x-1][y])){
            snail(matrix, y + 1, x, count + 1, 1);
        }
        else {
            int nextY = y + directions[direction - 1][0];
            int nextX = x + directions[direction - 1][1];
            snail(matrix, nextY, nextX, count + 1, direction);
        }
    }
}