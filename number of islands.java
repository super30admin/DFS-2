/* time complexity O(m*n)
space complexity O(min(m,n))*/

class Solution {
    public int numIslands(char[][] grid) {
        Queue<Integer> q=new LinkedList<>();
        int m=grid.length;
        int n = grid[0].length;
        int count=0;
        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};
        if(grid==null || grid.length==0) return 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    q.add(i);
                    q.add(j);
                    grid[i][j]='0';
                while(!q.isEmpty()){
                    int r=q.poll();
                    int c=q.poll();
                    for(int[] dir:dirs){
                        int rr=r+dir[0];
                        int cc=c+dir[1];
                        if(rr>=0 && cc>=0 && rr<m && cc<n && grid[rr][cc]=='1'){
                            q.add(rr);
                            q.add(cc);
                            grid[rr][cc]='0';
                        }
                    }
                }
                }
            }
        }
        return count;
    }
} 