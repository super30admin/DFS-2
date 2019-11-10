"""DFS approach using 2 stacks"""
#Accepted on leetcode
#Time complexity - O(N) where N is the length of the given string
#Space complexity - O(2N) which O(N) as we are using 2 stacks



class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        num = [] #Numstack
        stri = [] # stringstack
        currStr = ''
        #b=''
        new_strin = ''
        currNum = ''
        for i in s:
            #Case1
            if i.isdigit():
                currNum = currNum + i
            #Case2
            elif i == '[':
                num.append(int(currNum))
                stri.append(currStr)
                currNum = ''
                currStr = ''
            #Case3
            elif i == ']':
                times = num.pop()
                new_strin = stri.pop()
                currStr = new_strin + times * currStr
            #Case4              
            else:
                currStr += i
        return currStr