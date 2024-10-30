// Time Complexity : O(Length * product of all integers: K)
// Space Complexity :O(Length * product of all integers: K)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//DFS
class Solution {
    int i =0;
    public String decodeString(String s) {
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        while(i < s.length())
        {
            char c = s.charAt(i);
            i++;
            if(Character.isDigit(c))
            {
                currNum = currNum*10+c-'0';
            }
            else if(c=='[')
            {
                String baby = decodeString(s);
                for(int k = 0;k<currNum;k++)
                {
                    currStr.append(baby);
                }
                currNum=0;
            }
            else if(c==']')
            {
                return currStr.toString();
            }
            else
            {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}

// Time Complexity : O(m*n)
// Space Complexity :O(m*n) for DFS (it was min(m,n) in case BFS
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes. syntax error plus logical error
//DFS
class Solution {
    int m;
    int n;
    int [][] dirs;
    public int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i,int j)
    {
        if(i<0||j<0||i>=m||j>=n||grid[i][j]!='1') return;
        grid[i][j] = '0';
        for(int[] dir:dirs)
        {
            int r = dir[0]+i;
            int c= dir[1]+j;
            dfs(grid, r, c);
        }
    }
}
