import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < skill.length(); i++){
            map.put(skill.charAt(i), i + 1);
        }
        
        for(String skill_tree : skill_trees){
            boolean isPossible = true;
            int step = 1;
            for(int i = 0; i < skill_tree.length(); i++){
                char c = skill_tree.charAt(i);
                
                if(map.containsKey(c)){
                    if(step != map.get(c)){
                        isPossible = false;
                        break;
                    }
                    else{
                        step++;
                    }
                }
            }
            
            if(isPossible) answer++;
        }
        
        return answer;
    }
}