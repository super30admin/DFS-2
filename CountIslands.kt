// We solve this problem using BFS to traverse each island and mark visited land cells. Everytime we find a new land cell, we increment the island count and
// explore all connected land cells using a queue.
// Time Complexity: O(m*n) where m is number of rows and n is number of columns in the grid.
// Space Complexity: O(min(m,n)) for the queue in the worst case when the grid is filled with land cells.
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val dirs = arrayOf(
            intArrayOf(-1,0),
            intArrayOf(1,0),
            intArrayOf(0,1),
            intArrayOf(0,-1)
        )

        val m = grid.size
        val n = grid[0].size
        var count = 0
        val q = ArrayDeque<IntArray>()

        for(i in 0 until m) {
            for(j in 0 until n) {
                if(grid[i][j] == '1') {
                    count++
                    grid[i][j] = '0'

                    q.addLast(intArrayOf(i,j))
                    while(q.isNotEmpty()) {
                        val curr = q.removeFirst()
                        for(dir in dirs) {
                            val r = curr[0] + dir[0]
                            val c = curr[1] + dir[1]

                            if (r >=0 && c >= 0 && r < m && c < n && grid[r][c] == '1') {
                                q.add(intArrayOf(r, c))
                                grid[r][c] = '0'
                            }
                        }
                    }
                }
            }
        }
        return count
    }
}