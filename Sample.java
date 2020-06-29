// Time Complexity : O(m*n) 
// Space Complexity : O(min(m,n)) since we traverse only diagnol as max and never start at mid but from corner
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int numIslands(char[][] grid) {
          if(grid == null || grid.length == 0) return 0;
        int count =0;
        int m = grid.length;
        int n = grid[0].length;
        int [][] dirs = new int [][] {{0,1}, {1,0}, {-1,0}, {0,-1}};

        for(int i = 0; i <  m; i++){ // traversing through whole grid
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){ // if encounter a 1

                    count++; // increase count for only the new island found
                    Queue <int []> q = new LinkedList<>(); // to traverse all neighbours of the island
                    q.add(new int[] {i,j}); // add the point found to queue
                    grid[i][j] = '0'; // mark it 0 as it has been vistied

                    while(!q.isEmpty()){ // till queue becomes empty i.e all neighbours visited

                        int [] curr = q.poll(); // get curr point
                        for(int [] dir : dirs){ // traverse all directions
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1'){ // check bounds and if value is 1
                                 q.add(new int[] {r,c}); // add to queue to traverse its neighbours
                                 grid[r][c] = '0'; // mark it visited

                            }
                        }
                    }
                }
            }
        }
        return count; // return the count
    }
}

// Time Complexity : O(m*n) 
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    int count,m,n;
    int dirs[][];
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0)
            return 0; 
        
         m = grid.length;
         n = grid[0].length;
         count=0;
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        
        for(int i=0;i<m;i++) // traversing the whole grid
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == '1') // if the value is 1
                {
                    count++; //increase count only when a new island found
                     dfs(grid, i, j);   //call dfs on the point
                }
                 
            }
            
           
        }
         return count;
    }
        
        private void dfs(char[][] grid, int i, int j)
        {
            //base
            if(i<0 || j<0 || i>=m || j>=n || grid[i][j]!='1') //check bounds and if its is part of island
                return;
            
            //logic
            grid[i][j] = '0'; // mark visited
            for(int dir[]:dirs) //check all directions
            {
                int r = i+ dir[0];
                int c = j+ dir[1];
                dfs(grid, r, c); //call dfs on all neighbours
            }
        }
    
}

// Time Complexity : O(n) where n is length of decoded string
// Space Complexity : O(n) where n is length of input string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public String decodeString(String s) {
        if(s==null || s.length() == 0) 
            return s;
      Stack<StringBuilder> strStack = new Stack<>(); // to keep track of outer string till the point
      Stack<Integer> numStack = new Stack<>();  // to keep track of numbers encountered till the point
        int curr = 0; // curr number
        StringBuilder str = new StringBuilder(); // curr string
        for(int i=0;i<s.length();i++) // traversing through the length of the string
        {
            char c = s.charAt(i); // taking the character at the index
            if(Character.isDigit(c)) // if it is digit
            {
               curr = curr*10 + c - '0'; // find the number till the point by multiplying the original number by 10 and adding the curr digit to it
            }
            else if(c == '[') // if opening bracket  means new num and string to be encountered
            {
                strStack.push(str); // push string formed till the point in stack
                numStack.push(curr); // push number formed till the point in stack
                curr = 0; //reset curr number
                str = new StringBuilder(); // reset curr string
            }
            else if(c == ']') // if closing bracket means we need to process
            {
                int times = numStack.pop(); // get the number at top of numstsack
                StringBuilder st = new StringBuilder(); 
                for(int k = 0; k<times; k++) // multiply the curr string by number at top
                {
                    st.append(str);
                }
                str = strStack.pop().append(st); // append the character at top of stack to it
            }
            else
            {
               str.append(c); // if alphabet found, append to curr string
            }
        }
        
        return str.toString(); // return the curr string
    }
}