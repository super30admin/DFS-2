// ## Problem2 (https://leetcode.com/problems/decode-string/)

var decodeString = function(s) {
    // //     Time Complexity: O(n + m)

// // Space Complexity: O(n + m)
//M is the product of all integers
    let index = 0; ``
    function decode() {
        let result = '';
        
        while (index < s.length && s[index] !== ']') {
            if (isNaN(s[index])) {
                result += s[index];
                index++;
            } 
            else {
                let num = 0;
                while (!isNaN(s[index])) {
                    num = num * 10 + Number(s[index]);
                    index++;
                }
                
                index++; 
                
                const substring = decode();
                
                index++; 
                
                result += substring.repeat(num);
            }
        }
        
        return result;
    }

    return decode();
};

console.log(decodeString())


// var decodeString = function(s) {
// //     Time Complexity: O(n + m)

// // Space Complexity: O(n + m)
// //where m is greater than n
//     // input : "2[abc]3[cd]ef"
//     // output : "abcabccdcdcdef"
//     let stack = []
//     for(let char of s){
//         if(char != "]"){
//             stack.push(char)
//             continue
//         }
//         //We found our first closing bracket
//         let str = ""
//         while(stack.length && stack[stack.length - 1] != "["){
//             str = stack.pop()+str
//             continue
//         }
//         stack.pop() // To pop the "["
//         console.log(str)
//         let numStr = ""
//         while(stack.length && isDigit(stack[stack.length - 1])){
//             numStr = stack.pop()+numStr
//             continue
//         }
//         let count = Number(numStr) || 0
//         console.log(count)
//         stack.push(str.repeat(count))
//     }
//       return stack.join("");
// };

// function isDigit(char){
//     return char >= "0" && char <="9"
// }