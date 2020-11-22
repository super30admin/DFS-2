#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 22 15:23:20 2019

@author: tanvirkaur
"""

#BFS apprach used 
# time complexity = O(n)
# space complexity = O(n)
# we put first one into the queue and then pop it and then all the neighbours that are one are appended into the queue and continue this untill we have visited all the neighbours. Then we increment the count and find the next 0ne that is not visited yet and visit all its neighbour.

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        visited = set()
        q = []
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1' and (i,j) not in visited:
                    visited.add((i,j))
                    q.append((i,j))
                    while q:
                        r,c = q.pop(0)
                        for nr,nc in self.neighbours(r,c,grid):
                            if grid[nr][nc] == '1'and (nr,nc) not in visited:
                                q.append((nr,nc))
                                visited.add((nr,nc))
                    count += 1
        return count
                                
                        
    def neighbours(self,r,c,grid):
        for nr,nc in ((r-1,c),(r+1,c),(r,c+1),(r,c-1)):
            if 0<=nr < len(grid) and 0<=nc<len(grid[0]):
                yield nr,nc