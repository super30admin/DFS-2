/**
 * @param {string} s
 * @return {string}
 */
var decodeString = function(s) {
    let numStack = [];
    let strStack = [];
    let num = 0;
    let currStr = '';
    let sol ="";
    for(i=0;i<s.length;i++){
        //case1 : if char is number
        if(!isNaN(s[i])){
           num = num*10 + parseInt(s[i]);
          } else if(s[i] === '['){
              numStack.push(num);
              strStack.push(currStr);
              num = 0;
              currStr = "";
              
              
          }else if(s[i] === ']'){
              let stacknum = numStack.pop();
              let stackstr = strStack.pop();
              let multiply = "";
              for(j = 0 ; j<stacknum; j++){
                  multiply = multiply + currStr;
              }
              currStr =  stackstr + multiply;
              
              
          } else {
              currStr = currStr + s[i];
          }
    }
return currStr;
    
};

//time complexity : O(length of decode string) decode string(output)
//space complexity : O(n) , n: length of the encode string(input)