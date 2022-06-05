// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * @param {character[][]} grid
 * @return {number}
 */
 var numIslands = function(grid) {
    var count=0;
    var r = grid.length;
    var c = grid[0].length;
    for(let i=0;i<r;i++)
    {
     for(let j=0;j<c;j++)
     {
         if(grid[i][j]==='1')
         {
             visited(grid,r,c,i,j);
             count++;
         }
     }
    }
    function visited(grid,r,c,x,y){
        if(x>=0 && y>=0 && x<r && y<c && grid[x][y]==='1')
        {
            
        
            grid[x][y]='2';
        visited(grid,r,c,x+1,y);
        visited(grid,r,c,x-1,y);
        visited(grid,r,c,x,y+1);
        visited(grid,r,c,x,y-1);
        }
    }
    return count;
};