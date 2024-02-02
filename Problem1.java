//accepted on LT
//Do simple bfs and check the boarders
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    grid[i][j]='0';
                    int[] t = {i,j};
                    q.add(t);
                    while(!q.isEmpty()){
                        int[] item = q.poll();
                        for(int[] dir : d){

                        
                            int x = item[0]+dir[0];
                            int y = item[1]+dir[1];
                            if(x<0||x>=grid.length||y<0 || y>=grid[0].length) continue;
                            if(grid[x][y]=='1'){
                                grid[x][y]='0';
                                int[] l ={x,y};
                                q.add(l);
                            }
                        }
                    }
                    count+=1;
                }
                
            }
        }
        return count;
        
    }
}