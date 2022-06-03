//Time Complexity: O(mn)
//Space complexity : O(m) if m < n and O(n) if n < m
//BFS 
//Did your code execute on leetcode : yes

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dirs[][] = new int[][] {{0,-1},{0,1},{-1,0},{1,0}};
        Queue<int []> q = new LinkedList<>();
        
        int count = 0 ;
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++)
            {
                if(grid[i][j] == '1'){
                    q.add(new int[]{i,j});
                    count++;
                    grid[i][j] = '2'; //to mark nodes as visited
                }
                
                while(!q.isEmpty())
                {
                    int[] current = q.poll();
                    for(int[] dire : dirs){
                        int r = current[0] + dire[0];
                        int c = current[1] + dire[1];
                
                        if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] =='1'){
                            q.add(new int[]{r,c});
                            grid[r][c] = '2';
                        }
                    }
                }
            }
        }
        return count;
    
    }
}
