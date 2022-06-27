//Time Complexity=O(MN)
//Space Complexity=O(MN)
public class NumberOfIslandsBFS {
    int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
    int m,n;
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;

        int count=0;
        m=grid.length;n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    Queue<Integer> q=new LinkedList<>();
                    q.add(i);q.add(j);

                    while(!q.isEmpty()){
                        int r=q.poll();
                        int c=q.poll();
                        for(int[] dis: dir){
                            int nr=r+dis[0];
                            int nc=c+dis[1];
                            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1'){
                                q.add(nr);q.add(nc);
                                grid[nr][nc]='0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
