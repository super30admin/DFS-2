//Time complexity:- o(mn);
//space complexity:-0(1);
//Did it run on leetcode:-Yes;
// what problems you faced while doing this sum?:- initialy forgot to change traversed element to 0 so got time exceeded.
//your code with explanation:- traversing normally in a matrix whenever I got element as 1 performing reccursively dfs for 4-directional elements. in that reccursion it self changing element
// to be 0 for ending reccursion loop.


class Solution {

    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                   count=count+ traversal(grid,i,j);
                    }
            }
        }
              
        
   return count; }
    private int traversal(char[][] grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!='1'){
            return 0;
        }
        grid[i][j]='0';
        traversal(grid,i-1,j);
        traversal(grid,i+1,j);
        traversal(grid,i,j-1);
        traversal(grid,i,j+1);
    return 1;}
}