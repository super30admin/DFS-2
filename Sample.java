// Time Complexity : O(length of output)
// Space Complexity : O(length of output)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        for(int i = 0; i <s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum*10 + c-'0';
            }else if(c == '['){
                strSt.push(currStr);
                numSt.push(currNum);
                currStr = new StringBuilder();
                currNum = 0;
            }else if(c == ']'){
                int count = numSt.pop();
                StringBuilder child = new StringBuilder();
                for(int k = 0; k < count; k++){
                    child.append(currStr);
                }
                StringBuilder parent = strSt.pop();
                currStr = parent.append(child);
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
// Time Complexity : O(m*n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Using BFS


class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        int count = 0;
        Queue<int []> q = new LinkedList<>(); 
        int [][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int [] curr = q.poll();
                        for(int [] dir: dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr >= 0 && nc >= 0 
                            && nr < m && nc < n && grid[nr][nc] == '1'){
                                q.add(new int [] {nr,nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        } 
        return count;
    }
}

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Using DFS

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        int count = 0; 
        int [][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i,j,m,n,dirs);
                    }
                }
            }
            return count;
    }
    private void dfs(char[][] grid, int i, int j, int m, int n, int[][] dirs){
        if(i < 0 || j < 0 || i==m || j==n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for(int [] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r,c,m,n,dirs);
        }
    }
} 





