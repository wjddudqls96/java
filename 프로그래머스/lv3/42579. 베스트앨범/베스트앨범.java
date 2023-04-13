import java.util.*;
class Song implements Comparable<Song>{
    int num;
    int playCount;
    
    public Song(int num, int playCount){
        this.num = num;
        this.playCount = playCount;
    }
    
    @Override
    public String toString(){
        return this.num + " " + this.playCount;
    }
    
    @Override
    public int compareTo(Song o1){
        return o1.playCount - this.playCount;
    }
}

class Solution {
    static HashMap<String, Integer> tmap;
    static HashMap<String, List<Song>> map;
    public int[] solution(String[] genres, int[] plays) {
        int size = genres.length;
        map = new HashMap<>();
        tmap = new HashMap<>();
        for(int i = 0; i < size; i++){
            // 장르가 있다면
            if(map.containsKey(genres[i])){
                List<Song> list = map.get(genres[i]);
                list.add(new Song(i, plays[i]));
                
                map.put(genres[i], list);
                tmap.put(genres[i], tmap.get(genres[i]) + plays[i]);
            }
            // 없다면
            else{
                List<Song> list = new LinkedList<>();
                list.add(new Song(i, plays[i]));
                
                map.put(genres[i], list);
                tmap.put(genres[i], plays[i]);
            }
        }
        
        // System.out.println(map);
        // System.out.println(tmap);
        
        List<String> keys = new ArrayList<>(tmap.keySet());
        Collections.sort(keys, (o1, o2) -> tmap.get(o2) - tmap.get(o1));
        
        ArrayList<Integer> results = new ArrayList<>();
        for(String key : keys){
            List<Song> songs = map.get(key);
            Collections.sort(songs);
            
            for(int i = 0; i < songs.size(); i++){
                if(i == 2) break;
                results.add(songs.get(i).num);
            }
        }
        
        int[] answer = new int[results.size()];
        for(int i = 0; i < results.size(); i++){
            answer[i] = results.get(i);
        }
        
        
        
        return answer;
    }
}