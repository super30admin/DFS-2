# time complexity is o(mn), where m,n is the number of rows and columns in the input repectively
# space complexity is o(mn), where m,n is the number of rows and columns in the input repectively

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
#         bfs
        m = len(mat)
        n = len(mat[0])
        direc = [[-1, 0], [1,0], [0, 1], [0, -1]]
        from collections import deque
        q = deque()
        for i in range(m):
            for j in range(n):
                if(mat[i][j] == 0):
                    q.append([i,j])
                else:
                    mat[i][j] = -1
        while(len(q) != 0):
            curr = q.popleft()
            for d in direc:
                nr = curr[0] + d[0]
                nc = curr[1] + d[1]
                if(nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1):
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1
                    q.append([nr, nc])
                    
        return mat
        
# #         maintaining a set to check the. visited nodes.
#         from collections import deque
#         q = deque()
#         m = len(mat)
#         n = len(mat[0])
#         s = set()
#         direc = [[-1, 0], [1, 0], [0, 1], [0, -1]]
#         for i in range(m):
#             for j in range(n):
#                 for d in direc:
#                     nr = i + d[0]
#                     nc = j + d[1]
#                     if(nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == 0 and mat[i][j] == 1):
#                         if((i,j) not in s):
#                             q.append([i,j])
#                             s.add((i,j))
#         while(len(q) != 0):
#             curr = q.popleft()
#             for d in direc:
#                 nr = curr[0] + d[0]
#                 nc = curr[1] + d[1]
#                 if(nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == 1 and (nr,nc) not in s):
#                     q.append([nr, nc])
#                     s.add((nr, nc))
#                     mat[nr][nc] = mat[curr[0]][curr[1]] + 1
#         return mat
                
                
                        
                    
        