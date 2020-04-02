package CodeTest;

// 查询从1到2所走过的路径，
/**
 *  UniquePath 980
 *
 *  Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 *     Output: 2
 *     Explanation: We have the following two paths:
 *             1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 *             2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 */
public class UniquePath {

    // 不要忘记这个是1
    static int empty = 1;
    static int res = 0;
    static int sx;
    static int sy;
    static int ex;
    static int ey;

    public static int getUniquePath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 初始化阶段所做的三件事情
                // 1 初始化empty, 用于记录是否走完0代表的格子；
                // 2 初始化起始点
                // 3 初始化终点
                if (grid[i][j] == 0) empty++;
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }
            }
        }

        dfs(grid, sx, sy);
        return res;
    }

    private static void dfs(int[][] grid, int x, int y) {
        // 边界条件不要忘记 x >= grid.length,  不要忘记 = 的情况
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) {
            return;
        }

        if (ex == x && ey == y) {
            if (empty == 0) res++;
            return;
        }

        grid[x][y] = -1;
        empty--;
        dfs(grid, x + 1, y);
        dfs(grid, x-1, y);
        dfs(grid, x, y+1);
        dfs(grid, x, y-1);
        grid[x][y] = 0;
        empty++;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};

        System.out.println(getUniquePath(grid));
    }

}
