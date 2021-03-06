package leetcode.oneMoreHundred;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Date: 2020年8月11日
 * ==============================================================================
 * 695. 岛屿的最大面积
 * ==============================================================================
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 * 示例 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 * ==============================================================================
 * 200. 岛屿数量
 * ==============================================================================
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * ==============================================================================
 * 463 岛屿的周长
 * ==============================================================================
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * ==============================================================================
 * 827 最大的人工岛
 * ==============================================================================
 * TODO
 * ==============================================================================
 */
public class Day015 {


    public static void main(String[] args) {
        int[][] test =
                {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int[][] test1 = {
                        {1,1,0,0,0},
                        {1,1,0,0,0},
                        {0,0,0,1,1},
                        {0,0,0,1,1}};

        System.out.println(maxAreaOfIsland2(test));
        System.out.println(maxAreaOfIsland2(test1));


        // 搜索岛屿数量
        char[][] chars = {
                            {'1','1','1','1','0'},
                            {'1','1','0','1','0'},
                            {'1','1','0','0','0'},
                            {'0','0','0','0','0'}};


        char[][] chars2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        char[][] ccc  = {{'1','1'},{'1','0'}};

        System.out.println(numIslands(chars));
        System.out.println(numIslands(chars2));

        // 岛屿的周长
        int[][] singleIsland = {{1,1,0,0},
                                {1,1,1,1},
                                {0,1,0,0},
                                {1,1,0,0}};
//        System.out.println(islandPerimeter(singleIsland));
        System.out.println(islandPerimeter3(singleIsland));
    }

    /**
     * @Title:  695. 岛屿的最大面积
     * @Version：版本1 深度优先实现
     *
     * 遍历网格中的每一个元素,若元素自身不为0 则对元素上下左右进行递归遍历
     * 返回 1 + 上下左右 元素返回值的和;
     *
     * 注意：为了避免重复计算,需要在遍历到的某个元素时将该元素从1 置为 0; 由于在遍历完该元素后最大值已被保存,
     * 因此即便改变网格中的值也不影响结果
     *
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                maxArea = Math.max(maxArea,dfs(grid,i,j));
            }
        }
        return maxArea;
    }

    /**
     * 深度优先搜索出下标为 i,j 的元素所在的岛屿的面积
     * @param grid
     * @param i
     * @param j
     * @return
     */
    public static int dfs(int[][] grid , int i ,int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int up = i-1, down = i+1;
        int left = j-1, right = j+1;
        int res = 1 + dfs(grid,up,j) + dfs(grid, down, j) + dfs(grid, i, left) + dfs(grid, i, right);
        return res;
    }


    /**
     * @Title:  695. 岛屿的最大面积
     * @Version: 版本2 广度优先搜索实现
     *
     * 解法类似深度优先搜索,不同的地方在于找出每个岛屿的面试时，改为使用循环实现
     *
     *
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland2(int[][] grid){
        int maxArea = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                maxArea = Math.max(maxArea,bfs(grid,i,j));
            }
        }
        return maxArea;
    }


    /**
     * 广度优先搜索
     * 使用队列保存值为1的网格的前后左右的非0元素
     * 完了之后每次出队一个元素再次将出队元素前后左右的非零元素入队,
     * 这样当队列中元素为空时，岛屿的面积也就遍历完了
     * 岛屿面积 = 1 + 所有出队元素网格值
     *
     * 为避免重复计算,在统计完出队元素后需要将网格值设置为 0
     *
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private static int bfs(int[][] grid, int i, int j){
        if(grid[i][j] == 0) return 0;
        Deque<Integer> rQueue = new LinkedList<>(),cQueue = new LinkedList<>();
        rQueue.offer(i); cQueue.offer(j);

        int c,r,area = 0;
        while(!rQueue.isEmpty()){
            r = rQueue.poll();
            c = cQueue.poll();
            if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
                continue;
            }
            area += 1;
            grid[r][c] = 0;
            addSurroundings(rQueue,cQueue,r,c);
        }
        return area;
    }

    private static void addSurroundings(Deque<Integer> rQueue, Deque<Integer> cQueue, Integer r, Integer c) {
        int[] rs = {1,-1,0,0};
        int[] cs = {0,0,1,-1};
        for(int i = 0; i < rs.length ;i++){
            rQueue.add(r+rs[i]);
            cQueue.add(c+cs[i]);
        }
    }


    /**
     * @Title: 200. 岛屿数量
     * @Version: 深度优先搜索
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int num = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    num += dfsCountIslands(grid,i,j);
                }
            }
        }
        return num;
    }


    private static int dfsCountIslands(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return 0;
        }
        grid[i][j] = '0';

        int[] iShf = {1,-1,0,0};
        int[] jShf = {0,0,1,-1};
        for(int k = 0 ; k < iShf.length ; k++){
            dfsCountIslands(grid,i+iShf[k] , j+jShf[k]);
        }
        return 1;
    }


    /**
     * @Title: 200. 岛屿数量
     * @Version: 版本2 Flood fill 算法实现
     *
     * @param grid
     * @return
     */
    public static int numIslands2(char[][] grid) {
        return 0;
    }


    /**
     * @Title: 463 岛屿的周长
     * @version: DFS
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {
        for(int i = 0 ; i< grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    return dfsEdge(grid,i,j);
                }
            }
        }
        return 0;
    }

    private static int dfsEdge(int[][] grid, int i, int j) {
        if(outOfBoundry(grid,i,j) || grid[i][j] == 0) return 1;
        if(grid[i][j] == 1){
            grid[i][j] = -1;
            int num = dfsEdge(grid,i+1,j) + dfsEdge(grid,i-1,j) + dfsEdge(grid, i, j+1) + dfsEdge(grid, i, j-1);
            return num;
        }
        return 0;
    }

    private static boolean outOfBoundry(int[][] grid ,int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return true;
        }
        return false;
    }


    /**
     * @Title: 463 岛屿的周长
     * @Version: 遍历计数
     *
     * 正向统计1 周围的 0 或者 边界 判断较为麻烦
     * 反向统计1周围的1相对简单
     *
     * @param grid
     * @return
     */
    public static int islandPerimeter2(int[][] grid) {
        int num = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    num += 4;
                    if(i > 0 && grid[i-1][j] == 1){
                        num -= 1;
                    }
                    if( i < grid.length-1 && grid[i+1][j] == 1){
                        num -= 1;
                    }
                    if(j > 0 && grid[i][j-1] == 1){
                        num -= 1;
                    }
                    if(j < grid[0].length - 1 && grid[i][j+1] == 1){
                        num -= 1;
                    }
                }
            }
        }
        return num;
    }

    /**
     * @Title: 463 岛屿的周长
     * @Version: 版本3
     *
     * 考虑若岛屿中的每个单元格周围都是0的情况，这时
     * 计算岛屿的的周长有 C = 4*N， 其中C为所有单元格的周长和,N为每个单元格(值为1的点)的个数
     *
     * 现在如果将岛屿的所有相邻的单元格按原有的上下左右的顺序临接起来,得到的就是题目中的岛屿
     * 每个相邻的边对应的被两个单元格共用,因此可以单向的对出现相邻边的减2(版本2是双向的对同一单元格邻接边减1)
     *
     * @param grid
     * @return
     */
    public static int islandPerimeter3(int[][] grid) {
        int num = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                // 这里判断左边和上边(也可以判断右边和下边)
                if(grid[i][j] == 1){
                    num += 4;
                    if(i > 0 && grid[i-1][j] == 1){
                        num -= 2;
                    }
                    if(j > 0 && grid[i][j-1] == 1){
                        num -= 2;
                    }
                }
            }
        }
        return num;
    }
}
