// //BFS
// //TC = O(2mn) = O(m*n)
// //SC=min(m,n), O(mn) in worst case
// class Solution {
//     public int numIslands(char[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int count = 0;
//         int dirs[][]=new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]=='1'){
//                     count++;
//                     //bfs
//                     Queue<Integer> q = new LinkedList<>();
//                     q.add(i);
//                     q.add(j);
//                     grid[i][j]='0';
//                     while(!q.isEmpty()){
//                         int cr = q.poll();
//                         int cc = q.poll();
//                         for(int []dir: dirs){
//                             int nr=dir[0]+cr;
//                             int nc=dir[1]+cc;
//                             if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1'){
//                                 q.add(nr);
//                                 q.add(nc);
//                                 grid[nr][nc]='0';
//                             }
//                         }
//                     }
//                 }
//             }
//         }
//         return count;
//     }
// }

//DFS
//TC=O(2mn)=O(mn), SC=
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int dirs[][]=new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i,j, dirs);
                }
            }
        }
        return count;
    }
    private void dfs(char [][]grid, int r, int c, int dirs[][]){
        //base
        if(r<0 || c<0 || r==grid.length || c==grid[0].length || grid[r][c]=='0' )return;
        //logic
        grid[r][c]='0';
        for (int []dir:dirs){
            int nr = dir[0]+r;
            int nc = dir[1]+c;
            dfs(grid,nr,nc,dirs);
        }
    }
}