import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] arr = new int[n][n];
        
        int x = 0;
        int y = -1;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                
                if(i % 3 == 0){
                    y++;
                }
                else if(i % 3 == 1){
                    x++;
                }
                else if(i % 3 == 2){
                    x--;
                    y--;
                }
                
                arr[y][x] = ++count;
            }
        }
        
        int index = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] != 0){
                    answer[index++] = arr[i][j];
                }
            }
        }
        return answer;
    }
}