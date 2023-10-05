import java.util.Stack;

//TimeComplexity  : O(n)
//Space Complexity : O(n)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
public class Problem2 {

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num=0;
        StringBuilder curr = new StringBuilder();

        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c) ){
                num = num*10 + c-'0';

            }else if(c == '['){
                numStack.push(num);
                strStack.push(curr);
                curr = new StringBuilder();
                num =0;


            }else if (c == ']'){
                StringBuilder newStr = new StringBuilder();
                int times = numStack.pop();
                for(int j=0;j<times;j++){
                    newStr.append(curr);
                }
                curr = strStack.pop().append(newStr);

            }else{

                curr.append(c);
            }
        }

        return curr.toString();

    }
}
