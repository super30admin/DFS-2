# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def decodeString(self, s: str) -> str:
        
        stack = collections.deque()
        ans = collections.deque() # Maintain deque for storing answer and return .join of it
        
        for i in s:
            stack.append(i) # Push everything in s to the stack
        
        count = 0 # Count represents the number of braces that are currently left to process
        
        sub_str = collections.deque()
        
        while(stack):
            
            print(stack)
            print(count)
            
            if count == 0:
                ans.extendleft(sub_str)
                sub_str = collections.deque()
                
            curr = stack.pop()
            
            if curr == ']':
                count += 1
                
            elif curr == '[':
                count -= 1
                digit = 0
                # Note that we only encounter numbers only after '[' in the stack
                while stack and stack[-1].isdigit():
                    digit = int(stack.pop()) + digit*10
                
                print(digit)
                
                temp = list(sub_str)
                for j in range(digit-1): # digit-1 because one count is already in the sub_str
                    for k in temp:
                        sub_str.appendleft(k)
            else:
                sub_str.appendleft(curr)
            
        return ''.join(ans)
                        
            
            