import java.util.*;

class Solution {
    static int[][] matrix;
    static int min = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        matrix = new int[n + 1][n +1];
        
        for(int i = 0; i < wires.length; i++){
            int[] wire = wires[i];
            matrix[wire[0]][wire[1]] = 1;
            matrix[wire[1]][wire[0]] = 1;
        }
        
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            int[][] temp = copyMatrix(n);
            temp[a][b] = 0;
            temp[b][a] = 0;
            
            int cntA = bfs(a, n, temp);
            int cntB = bfs(b, n, temp);
            
            if(min > Math.abs(cntA - cntB)){
                min = Math.abs(cntA - cntB);
            }
        }
        
        return min;
    }
    
    static int[][] copyMatrix(int n){
        int[][] temp = new int[n + 1][n + 1];
        
        for(int i = 0; i < matrix.length; i++){
            temp[i] = Arrays.copyOf(matrix[i], n + 1);
        }
        
        return temp;
    }
    
    static int bfs(int start, int n, int[][] temp){
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(start);
        visited[start] = true;
        
        int cnt = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            cnt++;
            
            for(int i = 0; i <= n; i++){
                if(visited[i] || temp[cur][i] == 0) continue;
        
                queue.offer(i);
                visited[i] = true;
            }
        }
        
        return cnt;
    }
}