// ******************** DFS Approach ********************
// Time Complexity:  O(m*n)
// Space ComplexitY: O(m*n)

class Solution {

    private static int[][] directions = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    private int m;
    private int n;
    private int count;

    public int numIslands(char[][] grid) {

        m = grid.length;
        n = grid[0].length;
        count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {                                   // when we get '1' in grid array
                    count++;                                              // increment the count
                    dfs(grid, i, j);                                      // start dfs with that grid indexes
                }
            }
        }

        return count;

    }

    private void dfs(char[][] grid, int i, int j) {

        // base case
        if(i<0 || j<0 || i==m || j==n || grid[i][j] != '1') {             // if current grid indexes out of bounds OR not 1(0 from the beginning or visited and made 0)
            return;
        }

        // logic
        grid[i][j] = '0';                                                 // if 1 and not visited, make it 0
        for(int[] dir : directions) {                                     // check neighbours
            int nI = i + dir[0];
            int nJ = j + dir[1];
            dfs(grid, nI, nJ);                                            // start dfs for meighbours
        }

    }
}



// // ******************** BFS Approach ********************
// // Time Complexity:  O(m*n)
// // Space ComplexitY: O(m*n)

// class Solution {

//     private static int[][] directions = {
//         {-1, 0},
//         {0, 1},
//         {1, 0},
//         {0, -1}
//     };

//     private int m;
//     private int n;
//     private int count;
//     private Queue<Integer> qr;
//     private Queue<Integer> qc;

//     public int numIslands(char[][] grid) {

//         m = grid.length;
//         n = grid[0].length;
//         count = 0;
//         qr = new LinkedList<>();
//         qc = new LinkedList<>();

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
                
//                 if(grid[i][j] == '1') {                                                        // when we get '1' in grid array                    
//                     count++;                                                                   // increment the count
//                     grid[i][j] = '0';                                                          // making it '0'
//                     qr.add(i);                                                                 // adding row index in queue
//                     qc.add(j);                                                                 // adding column index in queue

//                     while(!qr.isEmpty()) {
//                         int cI = qr.poll();                                                    // getting row index from queue
//                         int cJ = qc.poll();                                                    // getting column index from queue
//                         for(int[] dir : directions) {                                          // check neighbours
//                             int nI = cI + dir[0];
//                             int nJ = cJ + dir[1];
//                             if(nI>=0 && nJ>=0 && nI<m && nJ<n && grid[nI][nJ] == '1') {        // checking bounds of neighbours having '1' value
//                                 grid[nI][nJ] = '0';                                            // making it '0'
//                                 qr.add(nI);                                                    // adding row index in queue
//                                 qc.add(nJ);                                                    // adding column index in queue
//                             }
//                         }
//                     }
//                 }
//             }
//         }

//         return count;

//     }

// }
