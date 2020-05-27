
class Sample {

    // Time Complexity : O(N) N is number of nodes in matrix
    // Space Complexity : O(N)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    /**
     * Problem 1
     * 1. Check for all the 1s in the matrix and search depthwise till all elements are 1s.
     * 2. As we traverse through every 1, change that to 0 so that it won't be counted again.
     * 3. Once all connected 1s are set to 0, increase count.
     */
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        int count = 0;
        
        /**
        //DFS
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }   
        }
        
        */
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    
                    count++;
                    
                    Queue<int[]> q = new LinkedList<>();
        
                    q.add(new int[]{i, j});
                    while(!q.isEmpty()) {
            
                        int[] curr = q.poll();
                        for(int[] dir: dirs) {
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];

                            if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0')
                                continue;

                            grid[r][c] = '0';
                            q.add(new int[]{r, c});
                        }

                    }
                    
                }
            }   
        }
        
        
        return count;
        
    }
    
    private void dfs(char[][] grid, int i, int j) {
        
        //Base
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        
        //Logic
        grid[i][j] = '0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    // Time Complexity : O(N) N is size of string
    // Space Complexity : O(N)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    /**
     * Problem 1
     * 1. Maintain two stacks, one for numbers and other for chracters.
     * 2. for every openning bracket add number and character to respective stack.
     * 3. for every closing bracket, pop number from number stack and add built up string those many times.
     */
    
    public String decodeString(String s) {
        
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        int currNum = 0;
        StringBuilder currString = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            }
            else if(c == '[') {
                numStack.push(currNum);
                strStack.push(currString);
                
                currNum = 0;
                currString = new StringBuilder();
            }
            else if(c == ']') {
                
                int count = numStack.pop();
                StringBuilder newString = new StringBuilder();
                
                for(int j=0; j<count; j++){
                    newString.append(currString);
                }
                
                StringBuilder old = strStack.pop();
                currString = old.append(newString);
            }
            else {
                currString.append(c);
            }
            
        }
        
        return currString.toString();
    }
    
}