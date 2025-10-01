/*
- Approach1: When we try to decode the string, we decode the inner most(deepest) level first. That kind of give away the idea of using a stack. 
- What kind of stack -> two stacks: one to store the string and another to store the integer
- We will also need currNum and currString:
    currNum: to built more than 1 digit number -> currNum * 10 + character - 'a'
    currString: to append it to the parent string

TC: O(k1*k2*k3*..kn * m) -> m is max depth and k1,k2,k3,...,kn are the numbers encountered in the string -> O(k*m)
SC: O(m * max string length) -> depth of the tree - inner most depth for stack - consecutive '[' brackets -> O(k*m)
 */

class Solution {
    public String decodeString(String s) {
        Stack<Integer> inSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                // 1->12->122
                currNum = currNum * 10 + ch - '0'; 
            }
            // new baby is starting so push the parent (currNum and currStr) in the stack and reset the variables to store new baby
            else if(ch == '['){
                inSt.push(currNum);
                strSt.push(currStr);

                currNum = 0;
                currStr = new StringBuilder();
            }
            // baby over, merge it with the parent and mulitply it but ct times
            else if(ch == ']'){
                int ct = inSt.pop();
                StringBuilder parent = strSt.pop();

                for(int i = 0; i < ct; i++){
                    parent.append(currStr);
                }
                currStr = parent;
            }
            else{
                // ab-> abc
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}

/*
- Approach 2: Use recursion and make use of recursive stack to store the babies

TC: O(k1*k2*k3*..kn * m) -> m is max depth and k1,k2,k3,...,kn are the numbers encountered in the string -> O(k*m)
SC: O(m * max string length) -> depth of the tree - inner most depth for stack - consecutive '[' brackets -> O(k*m)
 */

class Solution {
    int i = 0;
    public String decodeString(String s) {
        // Stack<Integer> inSt = new Stack<>();
        // Stack<StringBuilder> strSt = new Stack<>();

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        while(i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                // 1->12->122
                currNum = currNum * 10 + s.charAt(i) - '0'; 
                i++;
            }
            // new baby is starting
            else if(s.charAt(i) == '['){
                // incremenet i first as we dont want '[' character in the new baby string
                i++;
                // recursive call on s are i is a global variable so the pointer will never reset so even if we pass the whole string it will start from next character of '['
                String baby = decodeString(s);
                for(int i = 0; i < currNum; i++){
                    //currStr is holding the parent so append baby with the parent and mulitply it with parents digit times i.e in currNum
                    currStr.append(baby);
                }
                // reset currNum, currStr parent string will remain as is
                currNum = 0;
            }
            // baby over, increment i and return decodedString to the papa
            else if(s.charAt(i) == ']'){
                i++;
                return currStr.toString();
            }
            // if alphabet is encountered, append it to the currStr and increment i
            else{
                currStr.append(s.charAt(i));
                i++;
            }
        }
        return currStr.toString();
    }
}