// Problem2 (https://leetcode.com/problems/decode-string/)

// DFS & Iterative
// TC: O(nk); n is the number str length, k is the largest number in the string(as the substring will be repeated thet number of times)
// SC: O(n) 

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
/**
 * @param {string} s
 * @return {string}
 */
var decodeString = function (s) {
    if (s === null || s.length === 0)
        return "";
    // Monitor the string formed and number of times it has to be repeated
    let strStack = [];
    let numStack = [];
    let num = 0;
    let currStr = "";

    for (let i = 0; i < s.length; i++) {
        let ch = s[i];
        if (ch.match(/^[0-9]$/)) {
            num = num * 10 + Number(ch);
        } else if (ch === "[") {
            // Push into stack
            numStack.push(num);
            strStack.push(currStr);
            num = 0;
            currStr = "";
        } else if (ch === "]") {
            // Pop from the stack
            // Create a new str which is currStr repeated numStack.pop times
            let newStr = "";
            let times = numStack.pop();
            for (let i = 0; i < times; i++) {
                newStr += currStr;
            }
            // Append it to popped string and set it as curr str
            currStr = strStack.pop() + newStr;
        } else {
            currStr += ch;
        }
    }
    return currStr;
};