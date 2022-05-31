// Number of Islands
// Time Complexity: O(m*n) : m, n  dimensions of the grid
// Space Complexity: O(m*n) : m, n  dimensions of the grid
class Solution {
    public int numIslands(char[][] grid) {
         int numOfIslands = 0;
       for ( int i = 0; i < grid.length; i++){
           for (int j = 0; j < grid[i].length; j++)
           {
               if (grid[i][j] == '1')
               {
                   numOfIslands = numOfIslands + dfs(grid, i ,j);
               }
           }        
       } 
         return numOfIslands;
    }
     public int dfs(char[][] grid, int i, int j)
     {
      if ( i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return 0;
         grid[i][j] = '0';
         dfs(grid, i+1, j); //down
         dfs(grid, i, j+1); //right
         dfs(grid, i-1, j); //up
         dfs(grid, i, j-1); //left
         return 1; // to account for the grid which is 1 in the numIslands function
     
    }
}

// Decode String
// Time Complexity : O(N*max(times)) 
// Space Complexity : O(N), N is the length of string
class Solution2 {
    int i;
    public String decodeString(String s) {
        
int num = 0;
        StringBuilder currStr = new StringBuilder();
        while ( i < s.length())
        {
            char ch = s.charAt(i);
            if (Character.isDigit(ch))
            {
                num = num * 10 + (ch - '0');
                i++;
            }
            else if (ch == '[')
            {
                i++;
                String decode = decodeString(s);
               // multiply decode(inner string) num times
                for ( int j = 0; j < num; j++)
                {
                    currStr.append(decode);
                }
                num = 0;
            }
            else if (ch == ']')
            {
                i++;
                return currStr.toString();
            }
          
            else 
            {
                currStr.append(ch);
                i++;
            }
        }
        return currStr.toString();
    }
}
