// Approach : BFS 
// Time : O(mXn)
// Space : O(mXn)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length ==0) return mat;
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        // find all the independent nodes and add them to the quque
        for(int i =0;i<m;i++){
            for (int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[] {i,j});
                } else{
                    mat[i][j] = -1; // to avoid the 
                }
            }
        }

        int dist = 1; // next neighbours which will be processed will have dist 1 from current zeros
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                for(int[] dir:dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]==-1){
                        mat[nr][nc] = dist;
                        q.add(new int[] {nr,nc});
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}