// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var m int
var n int

func numIslands(grid [][]byte) int {
    if len(grid) == 0{
        return 0
    } 
    dirs := [][]int{{-1,0},{1,0},{0,1},{0,-1}}
    total := 0
    m = len(grid)
    n = len(grid[0])
    
    for i:=0;i<m;i++{
        for j:=0;j<n;j++{
            if grid[i][j] == '1'{
                //dfs(grid,i,j)
                //BFS   
                total+=1
                q := [][]int{}
                grid[i][j] = '0'
                q = append(q,[]int{i,j})
                for len(q) > 0{
                    curr := q[0]
                    q = q[1:]
                    for _,dir := range dirs{
                        nr := dir[0] + curr[0]
                        nc := dir[1] + curr[1]
                        if nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1'{
                            grid[nr][nc] = '0'
                            q = append(q,[]int{nr,nc})
                        }
                    }
                }
            }
        }
    }
    
    return total
}

//DFS
func dfs (grid [][]byte,row,col int){
    if row < 0 || col < 0 || row == m || col == n || grid[row][col] != '1'{
        return
    } 
    
    dirs := [][]int{{-1,0},{1,0},{0,1},{0,-1}}
    
    grid[row][col] = '0'
    
    
    for _,dir := range dirs{
        nr := dir[0] + row
        nc := dir[1] + col
        dfs(grid,nr,nc)
    }
}
