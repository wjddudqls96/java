import java.util.*;

class City implements Comparable<City>{
    String name;
    int cnt;
    
    public City(String name, int cnt){
        this.name = name;
        this.cnt = cnt;
    }
    
    @Override
    public int compareTo(City c1){
        return this.cnt - c1.cnt;
    }
    
    @Override
    public String toString(){
        return name + " " + cnt;
    }
}

class Solution {
    static LinkedList<City> cash;
    
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        int priorCnt = 0;
        
        cash = new LinkedList<>();
       
        for(int i = 0; i < cities.length; i++){
            String current = cities[i].toUpperCase();
            
            // cash 검사 기능 들어있는지 없는지.
            int index = getContainIndex(current);
            
            // 캐시에 있다면
            if(index >= 0){
                cash.get(index).cnt = ++priorCnt;
                time += 1;
            }
            // 캐시에 없다면.
            else{
                // 1-1. 큐가 꽉찼다면
                if(cacheSize != 0){
                    if(cash.size() == cacheSize){
                        cash.removeFirst();
                        cash.add(new City(current, ++priorCnt));
                    }
                    // 1-2. 아니라면
                    else{
                        cash.add(new City(current, ++priorCnt));
                    }
                }
                time += 5;
            }
            Collections.sort(cash);
        }
        
        
        return time;
    }
    
    static int getContainIndex(String name){
        for(int i = 0; i < cash.size(); i++){
                // 만약 캐시에 들어있다면
                if(cash.get(i).name.equals(name)){
                    return i;
                }
            }
        return -1;
    }
}