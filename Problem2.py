#Problem2 (https://leetcode.com/problems/decode-string/)
# Time Complexity: O(n x k), n is the length of the input string and k is the maximum repeat count found in the string
# Space Complexity: O(n x k)
# Approach:
# As we move through the string, we build numbers and characters until we hit an opening bracket
# Then we make a recursive call to decode everything inside the brackets and repeat it as many times as the number we built
# When we hit a closing bracket, we return that decoded part so the outer call can stitch it into the result

class Solution:
    def __init__(self):
        # this is a shared pointer that tracks where we are in the string
        # since it is stored on self, every recursive call reads and moves the same pointer
        self.pointer = 0

    def decodeString(self, s: str) -> str:
        
        current_number = 0      # this builds up the number just before an opening bracket
        current_string = []     # this holds all the characters decoded so far at this level of recursion

        # keep going until we reach the end of the string
        while self.pointer < len(s):
            character = s[self.pointer]   # read the character at the current position
            self.pointer += 1            # move the pointer forward so next time we read the next character

            if character.isdigit():
                # if it is a digit, build up the full number
                # this handles numbers with more than one digit
                current_number = current_number * 10 + int(character)
            
            elif character == '[':
                # this means everything inside these brackets needs to be decoded first
                # so we call decodeString again to handle that inner part
                extended_text = self.decodeString(s)

                # now repeat that decoded inner part as many times as our number says
                for k in range(current_number):
                    # add each character of the repeated text into our own list
                    current_string.extend(extended_text)
                    # reset the number so it does not carry over to the next bracket group
                    current_number = 0
            
            elif character == ']':
                # this means we have reached the end of our own bracket content
                # so we join everything we built and return it to the caller waiting at the matching [
                return ''.join(current_string)
            
            else:
                # this is a normal letter so we just add it to our list
                current_string.append(character)

        # this only runs at the very end for the outermost call
        # once the whole string has been read with no more closing bracket left to hit
        return ''.join(current_string)