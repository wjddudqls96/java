import java.util.*;

class BookTime implements Comparable<BookTime>{
    int startTime;
    int endTime;
    
    BookTime(String sT, String eT){
        this.startTime = splitTime(sT);
        this.endTime = splitTime(eT);
    }
    
    int splitTime(String str){
        String[] split = str.split(":");
        int time = Integer.parseInt(split[0]) * 60 
            + Integer.parseInt(split[1]);
        
        return time;
    }
    
    @Override
    public int compareTo(BookTime o1){
        return this.startTime - o1.startTime;
    }
    
    @Override
    public String toString(){
        return this.startTime + " " + this.endTime;
    }
}

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        List<BookTime> list = new ArrayList<>();
        for(int i = 0; i < book_time.length; i++){
            list.add(new BookTime(book_time[i][0], book_time[i][1]));
        }
        
        Collections.sort(list);
        List<Integer> rooms = new ArrayList<>();
        
        for(int i = 0; i < list.size(); i++){
            BookTime bt = list.get(i);
            
            if(rooms.size() == 0){
                rooms.add(bt.endTime);
            }
            else{
                boolean flag = false;
                for(int j = 0; j < rooms.size(); j++){
                    if(rooms.get(j) + 10 <= bt.startTime){
                        rooms.set(j, bt.endTime);
                        flag = true;
                        break;
                    }
                }
                
                if(!flag){
                    rooms.add(bt.endTime);
                }
            }
        }
        return rooms.size();
    }
}