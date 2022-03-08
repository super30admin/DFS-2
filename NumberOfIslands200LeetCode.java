//Time complexity: O(n)
//Space Complexity: O(n)
//didn't face any problems
//runs successfully


//creating the pair class to store row and column into queue for BFS approach
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}

public class NumberOfIslands200LeetCode {


        //DFS Approach
        int[][] directions = {                              //creating the directions array that are contain all 4 possible directions that we can go from any node
                {0, 1},
                {1, 0},
                {-1, 0},
                {0, -1},
        };

        private static final char WATER = '0';          //creating static final variable to represent water
        private static final char LAND = '1';              //creating static final variable to represent land

        public int numIslands(char[][] grid) {

            int num =0;

            for(int i=0; i<grid.length; i++){           //iterating through grid

                for(int j=0; j<grid[i].length; j++){

                    if(grid[i][j] == LAND){         //whenever the land is present we can call the function with current row and column

                        getIslands(grid, i, j);
                        num++;                      //after coming back from the function, we increase the num counter which represent the number of islands

                    }
                }
            }
            return num;
        }

        public void getIslands(char[][] grid, int i, int j){

            grid[i][j] = WATER;             //if land then convert to the water to avoid duplication calls

            for(int[] dir : directions){    //itearting through each direction

                int newX = i + dir[0];      //getting the new direction
                int newY = j + dir[1];

                if(newX>=0 && newY>=0 && newX<grid.length &&
                        newY<grid[0].length && grid[newX][newY] == LAND){ // checking if the new direction is valid or not and also checking the new direction is land or not

                    getIslands(grid, newX, newY);       //if direction is valid and new direction is also land then calling the recursive function with new direction


                }
            }
        }







        //BFS Approach
//     int[][] directions = {
//         {0, 1},
//         {1, 0},
//         {-1, 0},
//         {0, -1},
//     };

//     private static final char WATER = '0';
//     private static final char LAND = '1';

//     public int numIslands(char[][] grid) {

//         int num =0;

//         for(int i=0; i<grid.length; i++){

//             for(int j=0; j<grid[i].length; j++){

//                 if(grid[i][j] == LAND){

//                     getIslands(grid, i, j);
//                     num++;

//                 }
//             }
//         }
//         return num;
//     }

//     public void getIslands(char[][] grid,int i, int j){

//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(i, j));

//         while(!q.isEmpty()){

//             Pair p = q.remove();
//             int oldX = p.getX();
//             int oldY = p.getY();
//             grid[oldX][oldY] = WATER;

//             for(int[] dir : directions){

//                 int newX = oldX + dir[0];
//                 int newY = oldY + dir[1];

//                 if(newX>=0 && newY >=0 && newX<grid.length &&
//                    newY<grid[0].length && grid[newX][newY] == LAND){

//                     q.add(new Pair(newX, newY));
//                     grid[newX][newY] = WATER;

//                 }

//             }

//         }

//     }

}
