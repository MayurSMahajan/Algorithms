// 1020. Number of Enclaves
// https://leetcode.com/problems/number-of-enclaves/
// 99% faster and 56% memory efficient

public class NumOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        int[][] grid2 = {
                {0,1,1,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,0}
        };
        int[][] grid3 = {
                {0,0,0,1,1,1,0,1,0,0},
                {1,1,0,0,0,1,0,1,1,1},
                {0,0,0,1,1,1,0,1,0,0},
                {0,1,1,0,0,0,1,0,1,0},
                {0,1,1,1,1,1,0,0,1,0},
                {0,0,1,0,1,1,1,1,0,1},
                {0,1,1,0,0,0,1,1,1,1},
                {0,0,1,0,0,1,0,1,0,1},
                {1,0,1,0,1,1,0,0,0,0},
                {0,0,0,0,1,1,0,0,0,1},
        };
        NumOfEnclavesSolution nos = new NumOfEnclavesSolution();
        System.out.println(nos.numEnclaves(grid));
        System.out.println(nos.numEnclaves(grid2));
        System.out.println(nos.numEnclaves(grid3));
    }
}

class NumOfEnclavesSolution {
    public int numEnclaves(int[][] grid) {
        int ans=0;
        int ROWS = grid.length;
        int COLS = grid[0].length;

        //run a dfs on the perimeter of the grid
        for (int j = 0; j < COLS; j++) {
            if(grid[0][j] == 1){
                dfs(0,j,grid);
            }
        }

        for (int i = 0; i < ROWS; i++) {
            if(grid[i][0] == 1){
                dfs(i,0,grid);
            }
        }

        for (int j = 0; j < COLS; j++) {
            if(grid[ROWS - 1][j] == 1){
                dfs(ROWS - 1,j,grid);
            }
        }

        for (int i = 1; i < ROWS; i++) {
            if(grid[i][COLS - 1] == 1){
                dfs(i,COLS - 1,grid);
            }
        }


        for (int i = 1; i < ROWS-1; i++) {
            for (int j = 1; j < COLS-1; j++) {
                ans+=grid[i][j];
            }
        }
        return ans;
    }

    void dfs(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if(grid[i][j] == 0) return;
        grid[i][j] = 0;
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
    }
}
