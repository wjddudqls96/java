import java.util.*;

class Solution {
    Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        
        List<String> courses = new ArrayList<>();
        
        for(int i = 0; i < orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        for(int c : course){
            map = new HashMap<>();
            for(int i = 0; i < orders.length; i++){
                if(orders[i].length() >= c){
                    boolean[] visited = new boolean[orders[i].length()];
                    combination(orders[i], visited, 0, orders[i].length(), c);
                }
            }
        
            
            if(!map.isEmpty()){
                int max = Collections.max(new ArrayList<>(map.values()));
                
                if(max > 1){
                    for(String key : map.keySet()){
                        if(map.get(key) == max){
                            courses.add(key);
                        }
                    }
                }
            }
        }
        
        Collections.sort(courses);
        
        String[] answer = new String[courses.size()];
        
        for(int i = 0; i < courses.size(); i++){
            answer[i] = courses.get(i);
        }
    
        return answer;
    }
    
    public void combination(String order, boolean[] visited, int depth, int n, int r){
        if(r == 0){
            String str = "";
            
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    str += order.charAt(i);
                }
            }
            
            if(str.length() > 0){
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            return;
        }
        
        if (depth == n) {
            return;
        }

        visited[depth] = true;
        combination(order, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        combination(order, visited, depth + 1, n, r);
    }
}