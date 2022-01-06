
class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        # Time Complexity: O(len(s))
        # Space Complexity: O(len(s))
        stack = []
        i = 0
        ans = ''
        while i < len(s):
            if s[i] != ']':
                stack.append(s[i])
                i += 1
            else:
                temp = []
                curr = stack.pop()
                while curr != '[':
                    temp.append(curr)
                    curr = stack.pop()
                val = []
                t = stack.pop()
                while t.isnumeric():
                    val.append(t)
                    if len(stack) != 0:
                        t = stack.pop()
                    else:
                        break
                if t.isnumeric() == False:
                    
                    stack.append(t)
                temp = temp [::-1]
                st = ''.join(temp)
                val = val[::-1]
                val = int(''.join(val))
                stack.append(st*(val))
                i += 1
        return ''.join(stack)
        
                
