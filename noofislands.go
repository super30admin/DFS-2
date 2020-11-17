// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set count to 0
loop each element of grid if its 1 then increment count and call helper function

in recursive function
if i, j is outside range or if value at ocation is 0 then return
set value at location to 0
recursively call all neighbours
*/
package main

import "fmt"

func numIslands(grid [][]byte) int {
	count:=0
	for i:=0;i<len(grid);i++ {
		for j:=0;j<len(grid[0]);j++{
			if grid[i][j] =='1'{
				count++
				h(grid, i, j)
			}
		}
	}
	return count
}

func h(grid [][]byte, i, j int) {
	//base
	if i < 0 || i>=len(grid) || j <0 || j>=len(grid[0]) || grid[i][j] == '0' {
		return
	}

	//logic
	dirs := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	grid[i][j] = '0'
	for x :=0;x<len(dirs);x++ {
		r := i + dirs[x][0]
		c := j + dirs[x][1]
		h(grid, r, c)
	}
}

func MainNoOfIslands() {
	fmt.Println(numIslands([][]byte{{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'},{'0','0','0','0','0'}})) //expected 1
}
