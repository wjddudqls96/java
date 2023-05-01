import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(i, computers, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(int start, int[][] computers, int n){
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
         
            for(int i = 0; i < n; i++){
                int next = computers[cur][i];
                
                if(visited[i] || next == 0) continue;
                
                visited[i] = true;
                queue.offer(i);
            }
        }
    }
}