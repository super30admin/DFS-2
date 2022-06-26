"""
Leetcode-https://leetcode.com/problems/decode-string/ (submitted)
TC- O(output-string), SC- O(1) auxiliary DFS
Challenges- DFS solution was challenging to create
Lecture-https://youtu.be/NCnxoc4RDLg
FAQ-


Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly
k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed,
etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"


Constraints:
1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
"""


class Solution:
    """
    Ideation-iterative using stack O(output-string) time and O(N) space
    Notice that we will need to decode the inner string first and build it to the parent to get our desired result.
    Hence, it should be obvious to use stack. Now, what steps will take to get to decode a simplest string 'a3[b]',
    we will first solve 3[b], i.e., bbb, and then add its parent. So our final string will be 'a' + 'bbb'.

    Now let's scale it, for string 'a2[b3[cd]]', we will need to store the multiplier and the parent in the stack before
    we go to our sub-problem, in other words, if we hit '[' we will push the multiplier and parent in the stack. Then
    store our alpha 'cd' until we hit ']'. When we hit ']', we will use the current string and repeat it multiplier
    times, and then pop the parent and append it to the beginning.

    Once all the ']' are finished by above followed steps, we will have our result string.

    We will also have to take care of multi digit numbers, so we get the right number.
    """

    def __init__(self):
        self.ind = 0

    def decodeString(self, s):
        stAlpha = []
        stNum = []
        num = ''
        alpha = ''
        for c in s:
            if ord('0') <= ord(c) <= ord('9'):
                num += c
            if ord('a') <= ord(c) <= ord('z'):
                alpha += c
            # push parent and multiplier in stack and reset them
            if c == '[':
                stNum.append(num)
                stAlpha.append(alpha)
                num = ''
                alpha = ''
            # repeat the string 'k' times and append parent
            if c == ']':
                k = int(stNum.pop())
                newAlpha = ''
                for _ in range(k):
                    newAlpha += alpha
                alpha = newAlpha
                parent = stAlpha.pop()
                alpha = parent + alpha

        return alpha

    """
    Ideation- DFS O(output-string) time and O(1) space
    Notice where the repetition will happen, anything inside '[' will start a new baby and ']' will return the baby
    to parent. Call DFS on that.
    
    Also, to keep the string moving and not reset its own index 'i', we need to declare it in global variable
    
    Also, beware of index 'i' changing inside while loop can cause index out of range, handle that.
    """

    def decodeString1(self, s):
        num = ''
        alpha = ''
        while self.ind < len(s):
            if ord('0') <= ord(s[self.ind]) <= ord('9'):
                num += s[self.ind]
                self.ind += 1
                # continue statements after every if so we don't go out of index since it's a while loop
                continue
            if ord('a') <= ord(s[self.ind]) <= ord('z'):
                alpha += s[self.ind]
                self.ind += 1
                continue
            if s[self.ind] == '[':
                self.ind += 1
                # call recursion on baby - alpha and num is for parent
                decodedString = self.decodeString1(s)
                # multiplier will be current num
                temp = ''
                for _ in range(int(num)):
                    temp += decodedString
                # alpha is the parent, append with decoded string multiplied
                alpha = alpha + temp
                # reset num because current num was for baby which we have finished
                num = ''
                continue
            if s[self.ind] == ']':
                self.ind += 1
                # baby finished, return it to the caller
                return alpha

        # because when the while loop finishes, final alpha (result) built up needs to return
        return alpha



inp = "2[abc]3[cd]ef"
result = Solution().decodeString1(inp)
print(result)
