//Time - O(mn)
//Space - O(mn)
class Solution {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        visited = new boolean[m][n];
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    visited[i][j]=true;
                    q.add(new Pair<Integer,Integer>(i,j));
                    find(q,dirs,m,n,grid);
                    count++;
                }

            }
        }
        return count;
        
    }

    public void find(Queue<Pair<Integer, Integer>> q, int[][] dirs, int m, int n, char[][] grid){
        while(!q.isEmpty()){
            Pair<Integer,Integer> p = q.poll();
            int r = p.getKey();
            int c = p.getValue();
            for(int[] dir: dirs){
                int row = r+dir[0];
                int col = c+dir[1];
                if(row>=0 && row<m && col>=0 && col<n && grid[row][col]=='1' && !visited[row][col]){
                    visited[row][col]=true;
                    q.add(new Pair<Integer,Integer>(row,col));
                }
            }

        }
    }
}

