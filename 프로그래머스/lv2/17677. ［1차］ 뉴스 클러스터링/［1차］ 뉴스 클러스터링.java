import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
       
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        makeMap(str1, map1);
        makeMap(str2, map2);
        
        // System.out.println(map1);
        // System.out.println(map2);
        
        int interCnt = 0;
        int unionCnt = 0;
        
        List<String> list = new ArrayList<>(map1.keySet());
        
        for(String key : map1.keySet()){
             
            if(map2.containsKey(key)){
                int a = map1.get(key);
                int b = map2.get(key);
                
                interCnt += Math.min(a, b);
                unionCnt += Math.max(a, b);
            }
            else{
                unionCnt += map1.get(key);
            }
        }
        
        for(String key : map2.keySet()){
             
            if(!list.contains(key)){
                unionCnt += map2.get(key);
            }
        }
        
        // System.out.println(interCnt);
        // System.out.println(unionCnt);
        
        if(interCnt == 0 && unionCnt == 0){
            answer = 65536;
        }
        else{
            answer = (int) (((double) interCnt / (double) unionCnt) * (double) 65536 ) ;
        }
        
        return answer;
    }
    
    static void makeMap(String s, Map<String, Integer> map){
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = null;
        
        for(int i = 0; i < s.length() - 1; i++){
            String str = s.substring(i, i + 2).toUpperCase();
            matcher = pattern.matcher(str);
            
            if(matcher.find()){
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
    }
}