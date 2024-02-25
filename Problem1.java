// ## Problem1 (https://leetcode.com/problems/number-of-islands/)

// Time Complexity : BFS - O(M*N) --> M*N(outer for loop) + M*N(BFS) --> 2M*N --> O(M*N)
// Space Complexity : BFS -  O(Max(M,N)) --> Max elements in queue 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};

    private void bfs(char[][] grid, int i, int j, int m, int n){
        Queue<Integer> q=new LinkedList<>();
        // Mark the current as visited
        grid[i][j]='0';
        q.add(i);
        q.add(j);

        while(!q.isEmpty()){
            int cr=q.poll();
            int cc=q.poll();

            // Iterate over all neighbors
            for(int[] dir: dirs){
                int nr=cr+dir[0];
                int nc=cc+dir[1];

                // Check in bounds
                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1'){
                    // Mark the current as visited and add to queue
                    grid[nr][nc]='0';
                    q.add(nr);
                    q.add(nc);
                }
            }
        }
    }

    //1. BFS
    // Time: O(M*N) --> M*N(outer for loop) + M*N(BFS) --> 2M*N --> O(M*N)
    // Space: O(Max(M,N)) --> Max elements in queue 
    private int bfsHelper(char[][] grid){
        int count=0;
        int m=grid.length;
        int n=grid[0].length;

        // Iterate over all elements
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // Check if 1, then do a bfs on it
                if(grid[i][j]=='1'){
                    bfs(grid,i,j,m,n);
                    // We found a 1, so increment count of islands
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n){
        //base
        if(i<0||j<0||i==m||j==n||grid[i][j]=='0'){
            return;
        }

        //logic
        // Mark current as visited
        grid[i][j]='0';

        // Process all neighbors
        for(int[] dir:dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];

            // run a dfs
            dfs(grid,nr,nc,m,n);
        }
    }

    private void dfsIterative(char[][] grid, int i, int j, int m, int n){
        Stack<Integer> st=new Stack<>();

        // mark current and add to stack
        grid[i][j]='0';
        st.add(j);
        st.add(i);

        while(!st.isEmpty()){
            int cr=st.pop();
            int cc=st.pop();


            for(int[] dir:dirs){
                int nr=cr+dir[0];
                int nc=cc+dir[1];

                // Check in bounds
                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1'){
                    // Mark as visited and add to stack
                    grid[nr][nc]='0';
                    st.add(nc);
                    st.add(nr);
                }
            }
        }
    }

    //2. DFS
    // Time: O(M*N) --> M*N(outer for loop) + M*N(DFS) --> 2M*N --> O(M*N)
    // Space: O(M*N) - recursive stack space
    private int dfsHelper(char[][] grid){
        int count=0;
        int m=grid.length;
        int n=grid[0].length;

        // Iterate over all elements
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // Check if 1, then do a dfs on it
                if(grid[i][j]=='1'){
                    dfsIterative(grid,i,j,m,n);

                    // Increment count of islands
                    count++;
                }
            }
        }

        return count;
    }

    public int numIslands(char[][] grid) {
        //1. BFS
        return bfsHelper(grid);

        //2. DFS
        //return dfsHelper(grid);
    }
}