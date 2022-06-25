// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return -1;
        Queue<int[]> q = new LinkedList<>();
        int [][]dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    grid[i][j]='0';
                    cnt++;
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int []curr = q.poll();
                        for(int []dir:dirs){
                            int a=curr[0]+dir[0];
                            int b=curr[1]+dir[1];
                            if(a>=0 && b>=0 && a<grid.length && b<grid[0].length && grid[a][b]=='1'){
                                grid[a][b]='0';
                                q.add(new int[]{a,b});
                                
                            }
                        }

                    }
                }
            }
        }
        return cnt;
    }
}
