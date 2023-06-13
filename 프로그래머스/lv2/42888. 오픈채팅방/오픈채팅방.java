import java.util.*;

class Solution {
    static final String ENTER_COMMAND = "님이 들어왔습니다.";
    static final String LEAVE_COMMAND = "님이 나갔습니다.";
    
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        for(String log : record){
            String[] split = log.split(" ");
            
            if(split[0].equals("Change")){
                map.put(split[1], split[2]);
            }
            else if(split[0].equals("Enter")){
                map.put(split[1], split[2]);
            }
        }
        
        for(String log : record){
            String[] split = log.split(" ");
            String command = generateCommand(split, map);
            
            if(command.length() != 0){
                result.add(command);
            }
        }
        
        String[] answer = new String[result.size()];
        
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    static String generateCommand(String[] split, Map<String, String> map){
        String str = "";
        
        switch(split[0]){
            case "Enter" :
                str = map.get(split[1]) + ENTER_COMMAND;
                break;
            case "Leave" :
                str = map.get(split[1]) + LEAVE_COMMAND;
                break;
        }
        
        return str;
    }
}