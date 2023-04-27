import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < phone_book.length; i++){
            map.put(phone_book[i], i);
        }
        
        for(int i = 0; i < phone_book.length; i++){
            String str = phone_book[i];
            for(int j = 1; j < str.length(); j++){
                String sub = str.substring(0, j);
                // map에 있는지 확인한다.
                if(map.containsKey(sub)){
                    return false;
                }
            }
        }

        return true;
    }
}