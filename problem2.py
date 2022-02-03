#TIme Complexity =O(n)
#Space Complexity = O(h)
class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        currstr = ""
        currNo = 0
        
        for i in s:
            if(i=="["):
                stack.append(currNo)
                stack.append(currstr)
                currNo = 0
                currstr=""
                
            elif(i=="]"):
                s = stack.pop()
                no = stack.pop()
                currstr =s+ no*currstr 
                currNo = 0
                
            elif(i.isdigit()):
                currNo = currNo*10 +int(i)
            else:
                currstr+=i
        return currstr