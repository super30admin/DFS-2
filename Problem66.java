// Time Complexity : O(m*n)
// Space Complexity : O(m*n)

class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = gri