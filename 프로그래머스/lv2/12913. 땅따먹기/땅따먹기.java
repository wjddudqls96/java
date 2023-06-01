import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] DP = new int[land.length][4];
        DP[0] = land[0];
        
        for(int i = 1; i < land.length; i++){
            DP[i][0] += land[i][0] + Math.max(Math.max(DP[i - 1][1], DP[i - 1][2]), DP[i - 1][3]);
            DP[i][1] += land[i][1] + Math.max(Math.max(DP[i - 1][0], DP[i - 1][2]), DP[i - 1][3]);
            DP[i][2] += land[i][2] + Math.max(Math.max(DP[i - 1][1], DP[i - 1][0]), DP[i - 1][3]);
            DP[i][3] += land[i][3] + Math.max(Math.max(DP[i - 1][1], DP[i - 1][2]), DP[i - 1][0]);
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < 4; i++){
            if(max < DP[land.length - 1][i]){
                max = DP[land.length - 1][i];
            }
        }
        
        return max;
    }
}