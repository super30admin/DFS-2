'''
PROBLEM 1

TIME COMPLEXITY: O(m*n)
SPACE COMPLEXITY: O(min(m,n))

- for every node, if its value is 1, change it to 0 and add it to the queue
- apply BFS on all the neighbours of the node if the value is 1 and keep changing the visited nodes to 0
- increment count whenever a node with value 1 occurs
'''

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid)==0:
            return 0
        queue=[]
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        count=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                # print("i",i)
                # print("j",j)
                if grid[i][j]=='1':
                    grid[i][j]='0'
                    queue.append([i,j])
                    count+=1
                while(len(queue)!=0):
                    curr=queue.pop(0)
                    
                    for d in dirs:
                        row=curr[0]+d[0]
                        col=curr[1]+d[1]
                        
                        if row>=0 and row<len(grid) and col>=0 and col<len(grid[0]) and grid[row][col]=='1':
                            grid[row][col]='0'
                            queue.append([row,col])
        return count
                    
'''
PROBLEM 2

TIME COMPLEXITY: O(N*k)
SPACE COMPLEXITY: O(N)

- while iterating the queue, maintain two stacks, one for the numbers and one for the string
- while iterating, if current character is number, keep building the number, id it is character, keep building the variable current_string, if it is opening bracket, add
number and current_string to the stacks and reset them
-  when a closing bracket is encountered, multiply the current_string k times where k is popped from number stack
'''


class Solution:
    def decodeString(self, s: str) -> str:
        
        numStack=[]
        strStack=[]
        num=0
        currStr=''
        # print(int(s[0]))
        for i in s:
            if i.isdigit():
                num=num*10 + int(i)
            elif i.isalnum():
                currStr+=i
            elif i=='[':
                numStack.append(num)
                strStack.append(currStr)
                currStr=''
                num=0
            elif i==']':
                times=numStack.pop()
                temp=currStr
                for i in range(times-1):
                    currStr+=temp
                outer=strStack.pop()
                currStr= outer+currStr
                
        return currStr
                