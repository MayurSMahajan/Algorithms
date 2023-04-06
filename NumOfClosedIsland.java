// 1254. Number of Closed Islands
// https://leetcode.com/problems/number-of-closed-islands/
// 100% faster and 51% less memory

public class NumOfClosedIsland {
    public static void main(String[] args) {
        NumOfClosedIslandSolution n = new NumOfClosedIslandSolution();
        int[][] grid = {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };
        int[][] grid2 = {
                {0,0,1,1,0,1,0,0,1,0},
                {1,1,0,1,1,0,1,1,1,0},
                {1,0,1,1,1,0,0,1,1,0},
                {0,1,1,0,0,0,0,1,0,1},
                {0,0,0,0,0,0,1,1,1,0},
                {0,1,0,1,0,1,0,1,1,1},
                {1,0,1,0,1,1,0,0,0,1},
                {1,1,1,1,1,1,0,0,0,0},
                {1,1,1,0,0,1,0,1,0,1},
                {1,1,1,0,1,1,0,1,1,0},
        };
        System.out.println(n.closedIsland(grid));
        System.out.println(n.closedIsland(grid2));
    }
}

class NumOfClosedIslandSolution {
    public int closedIsland(int[][] grid) {
        int ans = 0;

        int ROWS = grid.length;
        int COLS = grid[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if(grid[i][j] == 0){
                    ans += dfs(i,j,grid);
                }
            }
        }

        return ans;
    }

    int dfs(int r, int c, int[][] grid){
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if(r == ROWS || c == COLS || r < 0 || c < 0) return 0;

        if(grid[r][c] != 0){
            return 1;
        }

        grid[r][c] = 1;

        return Math.min(Math.min(dfs(r+1, c, grid),dfs(r-1, c, grid)),Math.min(dfs(r, c+1, grid),dfs(r,c-1, grid)));
    }
}
