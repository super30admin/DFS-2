// Time Complexity : O(M*N)
// Space Complexity : O(min(M,N))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//bfs
var numIslands = function(grid) {
    if(grid == null || grid.length == 0) return 0
    let m = grid.length, n = grid[0].length;
    let q = [];
    let count = 0
    let dirs = [[0,1],[1,0],[-1,0],[0,-1]];
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(grid[i][j] == "1"){
                count++
                q.push([i,j]);
                //console.log(q)
                grid[i][j] = '0';
                while(q.length > 0){
                    let curr = q.shift();
                    for(let dir of dirs){
                        let r = curr[0] + dir[0] 
                        let c = curr[1] + dir[1]
                        if(r >=0 && c >= 0 && r < m && c < n && grid[r][c] == "1"){
                            q.push([r,c]);
                            grid[r][c] = '0'
                        }
                    }
                }
            }
        }
    }
    return count
};


//dfs

var numIslands = function(grid) {
    if(grid == null || grid.length == 0) return 0
    let m = grid.length, n = grid[0].length;
    let count = 0
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(grid[i][j] == "1"){
                count++
                dfs(grid, i, j)
            }
        }
    }
    
    
    function dfs(grid, i, j){
        let dirs = [[0,1],[1,0],[-1,0],[0,-1]];
        //base case
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return
        
        
        //logic
        grid[i][j] = '0';
        for(const dir of dirs){
            let r = dir[0] + i;
            let c = dir[1] + j;
            dfs(grid, r, c);
        }
    }
    return count
};