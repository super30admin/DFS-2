// Time Complexity : O(K.n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution:
    def decodeString(self, s: str) -> str:
        def decode(i):
            
            ret = [] 
            num = [] 
            
            j = i
            while j < len(s):
                x = s[j]
                
                if x.isalpha():
                    ret.append(x)
                elif x.isnumeric():
                    num.append(x)
                elif x == "[":
                    r = int("".join(num))
                    j, t = decode(j+1)
                    ret.append(t*r)
                    num = []
                elif x == "]":
                    return j, "".join(ret)               
                j += 1
                
            return j, "".join(ret)
    
        return decode(0)[1]