'''
Time Complexity: O(s)
Space Complexity: O(s)
'''
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        num = 0
        ss = ""
        numstack = []
        sstack = []
        for i in s:
            if(i.isnumeric()):
                num = num*10+int(i)
            elif(i.isalpha()):
                ss =  ss+i
            elif(i=='['):
                numstack.append(num)
                sstack.append(ss)
                num = 0
                ss = ""
            elif(i=="]"):
                val = numstack.pop()
                val1 = sstack.pop()
                ss = val1 + (ss*val)
        return ss        

