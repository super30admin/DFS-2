#time complexity: O(m*n)
#space complexity: O(m*n)
#ran on leetcode: Yes
#initialize a queue inorder to perform a BFS. Traverse through the matirx. Start from BFS from i,j if this cordinate is '1' and has not been visited. Finally return a count of number of BFS operations that were performed. THis indicates the number of islands
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited=[]
        for i in range(len(grid)):
            temp=[]
            for j in range(len(grid[0])):
                temp.append(False)
            visited.append(temp)
        #print(visited)
        count=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if(grid[i][j]=='1' and visited[i][j]==False):
                    #print(i,j)
                    count=count+1
                    stk=[]
                    stk.append((i,j))
                    while(stk!=[]):
                        curr=stk[-1]
                        del(stk[-1])
                        visited[curr[0]][curr[1]]=True
                        I=curr[0]
                        J=curr[1]
                        if(I!=0 and grid[I-1][J]=='1' and visited[I-1][J]==False ):
                            stk.append((I-1,J))
                        if(I!=len(grid)-1 and grid[I+1][J]=='1' and visited[I+1][J]==False):
                            stk.append((I+1,J))
                        if(J!=0 and grid[I][J-1]=='1' and visited[I][J-1]==False):
                            stk.append((I,J-1))
                        if(J!=len(grid[0])-1 and grid[I][J+1]=='1' and visited[I][J+1]==False):
                            stk.append((I,J+1))
        #print(visited)
        
        return count
                        
