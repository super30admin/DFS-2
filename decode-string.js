// Time Complexity : O(N)
// Space Complexity : O(B) where B is the number of opening brackets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : The recursive solution requires a global variable, which messes with the
// JavaScript compiler on LeetCode.  I got it to work by resetting the variable before the last return statement (line 70).

/**
 * @param {string} s
 * @return {string}
 */

// Iterative
// var decodeString = function(s) {
//     if (s == null || s.length == 0) return '';
    
//     let stack = [],
//         currNum = 0,
//         currStr = '';
//     for (let i = 0; i < s.length; i++) {
//         let c = s[i];
//         if (parseInt(c) == c) {
//             currNum = currNum * 10 + parseInt(c);
//         } else if (c == '[') {
//             stack.push([currStr, currNum])
//             currNum = 0;
//             currStr = '';
//         } else if (c == ']') {
//             let stackPop = stack.pop(),
//                 times = stackPop[1],
//                 oldString = stackPop[0],
//                 newString = '';
//             for (let j = 0; j < times; j++) {
//                 newString += currStr;
//             }
//             currStr = oldString + newString;
//         } else {
//             currStr += c;
//         }
//     }
//     return currStr;
// };

// Recursive
let i = 0;
var decodeString = function(s) {
    if (s == null || s.length == 0) return '';
    
    let result = '',
        num = 0;
    while(i < s.length) {
        let c = s[i];
        if (parseInt(c) == c) {
            i++;
            num = num * 10 + parseInt(c);
        } else if (c == '[') {
            i++;
            let inner = decodeString(s);
            for (let j = 0; j < num; j++) {
                result += inner;
            }
            num = 0;
        } else if (c == ']') {
            i++;
            return result;
        } else {
            i++;
            result += c;
        }
    }
    i = 0;
    return result;
};
