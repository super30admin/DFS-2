// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1.Number of Island
//Time Complexity - >  2*M*N
//Space Complexity -> M*N
class Solution {
    //Using BFS
    //Time Complexity - > 2MN
    //Space Complexity - > MN/2-> size of queue
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int count = 0;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i< n;i++){
            for(int j = 0; j < m;j++){
                if(grid[i][j] == '1'){
                    count++;
                    //start the bfs from here
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir : dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr >=0 && nc >=0 && nr <n && nc <m && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.add(new int[]{nr,nc});
                            }
                        }
                    }
                    
                }
            }
        }
        return count;
    }
}
//Using DFS
//Time Complexity - > 2MN
    //Space Complexity - > MN-> size of recursive stack
class Solution {
    //Using DFS
    //Time Complexity - > 2MN
    //Space Complexity - > MN-> size of recursive stack
    int n;
    int m;
    int[][] dirs;
    int count;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        count = 0;
        this.dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        this.n = grid.length;
        this.m = grid[0].length;
        for(int i = 0; i< n;i++){
            for(int j = 0; j < m;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;           
    }

    private void dfs(char[][] grid,int i,int j){
        //base case
        if( i < 0 || j < 0 || i == n || j == m || grid[i][j]=='0') return;

        //logic
        grid[i][j] = '0';
        for(int[] dir : dirs){
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            dfs(grid,nr,nc);
        }

    }
}

//2nd 
//decode string 
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        Stack<StringBuilder> strStack = new Stack();
        Stack<Integer> numStack = new Stack();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        for(int i = 0 ; i<s.length();i++){
            char ch = s.charAt(i);
            //4 cases
            //if digit
            if(Character.isDigit(ch)){
               currNum = currNum * 10 + (ch - '0') ;//in bracket we are converting ch digit into a number; 
            }
            //if [ bracket
            else if(ch == '['){
               strStack.push(currStr); //pushing the curr String into the String stack
               numStack.push(currNum); //pushing the currNum into the num stack
               currStr = new StringBuilder(); //resetting the stringBuilder into new String StringBuilder 
               currNum = 0;

            }
            //if ] bracket
            else if(ch == ']'){
                int count = numStack.pop(); //popiing the count in the numStack
                StringBuilder baby = new StringBuilder();
                for(int k = 0 ; k < count ; k++){
                    baby.append(currStr);
                }
                StringBuilder parent = strStack.pop();
                currStr = parent.append(baby);

            }
            //it is a alphabet
            else{
                currStr.append(ch);
            }
        }

        return currStr.toString();
    }
}

//Using recursion
class Solution {
    //Using Recursion
    int i;
    public String decodeString(String s) {
      
       //no need of base case here as while loop will take care of termination due to global i  
        //logic
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        while( i <s.length()){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = currNum * 10 + (ch-'0');
                i++;
            }else if(ch == '['){
                i++;
                String baby = decodeString(s);
                for(int k = 0 ; k < currNum; k++){
                    currStr.append(baby);
                }
                currNum = 0;

            }else if(ch == ']'){
                i++;
                return currStr.toString();

            }else{
               currStr = currStr.append(ch);
               i++;
            }
        }


      return currStr.toString();
    }
}