// Time Complexity : For recursive O(n)
// Space Complexity : o(N)
// Did this code successfully run on Leetcode :DFS-worked
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    int[] dx={-1,0,1,0};
    int[] dy={0,1,0,-1};
    public int numIslands(char[][] grid) {
     if(grid ==null || grid.length==0) return 0;
        
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        Queue<Pair> queue = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    System.out.println("i-"+i+"j--"+j);
                    count++;
                    grid[i][j]='2';
                   queue.add(new Pair(i,j));
                }
            }
        }
        while(!queue.isEmpty()){
            Pair cell=queue.poll();
            for(int k=0;k<4;k++){
                int x=cell.x+dx[k];
                int y=cell.y+dy[k];
                
                if(isValid(x,y,m,n) && grid[x][y]=='2'){
                     // grid[x][y]='2';
                       queue.add(new Pair(x,y));
                }
            }
        }
        return count;
    }
    private boolean isValid(int m,int n,int x,int y){
        return x>=0 && x<m && y>=0 && y<n;
    }
    

}
class Pair{
    int x,y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}



//SOLUTION DFS-RECURSION
//  int[] dx={-1,0,1,0};
//     int[] dy={0,1,0,-1};
//     public int numIslands(char[][] grid) {
//      if(grid ==null || grid.length==0) return 0;
        
//         int m=grid.length;
//         int n=grid[0].length;
//         int count=0;
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]=='1'){
//                     System.out.println("i-"+i+"j--"+j);
//                     count++;
//                     dfsVisit(grid,i,j,m,n);
//                 }
//             }
//         }
//         return count;
//     }
//     private void dfsVisit(char[][] grid,int row,int col,int m,int n){
//         grid[row][col]='2';
//         for(int k=0;k<4;k++){
//             int x=row+dx[k];
//             int y=col+dy[k];
        
//         if(isValid(x,y,m,n) && grid[x][y]=='1'){
            
//             dfsVisit(grid,x,y,m,n);
//         }
//         }
//     }
//     private boolean isValid(int x,int y,int m,int n){
//         return x>=0 && x<m && y>=0 && y<n;
//     }