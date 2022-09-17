import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {

        //BFS
        //queue to add cordinates of land
        Queue<Integer[]> q = new LinkedList<>();
        Integer[][] dir = new Integer[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int count =0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1')  {
                    count++;
                    grid[i][j]='0';
                    q.add(new Integer[]{i,j});
                    while(!q.isEmpty()){
                        int size = q.size();
                        for(int k=0;k<size;k++){
                            Integer[] cc = q.poll();
                            //move to directions
                            for(Integer[] d : dir){
                                int nr = cc[0]+d[0];
                                int nc =cc[1]+d[1];
                                //bound check
                                if(nr<m && nr>=0 && nc<n && nc>=0){
                                    if(grid[nr][nc] == '1'){
                                        grid[nr][nc]='0';
                                        q.add(new Integer[]{nr,nc});
                                    }
                                }
                            }
                        }
                    }//while

                }
            }
        }
        return count;
    }
}