//solved successfully on leetcode and faced no issues
//TC : O(m*n) SC:O((m*n)
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length ;//number of rows
        int n = grid[0].length ;//number of columns
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]>queue = new LinkedList<>();
        int count = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1'){
                    count+=1;
                //mark it as 0 and push into the queue  to avoid pushing again into queue later kind of marking it as visited already
                
                grid[i][j] = '0';
                queue.add(new int[]{i,j});
                //start our bfs
                while(!queue.isEmpty()){
                    //remove the pair from queue
                    int[] curr = queue.remove();
                    int currentrow = curr[0];
                    int currentcolumn = curr[1];
                    //process it's neighbours
                    for(int[] dir : directions){
                        int newrow = currentrow + dir[0];
                        int newcolumn = currentcolumn + dir[1];
                        //check boundaries of neighbours
                        if(newrow >= 0 && newrow < m && newcolumn >=0 && newcolumn < n && grid[newrow][newcolumn] == '1'){
                            grid[newrow][newcolumn] = '0';
                            queue.add(new int[]{newrow , newcolumn});

                        }
                    }
                }

            }
            }
        }
        return count;
        
    }
}