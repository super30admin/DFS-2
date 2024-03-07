// Time Complexity : O(K), K = Max(product of all nested k, max K) or length of the output
// Space Complexity : 
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Maintain a stack to reach the inner most depth of the string keeping track of parent.
// As we have to attach the decodedstring(child) to it's parent.

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
                
            }
            else if(c == '['){ // child is starting
                numSt.push(currNum);
                strSt.push(currStr); //parent

                currNum = 0;
                currStr =  new StringBuilder();
            }
            else if(c == ']'){
                int repeats = numSt.pop();
                StringBuilder repeatedStr = new StringBuilder();
                for(int i  = 1 ; i <= repeats; i++){
                    repeatedStr.append(currStr);
                }
                currStr = strSt.pop().append(repeatedStr);
            }
            else{
                currStr.append(c);
            }
        }

        return currStr.toString();

    }
}

// Recursive DFS
// Three line explanation of solution in plain english : Maintain a global i to iterate over the string. Keeping track of the parent and child recursively
//Assume, n is the length of the string s.

//Time Complexity: same as above.
//Space Complexity: O(n)\mathcal{O}(n)O(n). This is the space used to store the internal call stack used for recursion. As we are recursively decoding each nested pattern, the maximum depth of recursive call stack would not be more than n.

class Solution {
    int i = 0; // to iterate over the string.
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder(); // parent
        int currNum = 0;

        while(i < s.length()){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                i++;
                currNum = currNum * 10 + c - '0';
                // System.out.println(currNum);
                
            }
            else if(c == '['){ // child is starting
                i++;
                String decodedStr = decodeString(s); // child
                for(int k = 1 ; k <= currNum; k++){
                    currStr.append(decodedStr);
                } 
                currNum = 0; // reset as i have decoded the string above.
            }
            else if(c == ']'){ // child has been decoded
                i++;
                return currStr.toString();
            }
            else{
                currStr.append(c);
                i++;
            }
        }

        return currStr.toString();

    }
}