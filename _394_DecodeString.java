// Time Complexity : o(p*n) where p is cummulatove product of all the  tokenized numbers and n is number of letters
// Space Complexity : o(p*n) where p is cummulatove product of all the  tokenized numbers and n is number of letters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach, add all the open brackets , all the numbers, all letter strings in stack, when you encounter a closing bracket perform string
//multiplication based on top of stack and add teh result back in stack.

class Solution {

    public String decodeString(String s) {

        Stack<String> stack = new Stack<>();

        int i = 0;
        while(i<s.length()){

            if(s.charAt(i) == '['){
                stack.push("[");
                i++;
            }
            else if(s.charAt(i) == ']'){
                StringBuilder val = new StringBuilder();
                while(!stack.peek().equals("[")){
                    val.insert(0,stack.pop());
                }
                stack.pop();
                int times = Integer.parseInt(stack.pop());
                StringBuilder temp = new StringBuilder();
                for(int k = 0; k<times; k++){
                    temp.append(val.toString());
                }
                stack.push(temp.toString());
                i++;
            }
            else if(Character.isDigit(s.charAt(i))){
                int num = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    char ch = s.charAt(i);
                    num = num*10 + (ch - '0');
                    i++;
                }
                stack.push(Integer.valueOf(num).toString());
            }
            else if(Character.isLetter(s.charAt(i))){
                StringBuilder temp = new StringBuilder();
                while(i<s.length() && Character.isLetter(s.charAt(i))){
                    char ch = s.charAt(i);
                    temp.append(ch);
                    i++;
                }
                stack.push(temp.toString());
            }
        }

        StringBuilder temp = new StringBuilder();
        while(!stack.isEmpty()){
            temp.insert(0,stack.pop());
        }
        return temp.toString();
    }
}

// Time Complexity : o(p*n) where p is cummulatove product of all the  tokenized numbers and n is number of letters
// Space Complexity : o(p*n) where p is cummulatove product of all the  tokenized numbers and n is number of letters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach : Same solutiona s above but with recursion and using recursive implicit stack.
class Solution {

    int i = 0;

    public String decodeString(String s) {
        i = 0;
        return decodeStringRec(s);
    }

    public String decodeStringRec(String s) {

        //if(i >= s.length()) return "";

        String res = "";
        int num = 0;

        while(i<s.length()){

            if(s.charAt(i) == '['){

                //call rec
                //getResult
                // merge by num
                //add to final string
                //reset num
                i++;
                String temp = decodeStringRec(s);
                for(int i = 0; i< num; i++){
                    res += temp;
                }
                num = 0;
            }
            else if(s.charAt(i) == ']'){
                i++;
                return res;
            }
            else if(Character.isDigit(s.charAt(i))){
                /*while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num = num*10 + (s.charAt(i) - '0');
                    i++;
                }*/
                num = num*10 + (s.charAt(i) - '0');
                i++;
            }
            else if(Character.isLetter(s.charAt(i))){
                /*while(i<s.length() && Character.isLetter(s.charAt(i))){
                    res += s.charAt(i);
                    i++;
                }*/
                res += s.charAt(i);
                i++;
            }
        }

        return res;
    }
}
