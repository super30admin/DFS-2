class Solution(object):
    def __init__(self):
        self.i=0
        
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        '''We can use DFS, that is solve the inner most bracket first, return it to the parent. Do it repeatedly using recursion. Or we can also use explict stack if we want the iterative solution.'''
        '''
        // 2 stacks method
        1. Whenever we encounter a digit, multiply the parent digit by 10 + 2
        2. Whenever we encounter an opening bracket, then push currently computed string and number to the stack and re-initialize them.
        3. Whenever we encounter a closing bracket, then pop the top element and update the final resultant string.
        else concat/ append
        
        // Recursive
        '''
        
        #1 Recursive method TC: O(len(output)) SC- O(n)
        
        stringStack=deque()
        numStack=deque()
        currentStr=""
        currNum=0
        
        while self.i<len(s):
            c=s[self.i]
            
            #check if digit
            if c.isdigit():
                currNum=currNum*10 + int(c)
                self.i+=1
            elif c == '[':
                self.i+=1
                #Recursively call on the baby
                decoded=self.decodeString(s)
                temp=""
                for j in range(currNum):
                    temp=temp+decoded
                currentStr=currentStr+temp
                currNum=0
             
            elif c== ']':
                self.i+=1
                return currentStr
            else:
                #Append to the current string 
                currentStr=currentStr+c
                self.i+=1
               
        return currentStr
