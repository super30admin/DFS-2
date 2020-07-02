/**
 * @param {character[][]} grid
 * @return {number}
 */
//BFS
var numIslands = function(grid) {
    if(grid == null || grid.length == 0) return 0;
    let dirs = [[0,1],[0,-1],[-1,0],[1,0]];
    let q = [];
    let m = grid.length;
    let n = grid[0].length;
    let count = 0;
    for(i =0;i<m; i++){
        for(j = 0; j<n; j++){
            if(grid[i][j] == '1'){
                count = count +1;
                q.push([i,j]);
                while(q.length){
                    let curr = q.shift();
                    for(let dir of dirs){
                        let r = dir[0] + curr[0];
                        let c = dir[1] + curr[1];
                        if(r >=0 && r<m && j>=0 && j<n && grid[r][c] == '1'){
                            grid[r][c] = '0';
                            q.push([r,c]);
                        }
                    }
                }
            }
            
        }
    }
    return count;
    
};

//time complexity : O(2mxn) : mn -To iterate + mn-To mark it as zero
//space complexity : O(min(m,n))