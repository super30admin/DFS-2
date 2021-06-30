class UnionFind{
    // Time complexity: O(M * N)
    // Space complexity: O(M * N)
    int count;
    int[] parents;
    int[] ranks;
    
    public UnionFind(char[][] grid){
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        parents = new int[m * n];
        ranks = new int[m * n];
        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                if(grid[i][j] == '1'){
                    parents[i * n + j] = i * n + j;
                    ++count;
                }
                ranks[i*n + j] = 0;
            }
        }
    }
    
    public int find(int node){
        if(parents[node] != node){
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }
    
    public void union(int node1, int node2){
        int p1 = find(node1);
        int p2 = find(node2);
        
        if(p1 != p2){
            if(ranks[p1] > ranks[p2]){
                parents[p2] = p1;
            }
            if(ranks[p2] > ranks[p1]){
                parents[p1] = p2;
            }
            if(ranks[p2] == ranks[p1]){
                parents[p1] = p2;
                ranks[p2] += 1;
            }
            --count;
        }
    }
    
    public int getCount(){
        return count;
    }
    
}

class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int numIslands(char[][] grid) {
        
        UnionFind uf = new UnionFind(grid);
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    for(int[] dir : dirs){
                        int newi = i + dir[0];
                        int newj = j + dir[1];
                        if(newi >= 0 && newi < grid.length && newj >=0 && newj < grid[0].length && grid[newi][newj] == '1'){
                            uf.union(i * grid[0].length + j, newi * grid[0].length + newj);
                        }
                    }
                }
            }
        }
        
        return uf.getCount();
        
        
        
    }
    
}