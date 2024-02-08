package main

import "fmt"

/* time complexity : O(n)
   space complexity : O(n)

   Leet COde : Code ran successfully in leet code.
Approach :
1. traversed through the grid[][], if came across an island (1) appended co-ordinates to visited array and incremented the result(counter)
2. Looped through visited array to check surrounding islands, If an island in encountered added it to visited array and modified respective grid value to 0.
3. returned the result
*/

func numIslands(grid [][]byte) int {
	len_i := len(grid)
	len_j := len(grid[0])
	//fmt.Println(len_i, len_j)
	var visited []visitedStruct
	var result int
	offsets := [4][2]int{{-1, 0}, {1, 0}, {0, 1}, {0, -1}}
	for i := 0; i < len_i; i++ {
		for j := 0; j < len_j; j++ {
			if grid[i][j] == '1' {
				visited = append(visited, visitedStruct{i, j})
				result++
				grid[i][j] = '0'
			}
			for len(visited) != 0 {
				current := visited[0]
				visited = visited[1:len(visited)]
				for _, offset := range offsets {
					x := current.i + offset[0]
					y := current.j + offset[1]
					if x >= 0 && x < len_i && y >= 0 && y < len_j {
						if grid[x][y] == '1' {
							visited = append(visited, visitedStruct{x, y})
							grid[x][y] = '0'
						}
					}
				}
			}
		}
	}
	fmt.Println(visited)
	return result
}

type visitedStruct struct {
	i int
	j int
}

/*func main() {
	// Example usage:
	grid := [][]byte{{'1', '0', '1'}, {'0', '1', '0'}}
	numIslands(grid)
}*/
