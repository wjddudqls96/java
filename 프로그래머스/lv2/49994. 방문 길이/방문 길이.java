import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < dirs.length(); i++){
            char dir = dirs.charAt(i);
            
            int[] pos = goStep(x, y, dir, set);
            x = pos[0];
            y = pos[1];
        }
        
        return set.size();
    }
    
    static int[] goStep(int x, int y, char dir, Set<String> set){
        int[] pos = new int[2];
        pos[0] = x;
        pos[1] = y;
        String route = "";
        
        switch(dir){
            case 'U':
                if(isPossibleGo(x, y + 1)){
                    pos[0] = x;
                    pos[1] = y + 1;
                    route = getRoute(x, y, pos[0], pos[1]);
                    set.add(route);
                }
                break;
            case 'D':
                if(isPossibleGo(x, y - 1)){
                    pos[0] = x;
                    pos[1] = y - 1;
                    route = getRoute(x, y, pos[0], pos[1]);
                    set.add(route);
                }
                break;
            case 'R':
                if(isPossibleGo(x + 1, y)){
                    pos[0] = x + 1;
                    pos[1] = y;
                    route = getRoute(x, y, pos[0], pos[1]);
                    set.add(route);
                }
                break;
            case 'L':
                if(isPossibleGo(x - 1, y)){
                    pos[0] = x - 1;
                    pos[1] = y;
                    route = getRoute(x, y, pos[0], pos[1]);
                    set.add(route);
                }
                break;
        }
        
        return pos;
    }
    
    static String getRoute(int x1, int y1, int x2, int y2){
        return Math.max(x1, x2) + "" + Math.min(x1, x2) + "" + Math.max(y1, y2) + "" + Math.min(y1, y2);
    }
    
    static boolean isPossibleGo(int x, int y){
        if(x < -5 || x > 5 || y < -5 || y > 5) return false;
        return true;
    }
}