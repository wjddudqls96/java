import java.util.*;

class Solution {
    static boolean[] visited;
    static int[] input;
    static int max = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        input = new int[dungeons.length];
        
        permutation(0, dungeons, k);
        
        return max;
    }
    
    
    static void permutation(int cnt, int[][] dungeons, int k){
        if(cnt == dungeons.length){
            int count = 0;
            
            for(int i=0; i<input.length; i++) { // 1
                if(k>=dungeons[input[i]][0]) {
                    k-=dungeons[input[i]][1];
                    count++;
                }
                else break;
            }
            
            if(max < count){
                max = count;
            }
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            input[cnt] = i;
            permutation(cnt + 1, dungeons, k);
            visited[i] = false;
        }
    }
}