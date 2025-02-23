// Time Complexity : O(max(k, n)) where k = number of repetitions, n = number of character
// Space Complexity : O(m + k) :- where m = number of letters, k = number of digits
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {

    int i;
    public String decodeString(String s) {

        //we perform depth first search
        //For storing parent
        StringBuilder currStr = new StringBuilder();
        //For storing repetitions
        int curr = 0;

        while(i < s.length()) {

            char ch = s.charAt(i);

            //keep track of digits
            if(Character.isDigit(ch)) {

                curr = curr * 10 + ch - '0';
                i++;
            }
            //we call DecodeString function for child and result will be returned here which will be appended to parent
            else if(ch == '[') {
                i++;
                //since i is stored in global, child iteration will start at correct index
                String str = decodeString(s);

                //repeat child curr times
                StringBuilder child = new StringBuilder();
                for(int i = 0; i < curr; i++) {

                    child.append(str);
                }

                //then append to parent
                currStr.append(child);
                curr = 0;
            }
            //if it is closing bracket just return current string
            else if(ch == ']') {

                i++;
                return currStr.toString();
            }
            //if it is character we keep in appending the character string
            else {
                
                currStr.append(ch);
                i++;
            }
        }
         
         return currStr.toString();
    }
}

/*

//Iterative solution:-

class Solution {
    public String decodeString(String s) {

        //we will take 2 stacks for storing the parent string and number of times child string will be repeated. Eg 2[a 4[b]]
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        int currNum = 0;
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            //if it is a digit we keep a count :- 43
            if(Character.isDigit(ch)) {

                currNum = currNum * 10 + ch - '0';
            }
            //we will need to save the number and parent string first
            else if(ch == '[') {

                numStack.push(currNum);
                strStack.push(str);
                currNum = 0;
                str = new StringBuilder();
            }
            //it means our string is ended and we need to multiply it with the number prior to it and add it to its parent
            else if(ch == ']') {

                int repeat = numStack.pop();
                StringBuilder baby = new StringBuilder();

                for(int k = 0; k < repeat; k++) {
                    baby.append(str);
                }

                //once child string is created add it to previous parent
                StringBuilder parent = strStack.pop();
                str = parent.append(baby);
            }
            //if it is a letter we keep on adding to current string and keep track of it
            else {

                str.append(ch);
            }

        }
        
        return str.toString();
    }
}

//Time complexity:- O(max(k, n)) where k = number of repetitions, n = number of character
/* Space compexity:- O(m + k) :- where m = number of letters, k = number of digits*/

*/