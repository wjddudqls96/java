import java.util.*;

class Solution {
    static String[] arr = {"A", "E", "I", "O", "U"};
    static List<String> dic = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        dfs("");
        Collections.sort(dic);
        
        return dic.indexOf(word);
    }
    
    
    static void dfs(String str){
        dic.add(str);

        if(str.length() == 5) return;
        
        for(int i = 0; i < arr.length; i++){
            dfs(str + arr[i]);
        }
    }
}