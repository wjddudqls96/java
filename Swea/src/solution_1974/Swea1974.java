package solution_1974;

import java.util.Scanner;

public class Swea1974 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) throws Exception{

        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[][] sudoku = new int[9][9];
            initSudoku(sudoku);
            System.out.println("#" + test_case + " " + parseResult((checkRaw(sudoku) && checkBox(sudoku) && checkColumn(sudoku))));
        }
    }
    static void initSudoku(int[][] sudoku){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                sudoku[i][j] = sc.nextInt();
            }
        }
    }

    static boolean checkRaw(int[][] sudoku){
        for (int i = 0; i < 9; i++){
            int sum = 0;

            for (int j = 0; j < 9; j++){
                sum += sudoku[i][j];
            }

            if (sum != 45){
                return false;
            }
        }
        return true;
    }

    static boolean checkBox(int[][] sudoku){
        for (int i = 0; i < 9; i += 3){
            for (int j = 0; j < 9; j += 3){
                int sum = 0;

                for (int x = 0; x < 3; x++){
                    for (int y = 0; y < 3; y++){
                        sum += sudoku[i+x][j+y];
                    }
                }

                if (sum != 45){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkColumn(int[][] sudoku){
        for (int i = 0; i < 9; i++){
            int sum = 0;

            for (int j = 0; j < 9; j++){
                sum += sudoku[j][i];
            }

            if (sum != 45){
                return false;
            }
        }
        return true;
    }

    static int parseResult(boolean result){
        if (result){
            return 1;
        }else{
            return 0;
        }
    }
}

