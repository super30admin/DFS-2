/*********************PROBLEM-1********************/

// Time Complexity : 0(m*n)
// Space Complexity : 0(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// BFS loop throung the grid anf search the connected islands till we dont find any
// 1 as neighbours


class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null ||grid.length==0){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;

        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j]='2';
                    while(!q.isEmpty()){
                        int[] curr=q.poll();
                        for(int[] dir:dirs){
                            int nr=curr[0]+dir[0];
                            int nc=curr[1]+dir[1];
                            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1'){
                                q.add(new int[]{nr,nc});
                                grid[nr][nc]='2';
                            }
                        }
                    }
                }

            }
        }
        return count;
    }
}

// Time Complexity : 0(m*n)
// Space Complexity : 0(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// DFS and counting the number of times DFS is done
class Solution {
    int m,n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid.length==0 || grid==null){
            return 0;
        }
        m=grid.length;
        n=grid[0].length;
        int count=0;
        dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;

    }

    private void dfs(char[][] grid,int row, int col){
        if(row<0 || col<0 || row==m || col==n || grid[row][col]!='1' ){
            return;
        }

        grid[row][col]='2';
        for(int[] dir:dirs){
            int nr=row+dir[0];
            int nc=col+dir[1];
            dfs(grid,nr,nc);
        }
    }
}

/******************************PROBLEM-2********************/

// Time Complexity : 0(n)
// Space Complexity : 0(d) d=max depth of brackets
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public String decodeString(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        StringBuilder currStr= new StringBuilder();
        Stack<Integer> numStack= new Stack<>();
        Stack<StringBuilder> strStack= new Stack<>();
        int num=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10 +(c-'0');
            }else if(c=='['){
                numStack.push(num);
                num=0;
                strStack.push(currStr);
                currStr=new StringBuilder();

            }else if(c==']'){
                int times=numStack.pop();
                StringBuilder newStr=new StringBuilder();
                for(int j=0;j<times;j++){
                    newStr.append(currStr);
                }
                currStr=strStack.pop().append(newStr);
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}