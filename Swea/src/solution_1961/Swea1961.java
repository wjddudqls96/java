package solution_1961;

import java.util.ArrayList;
import java.util.Scanner;

public class Swea1961 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) throws Exception
    {

        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[][] arr = init(n);

            ArrayList<String> arrayList90 = rotation90(arr, n);
            ArrayList<String> arrayList180 = rotation180(arr, n);
            ArrayList<String> arrayList270 = rotation270(arr, n);

            System.out.println("#"+test_case);
            for (int i = 0; i < n; i++){
                System.out.println(arrayList90.get(i) + " " + arrayList180.get(i) + " " + arrayList270.get(i));
            }

        }
    }

    static int[][] init(int n){
        int[][] newArr = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                newArr[i][j] = sc.nextInt();

        return newArr;
    }

    static ArrayList<String> rotation90(int[][] arr, int size){
        ArrayList<String> arrayList90 = new ArrayList<>();

        for (int i = 0; i < size; i++){
            String str = "";
            for (int j = size - 1; j >= 0; j--){
                str += (Integer.toString(arr[j][i]));
            }
            arrayList90.add(str);
        }

        return arrayList90;
    }

    static ArrayList<String> rotation180(int[][] arr, int size){
        ArrayList<String> arrayList180 = new ArrayList<>();

        for (int i = size - 1; i >= 0; i--){
            String str = "";
            for (int j = size - 1; j >= 0; j--){
                str += (Integer.toString(arr[i][j]));
            }
            arrayList180.add(str);
        }
        return arrayList180;
    }

    static ArrayList<String> rotation270(int[][] arr, int size){
        ArrayList<String> arrayList270 = new ArrayList<>();

        for (int i = size - 1; i >= 0; i--){
            String str = "";
            for (int j = 0; j < size; j++){
                str += (Integer.toString(arr[j][i]));
            }
            arrayList270.add(str);
        }
        return arrayList270;
    }
}
