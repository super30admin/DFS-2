class NumberofIslands {
    // Approach 1 - using DFS
   // Time complexity - O(m*n)
   // Space complexity - O(1)
   
   // This appraoch uses DFS traversal for connected adjacent land and mark visited neighbour.
   // During a dfs traversal, all neighbours which are connected to the starting point of the traversal are             // visited. Looping through the given grid, and counting a non-visted node after every traversal will be the         // number of disconnected componenet or island for the given grid.
 
   public int numIslands1(char[][] grid) {
       int count =0;
       
       // loop through the given grid to find out the unvisited land
       for(int i=0; i<grid.length; i++){
           for(int j=0; j<grid[0].length; j++){
               
               // when the grid value signifies land means it is not visited by any previous dfs traversal
               // start a dfs traversal mark this cell and all its neighbours as visited increease the count i.e.                   // keep count of initiation of dfs traversal and return count when all non-zero cells are visited.
               if(grid[i][j] == '1'){
                   find(grid,i,j);
                   count++;
               }
           }
       }
       return count;
   }
   
   // This is a recursive function which will call itself untill all of the neighbours of the given cell is             // visited.
   public void find1(char[][] grid, int i, int j){
       if(grid[i][j] == '0')
           return;
       grid[i][j] = '0';
       if(i+1 < grid.length) find(grid, i+1,j);
       if(i-1 >= 0 ) find(grid, i-1,j);
       if(j+1 < grid[0].length) find(grid, i,j+1);
       if(j-1 >=0 ) find(grid, i,j-1);
       return;
   }
}
   // Approach 2 - using DFS
   // Time complexity - O(m*n)
   // Space complexity - O(m*n)
   
   // This appraoch uses DFS traversal for connected adjacent land and keep track of visited neighbour using a         // O(m*n) storage. During a dfs traversal, all neighbours which are connected to the starting point of the           // traversal are visited. Looping through the given grid, and counting a non-visted node after every traversal       // will be the number of disconnected componenet or island for the given grid.
   
   // Global hashmap to store visited component;
   HashSet<String> visited; 
   public int numIslands(char[][] grid) {
       visited = new HashSet<>();
       int count =0;
       
       // loop through the given grid to find out the unvisited land
       for(int i=0; i<grid.length; i++){
           for(int j=0; j<grid[0].length; j++){
               String str = Integer.toString(i) + " "+ Integer.toString(j);
               
               // when the grid value signifies land and it is not visited by any previous dfs traversal
               // start a dfs traversal mark this cell and all its neighbours as visited increease the count i.e.                   // keep count of initiation of dfs traversal and return count when all non-zero cells are visited.
               if(!visited.contains(str) && grid[i][j] == '1'){
                   find(grid,i,j);
                   count++;
                   visited.add(str);
               }
           }
       }
       return count;
   }
   
   // This is a recursive function which will call itself untill all of the neighbours of the given cell is             // visited.
   public void find(char[][] grid, int i, int j){
       String str = Integer.toString(i) + " "+ Integer.toString(j);
       if(visited.contains(str) || grid[i][j] == '0')
           return;
       visited.add(str);
       if(i+1 < grid.length) find(grid, i+1,j);
       if(i-1 >= 0 ) find(grid, i-1,j);
       if(j+1 < grid[0].length) find(grid, i,j+1);
       if(j-1 >=0 ) find(grid, i,j-1);
       return;
   }
}