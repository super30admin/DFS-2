class Solution {
    class Location{
        int x,y;

        Location(int x, int y){
            this.x = x;
            this.y = y;
        }

        int getX(){
            return this.x;
        }

        int getY(){
            return this.y;
        }
    }
    public int numIslands(char[][] grid) {
        int counter = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    grid[i][j] = '2';
                    helper(grid, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }

    public void helper(char[][] grid, int i, int j){
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(i, j));
        Location l;
        int lx;
        int ly;
        while(!queue.isEmpty()){
            l = queue.poll();
            lx = l.getX();
            ly = l.getY();


            if(tester(grid,lx+1,ly)){
                grid[lx+1][ly] = '2';
                queue.add(new Location(lx+1,ly));
            }
            if(tester(grid,lx-1,ly)){
                grid[lx-1][ly] = '2';
                queue.add(new Location(lx-1,ly));
            }
            if(tester(grid,lx,ly+1)){
                grid[lx][ly+1] = '2';
                queue.add(new Location(lx,ly+1));
            }
            if(tester(grid,lx,ly-1)){
                grid[lx][ly-1] = '2';
                queue.add(new Location(lx,ly-1));
            }

        }

    }

    public boolean tester(char[][] grid, int i, int j){
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j] == '1')
            return true;
        return false;
    }
}