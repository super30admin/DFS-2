class Solution(object):
    def decodeString(self, s):
        '''
        time: O(#length of final string)
        space: O(#length of final string)
        '''
        num_stack = []
        str_stack = []
        cur_num = 0
        cur_str = ""
        for i in range(len(s)):
            if s[i].isdigit():
                cur_num = cur_num * 10 + int(s[i])
            elif s[i] == "[":
                num_stack.append(cur_num)
                str_stack.append(cur_str)
                cur_num = 0
                cur_str = ""
            elif s[i] == "]":
                cur_freq = num_stack.pop()
                cur_str = str_stack.pop() + cur_freq * cur_str
            else:
                 cur_str += s[i]
        return cur_str

    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        time: O(mn)
        space: O(mn)
        """
        def bfs(x,y):
            q = deque([(x,y)])
            while q:
                cx, cy = q.popleft()
                for dx, dy in [(0,1),(0,-1),(1,0),(-1,0)]:
                    nx, ny = cx+dx, cy+dy
                    if 0<=nx<len(grid) and 0<=ny<len(grid[0]) and (nx,ny) and grid[nx][ny] == "1":
                        grid[nx][ny] = "2"
                        q.append((nx,ny))
        
        num_islands = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    bfs(i,j)
                    num_islands += 1
        return num_islands