//Problem 1: Number of islands
// Time Complexity : O(2mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Approach-> find one consecutively and in bfs/dfs manner turn neighboring 1 as 0 which showcases similar island. increment count for every level of bfs
class Solution {
    int[][] dirs;
    int m,n;
    public int numIslands(char[][] grid) {

        this.dirs= new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
        this.m=grid.length;
        this.n=grid[0].length;
        int count=0;
        //bfs approach  O(2mn) Space: Min(m,n) -> diagonal length
        Queue<int[]> que=new LinkedList<>();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i,j);
                    // que.add(new int[]{i,j});
                    // grid[i][j]='0';
                    // while(!que.isEmpty()){
                    //     int[] cur=que.poll();
                    //     for(int[] dir: dirs){
                    //     int nr=dir[0]+cur[0];
                    //     int nc=dir[1]+cur[1];
                    //         if(nr<m&&nc<n && nr>=0 && nc>=0 && grid[nr][nc]=='1'){
                    //             que.add(new int[]{nr,nc});
                    //             grid[nr][nc]='0';
                    //         }
                    //     }
                    // }
                }
        return count;
    }
    //dfs approach: O(2mn) O(mn)
    private void dfs(char[][] grid, int i, int j){
        //base
         if(i==m || j==n || i<0 || j<0 || grid[i][j]=='0'){
            return;
         }
        //logic
        grid[i][j]='0';
        for(int[] dir: dirs){
            int nr=dir[0]+i;
            int nc=dir[1]+j;
            dfs(grid,nr,nc);
        }
    }
}


//Problem 2: Decode String
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : tough on bfs but got easier on dfs


// Your code here along with comments explaining your approach
//Approach -> DFS keep a global pointer variable and keep going forward in recursion '[' on this character, else just add to resultant string.
class Solution {
    int i;
    public String decodeString(String s) {
        //TC: O(multiplication of all numbers * count of all characters which are not digits and [])
        //SC: O(Stack + CurString)
        // Stack<StringBuilder> strSt=new Stack<>();
        // Stack<Integer> numStack=new Stack<>();
        // StringBuilder curString=new StringBuilder();
        // int curNum=0; 

        // for(int i=0;i<s.length();i++){
        //     char c=s.charAt(i);
        //     //char is digit
        //     if(Character.isDigit(c)){
        //         curNum=curNum*10 +c-'0';
        //     }
        //     else if(c=='['){
        //         strSt.push(curString);
        //         numStack.push(curNum);
        //         curString=new StringBuilder();
        //         curNum=0;
        //     }else if(c==']'){
        //         int numStackPop=numStack.pop();
        //         StringBuilder baby=new StringBuilder();
        //         for(int j=0;j<numStackPop;j++)
        //             baby.append(curString);
        //         StringBuilder parent= strSt.pop();
        //         curString=parent.append(baby);
        //     }else{
        //         curString.append(c);
        //     }
        // }
        // return curString.toString();

        //recursive solution
        int curNum=0;
        StringBuilder curString=new StringBuilder();
        while(i<s.length()){
            char c= s.charAt(i);
            if(Character.isDigit(c)){
                i++;
                curNum=curNum*10 +(c-'0');
            }
            else if(c=='['){
                i++;
                String baby = decodeString(s);
                for(int j=0;j<curNum;j++)
                    curString.append(baby);
                curNum=0;
            }
            else if(c==']'){
                i++;
                return curString.toString();
            }
            else{
                i++;
                curString=curString.append(c);
            }
        }
        return curString.toString();
    }
}