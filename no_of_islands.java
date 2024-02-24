//TC: O(m*n)
//SC: O(min(m,n))
class Solution {
    int[][] dirs;
    public int numIslands(char[][] grid) {
        this.dirs=new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                 if(grid[i][j]=='1')
                 {
                   count++;
                   grid[i][j]='0';
                   q.add(new int[] {i,j});
                   while(!q.isEmpty())
                   {
                       int [] temp=q.poll();
                       for(int[] dir: dirs)
                       {
                           int cr=temp[0]+dir[0];
                           int cc=temp[1]+dir[1];
                           if(cr>=0&&cc>=0&&cr<m&&cc<n&&grid[cr][cc]=='1')
                           {
                               grid[cr][cc]='0';
                               q.add(new int [] {cr,cc});
                           }
                       }

                   }
                 }
            }
        }
        return count;
    }
}