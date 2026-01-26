// In this problem, we are given a pattern and we need to decode it according to the rules. We use two stacks to keep track of the numbers and the strings as we parse through the input string.
// when we encounter a digit, we build the current number. When we see '[' we push the current string and number onto their stacks and reset them. When we see ']' we pop from both stacks and build the string and join it with parent string.
// Time Complexity: O(n × k) where n is the length of the string and k is the maximum repeat count
// Space Complexity: O(n × k) for the stacks used to store numbers and strings.
class Solution {
    fun decodeString(s: String): String {
        val numSt = ArrayDeque<Int>()
        val strSt = ArrayDeque<StringBuilder>()

        var currNum = 0
        var currStr = StringBuilder()

        for(ch in s) {
            when {
                ch.isDigit() -> {
                    currNum = currNum * 10 + (ch - '0')
                }
                ch == '[' -> {
                    strSt.addLast(currStr)
                    numSt.addLast(currNum)
                    currStr = StringBuilder()
                    currNum = 0
                }
                ch == ']' -> {
                    val count = numSt.removeLast()
                    val parent = strSt.removeLast()
                    repeat(count) {
                        parent.append(currStr)
                    }
                    currStr = parent
                }
                else -> {
                    currStr.append(ch)
                }
            }
        }
        return currStr.toString()
    }
}