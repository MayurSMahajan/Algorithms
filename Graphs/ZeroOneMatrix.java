// 542. 01 Matrix
// https://leetcode.com/problems/01-matrix/
// faster than 10% submissions, and 53% memory efficient


import java.util.*;

public class ZeroOneMatrix {
    public static void main(String[] args) {
        ZeroOneMatrixSolution z = new ZeroOneMatrixSolution();
        int[][] mat = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        int[][] mat2 = {
                {1,1,1},
                {1,1,1},
                {1,1,0}
        };
        mat = z.updateMatrix(mat);
        for (int[] tuple : mat){
            for (int el : tuple){
                System.out.print(el + " ");
            }
            System.out.println();
        }
        System.out.println();
        mat2 = z.updateMatrix(mat2);
        for (int[] tuple : mat2){
            for (int el : tuple){
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}

class ZeroOneMatrixSolution {
    public int[][] updateMatrix(int[][] mat) {
        int ROWS = mat.length;
        int COLS = mat[0].length;

        int[][] answer = new int[ROWS][COLS];
        Queue<List<Integer>> queue = new LinkedList<>();

        //populating answer
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                answer[i][j] = -1;
            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if(mat[i][j] == 0){
                    answer[i][j] = 0;
                    addCoordinatesToQueue(i,j, queue);
                }
            }
        }

        while(!queue.isEmpty()){
            int row = queue.peek().get(0);
            int col = queue.peek().get(1);

            if(doesExist(row+1, col, ROWS, COLS) && answer[row+1][col] == -1){
                addCoordinatesToQueue(row+1,col, queue);
                answer[row+1][col] = answer[row][col] + 1;
            }
            if(doesExist(row-1, col, ROWS, COLS) && answer[row-1][col] == -1){
                addCoordinatesToQueue(row-1,col, queue);
                answer[row-1][col] = answer[row][col] + 1;
            }
            if(doesExist(row, col+1, ROWS, COLS) && answer[row][col+1] == -1){
                addCoordinatesToQueue(row,col+1, queue);
                answer[row][col+1] = answer[row][col] + 1;
            }
            if(doesExist(row, col-1, ROWS, COLS) && answer[row][col-1] == -1){
                addCoordinatesToQueue(row,col-1, queue);
                answer[row][col-1] = answer[row][col] + 1;
            }
            queue.remove();
        }
        return answer;
    }

    boolean doesExist(int i, int j, int ROW, int COL){
        return i < ROW && j < COL && i >= 0 && j >= 0;
    }

    void addCoordinatesToQueue(int i, int j, Queue<List<Integer>> queue){
        List<Integer> coordinates = new ArrayList<>();
        coordinates.add(i);
        coordinates.add(j);
        queue.add(coordinates);
    }
}