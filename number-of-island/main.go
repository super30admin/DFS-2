package main

import "fmt"

func numIslands(grid [][]byte) int {
	m := len(grid)
	n := len(grid[0])

	dirs := [][]int{
		[]int{-1, 0}, // up
		[]int{0, -1}, //left
		[]int{0, 1},  // right
		[]int{1, 0},  // down
	}
	fmt.Println(grid)
	count := 0
	q := [][]int{}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 49 { // 1 - hack to compare to 1
				fmt.Println("inside if")
				count++
				q = append(q, []int{i, j})
				grid[i][j] = 48   // 0
				for len(q) != 0 { //lmao this can be int still
					dq := q[0]
					q = q[1:]
					r := dq[0]
					c := dq[1]
					for _, v := range dirs {
						nr := r + v[0]
						nc := c + v[1]
						// bound
						if nr >= 0 && nc >= 0 && nr < m && nc < n {
							if grid[nr][nc] == 49 {
								q = append(q, []int{nr, nc})
								grid[nr][nc] = 48 // 0
							}
						}
					}
				}
				//run bfs

			}
		}
	}
	return count
}
