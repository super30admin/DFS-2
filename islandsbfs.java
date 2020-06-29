//Time complexity: O(mn)
//Space complexity:O(min(m,n)) as max items in queue will be along the diagonal.

class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        Queue<int[]> q=new LinkedList();
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        int result=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    result++;
                    grid[i][j]='2';
                    q.add(new int[] {i,j});
                }
                while(!q.isEmpty()){
                    int[] arr=q.poll();
                    for(int[] dir:dirs){
                        int row=dir[0]+arr[0];
                        int col=dir[1]+arr[1];
                        if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]=='1'){
                            grid[row][col]='2';
                            q.add(new int[] {row,col});
                        }
                    }
                }
            }
        }
        return result;
    }
}