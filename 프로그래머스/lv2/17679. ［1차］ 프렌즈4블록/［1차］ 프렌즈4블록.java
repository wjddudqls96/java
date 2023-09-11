import java.util.*;

class Solution {
    char[][] map;
    int mSize, nSize;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        map = new char[m][n];
        mSize = m;
        nSize = n;
        
        for(int i = 0; i < m; i++){
            String str = board[i];
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j);
            }
        }
        
        boolean flag = true;
        
        while(flag) {
             // 1. 돌면서 사각형이면 체크해준다.
            boolean[][] checked = new boolean[m][n];
            int sum = 0;

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    sum += checkMap(checked, j, i);
                }
            }

            if(sum == 0) break;

            // for(boolean[] c : checked){
            //     System.out.println(Arrays.toString(c));
            // }

            // 2. 사각형만큼 map에서 지워준다
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(checked[i][j]){
                        answer++;
                        map[i][j] = '.';
                    }
                }
            }

            // 3. 내려 보낸다.
            drop();
        }
        
       
        
        return answer;
    }
    
    public int checkMap(boolean[][] checked, int x, int y){
        int[][] dir = {{0, 0}, {1, 0}, {0, 1}, {1, 1}};
        
        char cur = map[y][x];
        
        for(int i = 0; i < 4; i++){
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            
            if(nextX < 0 || nextX >= nSize || nextY < 0 || nextY >= mSize) return 0;
            
            if(map[nextY][nextX] == '.') return 0;
            
            if(map[nextY][nextX] != cur) return 0;
        }
        
        for(int i = 0; i < 4; i++){
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            
            if(checked[nextY][nextX]) continue;
            
            checked[nextY][nextX] = true;
        }
        
        return 1;
    }
    
    public void drop(){
        // 가장 밑 행부터 탐색
        for (int i = mSize - 1; i >= 0; i--) {
            for (int j = 0; j < nSize; j++) {
                // 탐색하다 ""을 만나면 같은열의 이전 행의 값을 가져오기
                if (map[i][j] == '.') {
                    for (int k = i; k >= 0; k--) {
                        if (map[k][j] != '.') {
                            map[i][j] = map[k][j];
                            map[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}