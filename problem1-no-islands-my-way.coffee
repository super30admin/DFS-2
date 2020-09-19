#** https://leetcode.com/problems/employee-importance/
#// Time Complexity :
#// Space Complexity :
#// Did this code successfully run on Leetcode :
#// Any problem you faced while coding this :
#
#// Your code here along with comments explaining your approach
#
# numIslands = 0
# for each element in grid
#   if element is water
#     skip this element
#   else
#     numIslands += 1
#     do a dfs converting this and all neighbors to land
#
# return numIslands

# dfs on element
#   for each direction in [up, down, left, right]
#      if element + direction is invalid
#        skip this direction
#      if element is water
#        skip this direction
#      else
#        mark it as water so it will be skipped
#        dfs (recursive) on element + direction

LAND = '1'
WATER = '0'

numIslands = (grid) ->
  return 0 if grid is null or grid.length is 0 or grid[0].length is 0

  maxX = grid[0].length
  maxY = grid.length
  directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]

  dfsNeighborsLandToWater = (y, x) ->
    return if !(0 <= y < maxY and 0 <= x < maxX)
    return if grid[y][x] is WATER
    grid[y][x] = WATER
    for [dirX, dirY] in directions
      dfsNeighborsLandToWater(y + dirY, x + dirX)

  countIslands = 0
  for row in [0...maxY]
    for col in [0...maxX]
      continue if grid[row][col] is WATER
      countIslands += 1
      dfsNeighborsLandToWater(row, col)

  countIslands

numIslands([
  ['1','0'],
]) is 1
numIslands([
  ['1', '1','0'],
]) is 1
#numIslands([
#  ['1','1','1','0'],
#  ['1','1','1','0'],
#  ['0','0','0','0']
#]) is 1
