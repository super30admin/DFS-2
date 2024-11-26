// Approach : BFS
// Time : O(m*n)
// Space : O(m*n)
class Solution {
    int[][] dirs;
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = image.length;
        this.n = image[0].length;

        // At given sr,sc 
        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        // mark it as visited
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int row = q.poll();
            int col = q.poll();
            for(int[] dir : dirs){
                // cal neighbour row , neighbour col
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc] == oldColor){
                    // flood fill the entrie image
                    q.add(nr);
                    q.add(nc);
                    image[nr][nc] = color;
                }
            }
        }

        return image;
    }
}


// Approach : DFS
// Time : O(m*n)
// Space : O(m*n)
class Solution {
    int[][] dirs;
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = image.length;
        this.n = image[0].length;

        // At given sr,sc 
        int oldColor = image[sr][sc];
        if(oldColor == color) return image;

        dfs(image,sr,sc,color,oldColor);
        
        return image;
    }

    public void dfs(int[][] image, int i, int j, int color, int oldColor){
        // base case
        if(i<0 || j<0 || i==m || j==n || image[i][j] != oldColor) return;

        image[i][j] = color;

        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j+ dir[1];

            dfs(image,nr,nc,color,oldColor);
        }
    }
}