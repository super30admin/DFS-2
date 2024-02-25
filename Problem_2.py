#
# @lc app=leetcode id=394 lang=python3
#
# [394] Decode String
#

# @lc code=start
'''
Time Complexity - O(n) for both iterative and recursiveNumber of character to be printed. As that is number of times we will running the loop
Space Complexity - O(n). we are maintaining a stacks in both recursive and iterative.

Both codes work on leetcode
'''
from collections import deque
class Solution:
    def __init__(self):
        self.i = 0
    def decodeString(self, s: str) -> str:
        numStack = deque() #create a numStack
        strStack = deque() #create a StringStack
        currNum = 0 #set a current number
        currString = "" #set a current string
        for i in range(len(s)): #iterate the string
            c = s[i] #take each character
            if c.isdigit():
                currNum = currNum*10+ord(c) - ord("0") #if its a number, multiply the previous by 10 and add to it
            elif c == "[": #if we encounter a [ we put the current string which is the parent and the current Number onto the stack, the number will apply to whats inside the bracket
                strStack.append(currString) 
                numStack.append(currNum)
                currNum = 0 #reset the current Number and the current String
                currString = ""
            elif c=="]": #if we find a ] then pop from the numStack and StrStack. number applies to the currString and then the decoded sequence is merged with what we pop from the String Stack
                cnt = numStack.pop()
                decodedBaby = ""
                for k in range(cnt): #if the number is greater that 1 then the current String sequence is considered that many times
                    decodedBaby = decodedBaby + currString
                parent = strStack.pop()
                currString = parent + decodedBaby #here we merge the decoded string and parent string (which is the one we popped). 
                                                    
            else: #otherwise character is alphabet and we can keep appending it to current string
                currString += c
        #DFS Recursive
        # while(self.i<len(s)): #we keep i global as we need it for every recursion with next character
        #     c = s[self.i]
        #     if c.isdigit(): #check if character is digit
        #         currNum = currNum*10+ord(c)-ord("0") #multiply current Num with 10 and add the number
        #         self.i+=1 #move i to next character
        #     elif c == "[": #if character is [
        #         self.i+=1 #move i to next character
        #         babyString = self.decodeString(s) #start recursion with i pointing to next character. if we encounter a ] this string will be returned into babyString
        #         for k in range(currNum):
        #             currString+=babyString #returned string will be repeated according to currNum
        #         currNum =0 #we reset the currNum so that it can be used again
        #     elif c=="]": #if we encounter a ] move i to next character and return the current string
        #         self.i+=1
        #         return currString
        #     else:
        #         currString+=c #otherwise character is alphabet and we can keep appending it to current string 
        #         self.i+=1 
        return currString
        
# @lc code=end

