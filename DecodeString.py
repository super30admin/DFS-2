# Time Complexity : O(N)
# Space Complexity : O(N) Upper Bounded by Order N because of recursion stack. e.g. 3[2[4[5[a]]]]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def decodeString(self, s: str) -> str:
        def getClose(start):
            '''Get Index of Appropriate Closing Bracket'''
            p = start + 1
            left = 1
            while left > 0:
                if s[p] == '[':
                    left += 1
                if s[p] == ']':
                    left -= 1
                if left == 0:
                    return p
                p += 1
                
        def recur(start, end):
            curr = []
            p = start
            while p <= end:
                if s[p].isalpha(): # add to curr list
                    curr.append(s[p])
                    p += 1
                elif s[p].isdigit():
                    '''The goal here is to prepare for a recursion.'''
                    open_idx = s.find('[', p) # O(1)
                    factor = int(s[p:open_idx]) # O(1)
                    close_idx = getClose(open_idx) # effectively O(1)
                    temp = recur(open_idx + 1, close_idx - 1) 
                    temp = factor * temp
                    curr.append(temp)
                    p = close_idx + 1 
        
            return "".join(curr) 
            # rebuilding strings multiple times has poor complexity. Using "".join() does the work only once.
        
        return recur(0, len(s) - 1)