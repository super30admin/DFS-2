// time complexity o(n*m) space complexity o(m+n)
class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    Queue<int []> q = new LinkedList<>();
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                       int[] curr = q.poll();
                       for(int[] d : dir){
                           int nr=curr[0] +d[0];
                           int nc=curr[1] + d[1];
                           if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]=='1'){
                               grid[nr][nc]='0';
                               q.add(new int[]{nr,nc});
                           }
                       }
                    }
                }
            }
        }
        return count;
    }
}