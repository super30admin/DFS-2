# Time Complexity : O(n) where n is the length of the decoded string , for both DFS and BFS
# Space Complexity : O(n) space for numStack + sstrStack will hold all the elements in worst case 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class BFS:
    def decodeString(self, s):
        currstr = ''
        num = 0 
        numStack = []
        strStack = []
        for i in range(len(s)):
            char = s[i]
            if char.isdigit():
                num = num * 10 + ord(char) - ord('0')
            elif char == '[':
                numStack.append(num)
                strStack.append(currstr)
                currstr = ''
                num = 0 
            elif char == ']':
                times = numStack.pop()
                newStr = ''
                for i in range(times):
                    newStr += currstr
                currstr = strStack.pop() + newStr
            else:
                currstr += char 
        return currstr
class DFS:
    i = 0
    def decodeString(self, s):
        result = ''
        num = 0 
        while self.i < len(s):
            char = s[self.i]
            if char.isdigit():
                num = num * 10 + ord(char) - ord('0')
                self.i += 1 
            elif char == '[':
                self.i += 1 
                temp = self.decodeString(s)
                for k in range(num):
                    result += temp 
                num = 0 
            elif char == ']':
                self.i += 1 
                return result 
            else:
                result += char 
                self.i += 1 
        return result

if __name__ == "__main__":
    s = BFS()
    str1 = "3[a]2[bc]"
    res = s.decodeString(str1)
    print(res)
    
    d = DFS()
    res  = d.decodeString(str1)
    print(res)