import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("./input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        st = new StringTokenizer(in.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0, j = 0;
        long result = 0; // 부분 배열의 총 수가 클 수 있으므로 long 타입 사용
        HashSet<Integer> set = new HashSet<>();

        while (i < N) {
            while (j < N && !set.contains(arr[j])) {
                set.add(arr[j]);
                j++;
            }

            result += (j - i); // j - i는 현재 i에서 시작하는 유효한 부분 배열의 개수
            set.remove(arr[i]); // i를 증가시키기 전에 현재 i의 원소를 제거
            i++;
        }

        System.out.println(result);
    }
}