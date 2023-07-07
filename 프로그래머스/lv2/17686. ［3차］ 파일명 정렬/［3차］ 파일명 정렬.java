import java.util.*;

class File implements Comparable<File>{
    String head;
    String number;
    String tail;
    
    public File(String head, String number, String tail){
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
    
    @Override
    public int compareTo(File o1){
        if(this.head.toUpperCase().compareTo(o1.head.toUpperCase()) > 0){
            return 1;
        }
        else if(this.head.toUpperCase().compareTo(o1.head.toUpperCase()) < 0){
            return -1;
        }
        else{
            return Integer.parseInt(this.number) - Integer.parseInt(o1.number); 
        }
    }
}

class Solution {
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        
        for(String s : files){
            int startNumberIdx = -1;
            boolean first = true;
            int endNumberIdx = -1;
            int size = 0;
            
            for(int j = 0; j < s.length(); j++){
                if(Character.isDigit(s.charAt(j))){
                    if(first) {
                        startNumberIdx = j;
                        first = false;
                    }
                    size++;
                }else{
                    if(!first) break;
                }
            }
            
            endNumberIdx = startNumberIdx + size - 1;
            
            String head = s.substring(0, startNumberIdx);
            String number = s.substring(startNumberIdx, endNumberIdx+1);
            String tail = s.substring(endNumberIdx+1);
            
            list.add(new File(head, number, tail));
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            File f = list.get(i);
            String s = f.head + f.number + f.tail;
            answer[i] = s;
        }
        
        return answer;
    }
    
    public boolean isNumber(char c){
        return Character.isDigit(c);
    }
}