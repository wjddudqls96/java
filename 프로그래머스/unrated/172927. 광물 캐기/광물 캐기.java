import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int size = minerals.length / 5;
        int pickCnt = 0;
        
        if(minerals.length % 5 != 0) size++;
        
        for(int pick : picks){
            pickCnt += pick;
        }
        
        int diamond = 0;
        int iron = 0;
        int stone = 0;
        
        int[][] cases = new int[size][3];
        int index = 0;
        for(int i = 0; i < minerals.length; i++){
            switch(minerals[i]){
                case "diamond":
                    diamond++;
                    break;
                case "iron":
                    iron++;
                    break;
                case "stone":
                    stone++;
                    break;
            }
            
            if(((i != 0 && (i + 1) % 5 == 0) || (i == minerals.length - 1)) && pickCnt > index){
                cases[index][0] = diamond + iron + stone;
                cases[index][1] = diamond * 5 + iron + stone;
                cases[index][2] = diamond * 25 + iron * 5 + stone;
                
                diamond = 0;
                iron = 0;
                stone = 0;
                index++;
            }
        }
        
        Arrays.sort(cases, (o1, o2) -> {
            return o2[2] - o1[2];
        });
        
        for(int i = 0; i < cases.length; i++){
            if(picks[0] != 0){
                answer += cases[i][0];
                picks[0]--;
            }
            else if(picks[1] != 0){
                answer += cases[i][1];
                picks[1]--;
            }
            else if(picks[2] != 0){
                answer += cases[i][2];
                picks[2]--;
            }
        }
        
        for(int[] c : cases){
            System.out.println(Arrays.toString(c));
        }
        
        return answer;
    }
}