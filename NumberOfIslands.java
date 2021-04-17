/**
 *
 *  Time Complexity: O(M*N) Where N is the number of rows and M is number of columns.
 *  Space Complexity: O(M*N) Where N is the number of rows and M is number of columns.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 *
 *  Explanation: We can use either a DFS or a BFS approach. In BFS we first start iterating over the entire grid, if we find an island then we add that to the queue and increment the island count. Now unitll the queue is empty we start polling the elements and checking if there are any other island in neighbouring cells. If we find any islands in next sells we simply add them to the queue and later mark them as 0 once polled. When there are no more elements left we exit the while loop. Now we will continue to iterate over the original grid, since we marked neighbouring islands as zero we will not count them to the number of islands, if there are any other islands in the grids seperate from the previous island only then we will again increment the count.
 */

class Solution {
    //BFS
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        } 
        int count=0;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){ 
                if(grid[i][j]=='1'){
                    queue.offer(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int dir[] = queue.poll();
                        
                    }
                }
            }
        }
    }
    
    // DFS
    // public int numIslands(char[][] grid) {
    //     if(grid==null || grid.length==0){
    //         return 0;
    //     }   
    //     int count=0;
    //     for(int i=0;i<grid.length;i++){
    //         for(int j=0;j<grid[0].length;j++){
    //             if(grid[i][j]=='1'){
    //                 dfs(grid, i, j);
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    // private void dfs(char[][] grid, int row, int col){
    //     if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]=='0'){
    //         return;
    //     }
    //     grid[row][col]='0';
    //     int dirs[][]=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    //     for(int[] dir: dirs){
    //         dfs(grid, row+dir[0], col+dir[1]);
    //     }
    // }
}
