import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int crainSize = Integer.parseInt(br.readLine());
        List<Integer> crainWeights = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < crainSize; i++){
            crainWeights.add(Integer.parseInt(st.nextToken()));
        }

        int boxSize = Integer.parseInt(br.readLine());
        List<Integer> boxWeights = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < boxSize; i++){
            boxWeights.add(Integer.parseInt(st.nextToken()));
        }

        crainWeights.sort((o1, o2) -> o2 - o1);
        boxWeights.sort((o1, o2) -> o2 - o1);

        if(boxWeights.get(0) > crainWeights.get(0)) {
            System.out.println(-1);
            return;
        }

        int result = 0;

        while(!boxWeights.isEmpty()){
            int idx = 0;

            for(int i = 0; i < crainSize; ){
                int currentCrain = crainWeights.get(i);

                if(idx == boxWeights.size()) break;

                // 현재 크래인의 무개가 가장 큰 박스보다 크다면
                if(currentCrain >= boxWeights.get(idx)){
                    i++;
                    boxWeights.remove(idx);
                }
                else{
                    idx++;
                }
            }
            result++;
        }

        System.out.print(result);
    }
}