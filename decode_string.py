#Time Complexity :  O(maxK⋅n).
#Space Complexity :O(m+n)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s)==0:
            return s
        
        num_stack =[]
        string_stack = []
        num = 0
        string = ''
        for item in s:
            #digit
            if item.isdigit():
                num = num*10+int(item)
                
            elif  item == '[':
                num_stack.append(num)
                string_stack.append(string)
                num = 0
                string = ''
                
            
            elif item == ']':
                num_pop = num_stack.pop()
                string = num_pop*string
                string = string_stack.pop()+string
            else:
                string=string+item
        return string