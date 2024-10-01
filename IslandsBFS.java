// BFS -
// Space complexity = O(max(m,n))
//  Time complexity = O(m*n)
class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        int res =0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i< grid.length;i++) {
            for(int j=0;j< grid[0].length;j++) {
                if(grid[i][j]=='1') {
                    res++;
                    q.add(new int[]{i,j});
                    grid[i][j] ='0';
                    while(!q.isEmpty()) {
                        int[] node = q.poll();                        
                        for(int[] dir: dirs) {
                            int r = node[0] + dir[0];
                            int c = node[1] + dir[1];
                            if(r>=0 && r< grid.length && c<grid[0].length && c>=0 && grid[r][c]=='1')                                 {
                                    q.add(new int[]{r,c});
                                    grid[r][c]='0';
                            
                            }
                        }
                    }
                }
                

            }
        }
        return res;
    }
}