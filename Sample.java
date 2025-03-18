// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//BFS
//TIME COMPLEXITY : O(M*N)
// SPACE COMPLEXITY :O(M+N)
class Solution {
    int count =0;
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs= {{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
        for (int i=0;i<m ;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> q = new LinkedList<>(); 
                    q.add(new int[]{i,j});
                    grid[i][j] = '2';
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for (int[] dir:dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if (nr < m && nr >=0 && nc < n && nc>=0 && grid[nr][nc] =='1') {
                                q.add(new int[]{nr,nc});
                                grid[nr][nc] = '2';
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}


//TC :O(m*n)
//sc : O(m*n)
//DFS 
class Solution {
    int count =0;
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs= {{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
        for (int i=0;i<m ;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '2';
                    dfs(i, j, dirs, m, n, grid);
                }
            }
        }
        return count;

    }
    private void dfs(int i, int j, int[][] dirs, int m, int n, char[][] grid) {
        for (int[] dir:dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr < m && nr >=0 && nc < n && nc>=0 && grid[nr][nc] =='1') {
                grid[nr][nc] = '2';
                dfs(nr,nc,dirs, m, n, grid);
            }
        }
        return;
    }
}




class Solution {
    public String decodeString(String s) {
        

        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> numstack = new Stack<>();
        Stack<StringBuilder> strstack = new Stack<>();
        int num=0;
        StringBuilder currstr = new StringBuilder();
        for (int i=0;i<sb.length();i++) {
            char c = sb.charAt(i);
            if (Character.isDigit(c)) {
                int currnum = c-'0';
                num = 10*num + currnum;
            } else if (c == '[') {
                numstack.push(num);
                strstack.push(currstr);
                num=0;
                currstr=new StringBuilder();
            } else if (c == ']') {
                int times=numstack.pop();
                StringBuilder newstr = new StringBuilder();
                for (int j=0;j<times;j++) {
                    newstr.append(currstr);
                }
                currstr = strstack.pop().append(newstr);
            } else {
               currstr.append(sb.charAt(i));
            }
        }
        return currstr.toString();

    }
}
