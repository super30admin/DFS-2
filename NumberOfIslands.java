/* Approach: using BFS
 */
//Time: O(m*n)
//Space: min(m,n) -- max length of diagonal in matrix
class Solution {
    Queue<int[]> q;
    int m, n;
    int count;
    int dirs[][];

    public int numIslands(char[][] grid) {

        this.q=new LinkedList<>();
        this.dirs=new int[][]{{0,-1},{0,1},{-1,0},{1,0}};

        this.m=grid.length;
        this.n=grid[0].length;
        count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]=='1'){

                    count++;
                    grid[i][j]='0';

                    q.add(new int[]{i,j});

                    bfs(grid,i,j);
                }
            }
        }

        return count;

    }

    private void bfs(char grid[][], int i, int j){

        while(!q.isEmpty()){

            int curr[]=q.poll();

            for(int dir[]:dirs){

                int r=curr[0]+dir[0];
                int c=curr[1]+dir[1];

                if(r>=0 && c>=0 && r<m && c<n && grid[r][c]=='1'){
                    grid[r][c]='0';

                    q.add(new int[]{r,c});
                }
            }
        }
    }
}