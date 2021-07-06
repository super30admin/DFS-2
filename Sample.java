//Problem:-1 Number of Islands
// Time Complexity : O(m*n) grid space
// Space Complexity : O(h) height of stack
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// DFS with for loop
class Solution {
    int [][] dirs;
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0) return 0;
        dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        int count=0;
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                
                if(grid[i][j] == '1'){
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        
        return count; 
    }
    
    
    private void helper(char[][] grid, int i, int j){
        //base
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
         
        //logic
        grid[i][j]='0';
        
        for(int [] dir: dirs){
            int r= dir[0]+i;
            int c= dir[1]+j;
            
            if(r>= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1'){
                helper(grid, r, c);
            }
        }
    }
}
//Problem:-1 Number of Islands
// Time Complexity : O(m*n) grid space
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

//BFS approach

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int [][] dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        
        int count=0;
        Queue<int[]> q=new LinkedList<>();; 
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                
                if(grid[i][j] == '1'){ 
                    count++;
                    grid[i][j] = '0';
                    q.add(new int[] {i,j});
                    
                    while(!q.isEmpty()){
                        int [] cur = q.poll();
                        
                        for(int[] dir: dirs){
                            int r = dir[0]+cur[0];
                            int c = dir[1]+cur[1];
                            
                            if(r >=0 && c >=0 && r < grid.length && c < grid[0].length && grid[r][c] == '1'){
                                grid[r][c] = '0';
                                
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                }
                
            }
        }

        return count;
    }
}

//Problem: 
// Time Complexity : O(n) where n is the len of the string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public String decodeString(String s) {
        
        
        Stack<Integer> numStack = new Stack();
        Stack<StringBuilder> strStack = new Stack();
        
        int curNum = 0;
        StringBuilder curString = new StringBuilder();
        
        for( int i=0; i <s.length(); i++){
            char c = s.charAt(i);
            if( Character.isDigit(c)){ // if it is a number 
                curNum = curNum * 10 + c -'0';
            }else if( c == '['){
                numStack.push(curNum);
                strStack.push(curString);
                curNum=0;
                curString= new StringBuilder();
            }else if( c == ']'){
                int itr = numStack.pop();
                StringBuilder temp = new StringBuilder();
                for(int j=0; j< itr; j++){
                    temp.append(curString);
                    
                }
                StringBuilder earlierString = strStack.pop();
                curString = earlierString.append(temp);
            }else{
                curString.append(c);
            }
        }
        
        return curString.toString();
        
    }
}
