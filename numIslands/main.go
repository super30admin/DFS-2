
// following similar pattern as rotting oranges

func numIslands(grid [][]byte) int {
 
    if grid == nil {
        return 0
    }
    count := 0
    q := [][]int{}
    m := len(grid)
    n := len(grid[0])
    dirs := [][]int{ {0,-1}, {0,1}, {-1, 0}, {1,0} }
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid[i][j] == 49 {
                q = append(q, []int{i,j})    
                for len(q) != 0 {
                    qSize := len(q)
                    for qSize != 0 {
                        dq := q[0]
                        q = q[1:]
                        for _, dir := range dirs {
                            r := dq[0] + dir[0]
                            c := dq[1] + dir[1]
                            if r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 49 {
                                grid[r][c] = 48
                                q = append(q, []int{r,c})
                            }
                        }
                        qSize--
                    }
                }
                count++
            }
            grid[i][j] = 48
        }
    }
    return count 
}
