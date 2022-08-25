class Solution(object):
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
        
        #2 Stack method TC: O(len(output)) SC- O(1)
        
        stringStack=deque()
        numStack=deque()
        currentStr=""
        currNum=0
        for i in range(len(s)):
            c=s[i]
            
            #check if digit
            if c.isdigit():
                currNum=currNum*10 + int(c)
            elif c == '[':
                #Push the curr string in string stack and num to the number stack
                stringStack.append(currentStr)
                numStack.append(currNum)
                currentStr=""
                currNum=0
             
            elif c== ']':
                #Pop from the number stack
                k=numStack.pop()
        
                #Repeating current string those many number of times
                currentStr=currentStr*k

                parent=stringStack.pop()
                currentStr=parent+currentStr
            else:
                #Append to the current string 
                currentStr=currentStr+c
                print(currentStr)
        return currentStr
