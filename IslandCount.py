#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Dec 27 09:33:41 2019

@author: tanvirkaur
"""

#BFS apprach used 
# time complexity = O(n*m)
# space complexity = O(n*m) if we consider the recursion stack 


class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        count = 0
        self.dirs = [(1,0),(-1,0),(0,1),(0,-1)]
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    self.helper(grid,i,j)
                    count += 1
        return count
            
        
    def helper(self,grid,i,j):
        # base condition
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] == '0':
            return 
        #logic
        grid[i][j] = '0'
        for dir in self.dirs:
            x = i + dir[0]
            y = j + dir[1]
            self.helper(grid,x,y)
        