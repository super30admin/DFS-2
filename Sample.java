// Time Complexity : O(m*n) where m is number of rows and n is number of columns as each cell will be visited once during BFS or DFS
// Space Complexity : O(min(m, n)) as we will be storing element in BFS queue which we can store up to min(m, n) cells in worst case scenario. In DFS recursion stack will take depth which will be m*n in worst case scenario
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed code tutorial


// Your code here along with comments explaining your approach
// In this solution we will count the number of islands in the grid. We will use BFS approach where when 1 is encountered we will mark it 0 as visited and all 
// neighbouring cells we will explore using BFS. Whenever we will encounter 1s again we will increment count and then BFS ensures that all land in the same 
// island is visited. We can use DFS for the same as well.

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> q = new LinkedList<>();
        int result = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    result = result + 1;

                    // dfs(grid, i, j, dirs);

                    q.add(new int[]{i, j});
                    grid[i][j] = '0';

                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int[] dir: dirs) {
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];

                            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                                q.add(new int[] {nr, nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int i, int j, int[][] dirs) {

        if(i < 0 || j < 0 || 
        i == grid.length || j == grid[0].length || grid[i][j] == '0') 
        return;

        grid[i][j] = '0';
        for(int[] dir: dirs) {
            int nr = dir[0] + i;
            int nc = dir[1] + j;

            dfs(grid, nr, nc,  dirs);
        }
    }
}



// Time Complexity : O(n) where n is the length of the input string where each character is processed once
// Space Complexity : O(n) as it will be used for the stack to store intermediate strings and numbers in proportion to the input string size
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : followed code tutorial


// Your code here along with comments explaining your approach
// In this solution we will decode a string that contains pattern. We will use two stack - one to store the string that we are building and another to store the 
// current repeat count. As we will be traversing the string we will accumulate digits into currNum. When we will encounter '[' both current string and number we 
// will push then to their respective stacks. When we will encounter ']' then we will pop stored number to repeat the string and append it back to the previous 
// string. We will continue this process until entire string is traversed. We can perform same operations using recursive stack DFS algorithm as well.

class Solution {
    int idx;
    public String decodeString(String s) {
        // Stack<StringBuilder> strSt = new Stack<>();
        // Stack<Integer> numSt = new Stack<>();

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        // for(int i = 0; i < s.length(); i++) {
        while(idx < s.length()){
            // char c = s.charAt(i);
            char c = s.charAt(idx);

            if(Character.isDigit(c)) {
                currNum = currNum*10 + (c - '0');
                idx++;
            } else if (c == '[') {
                // numSt.push(currNum);
                // strSt.push(currStr);
                // currNum = 0;
                // currStr = new StringBuilder();

                idx++;
                String baby = decodeString(s);

                for(int k = 0; k < currNum; k++) {
                    currStr.append(baby);
                }

                currNum = 0;
                
            } else if (c == ']') {
                // int count = numSt.pop();
                // StringBuilder baby = new StringBuilder();
                // for(int k = 0; k < count; k++) {
                //     baby.append(currStr);
                // }

                // StringBuilder parent = strSt.pop();
                // currStr = parent.append(baby);

                idx++;
                return currStr.toString();
            } else {
                currStr.append(c);
                idx++;
            }
        }

        return currStr.toString();
    }
}


