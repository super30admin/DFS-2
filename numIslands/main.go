/*

    we have connected components!
    A cell with 1 and its surronding 1's make up an island.
    But its not just immediate surrondings, its surroundings, surroundings surroindings... and so forth
    ( surrondings onl4 4 direction )
    
    Connected components == BFS/DFS
    
    approach BFS:
    - Starting node / independent nodes 
    - Here since we are counting all possible islands, then all 1's will be our starting positions
    - Which means we will deploy a BFS on each position that has a 1
    - Mark the node visited and start BFS
    - In BFS we will look for neighbouring 1's and mark each node visited.
    - Once the whole BFS is finished ( no more lands to process ), thats ONE island
    - numIslands++
    - Now repeat BFS on next 1 we discover.
    
    Time: o(mn)
    Space: o(min(m,n)) -- At each iteration, BFS queue at max will have min(m,n) where m is row and n is col
    
    
    approach DFS:
    - Same approach as BFS
    - Loop over grid
    - We run into a 1, deploy DFS on this position
    - DFS will mark the node visited and deploy DFS recursively in all 4 directions
    - The base cases will be responsible for checking whether we are going to process this position or not
        - bound check
        - is this node a land?
    - Once DFS on 1 land is finished going as far as it could, numIslands++
    - Now repeat DFS on next 1 we discover
    
    DFS time: o(mn)
    Total time: o(mn) 
        because if we have full grid of 1's then the first DFS will mark all nodes visited and then we will never deploy DFS again
    Space: o(mn) 
        worse case we have all 1's and we end up recursing and filling out the entire stack with all 1's (i.e all positions of neighbours .. neighbours ) 
*/



// bfs
// func numIslands(grid [][]byte) int {
//     num := 0
//     q := [][]int{}
//     dirs := [][]int{{1,0},{-1,0},{0,1},{0,-1}}
//     m := len(grid)
//     n := len(grid[0])
//     for i := 0; i < m; i++ {
//         for j := 0; j < n; j++ {
//             if grid[i][j] == '1' {
                
//                 q = append(q, []int{i,j})
//                 // mark the land visited so we do not re-add it from other childs
//                 grid[i][j] = '0'
//                 for len(q) != 0 {
//                     dq := q[0]
//                     q = q[1:]
//                     for _, dir := range dirs {
//                         r := dq[0] + dir[0]
//                         c := dq[1] + dir[1]
//                         if r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1' {
//                             // mark the land visited so we do not re-add it from other childs
//                             grid[r][c] = '0'
//                             // enqueue this node because this is connected components,
//                             // we need to find this nodes neighbours
//                             // its neighbours neighbours... ( all neighbouring lands as far as we can go )
//                             q = append(q, []int{r,c})
//                         }
//                     }
//                 }
//                 num++
//             }
//         }
//     }
//     return num
// }


// dfs
func numIslands(grid [][]byte) int {
    
    var num int
    var dfs func(r,c int)
    dirs := [][]int{{1,0},{-1,0},{0,1},{0,-1}}
    m := len(grid)
    n := len(grid[0])
    
    dfs = func(r,c int) {
        // base
        if r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != '1' {return}
        
        // logic
        // mark the land visited
        grid[r][c] = '0'
        // then find all connected lands ( connected components as far as we can )
        for _, dir := range dirs {
            dfs(r+dir[0], c+dir[1])
        }
    }
    
    for i := 0; i < m; i++ {
        for j := 0; j < n ; j++ {
            if grid[i][j] == '1' {
                dfs(i,j)
                num++
            }
        }
    }
    
    return num
}



