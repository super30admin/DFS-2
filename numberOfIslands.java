//time complexity: O(m*n)
//space complexity : O(m*n), worst case; all are 1s, we add every element to the queue
//approach: Intitate a count variable and Iterate over the matrix
//Count the island whenever we are encouterning '1' at any index.
//Perform BFS at the index to make all the neighboring elements from '1' --> '0' as they are part of same island.
//For BFS maintain a queue and push index of encountered '1' in queue and subsequently keep adding all the neighbors with value '1' till queue becomes empty.
//Return the count.

class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(grid[i][j]=='1')
                {   result++;
                    q.add(new int[]{i,j});
                    grid[i][j] = 0;
                    while(!q.isEmpty())
                    {   
                        int[] current = q.poll();
                        int[][] dirs = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
                        for(int[] dir : dirs)
                        {
                            int r = current[0] + dir[0];
                            int c = current[1] + dir[1];
                            if(r!=-1 && r!=m && c!=-1 && c!=n && grid[r][c]=='1')
                            {
                                q.add(new int[]{r,c});
                                grid[r][c] = 0;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}