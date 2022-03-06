class Solution {

    int[] xArr = {0,0,-1,1};
    int[] yArr = {-1,1,0,0};

    public int numIslands(char[][] grid) {

        int count = 0;

        for(int i=0; i< grid.length; i++){
            for(int j=0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    //dfs(grid,i ,j);
                    bfs(grid,i ,j);
                     count++;
                }
            }
        }
        return count;
    }
    // Time Complexity : o(m*n) m = rows and n = colums
    // Space Complexity : o (Min(m,n))  where m = rows and n = colums as ata  tiem we will onlly have max element in queue as number of elements in diagonal
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    // Your code here along with comments explaining your approach
    // BFS Approach, start with any land and vist its neighor if they ara land add them to queu and mark them visited
    // Number of times taken to call bfs to visit all land will the final time

    public void bfs(char[][] grid, int x , int y){

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(x,y));

        while(!q.isEmpty()){

            Pair<Integer, Integer> p = q.poll();

            for(int i=0; i<xArr.length; i++){
                int xNew = p.getKey() + xArr[i];
                int yNew = p.getValue() + yArr[i];
                if(xNew>=0 && xNew<grid.length && yNew>= 0 && yNew < grid[0].length
                  && grid[xNew][yNew] == '1'){
                    grid[xNew][yNew] = '0';
                    q.add(new Pair<>(xNew,yNew));
                }
            }
        }
    }

    // Time Complexity : o(m*n) m = rows and n = columns
    // Space Complexity :  o(m*n) m = rows and n = columns
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    // Your code here along with comments explaining your approach
    // DFS Approach, start with any land and vist its neighor if they are land add then continue the dfs path
    // Number of times taken to call dfs to visit all land will the final time


    // Your code here along with comments explaining your approach

    public void dfs(char[][] grid, int x , int y){
        for(int i=0; i<xArr.length; i++){
            int xNew = x + xArr[i];
            int yNew = y + yArr[i];
            if(xNew>=0 && xNew<grid.length && yNew>= 0 && yNew < grid[0].length
              && grid[xNew][yNew] == '1'){
                grid[xNew][yNew] = '0';
                dfs(grid, xNew, yNew);
            }
        }
    }
}
