//time complexity:O(nk) n=> length of given string, k => max number of times we need to repeat
//space complexity:O(number of number/patterns in the given string)
/*Approach
-maintaining two stacks for numbers and for holding strings which needs to be concatenated to
later occuring pattern
-The number stacks stores number of times a pattern needs to be processed
-The string stack contains all the previous patterns that we have processed
-These previous patterns need to be concatenated with future occuring patterns.
-following dfs approach by encoding last pattern first and then doing previous ones,and adding it to the result
 */
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        if(s == null || s.length() == 0){return currStr.toString();}
        int num = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10+c-'0';
            }
            else if(c == '['){
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            }
            else if(c == ']'){
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < times;j++){
                    newStr.append(currStr);
                }
                currStr=strStack.pop().append(newStr);
            }
            else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }

    public static void main(String args[]){
       DecodeString obj = new DecodeString(); 
       System.out.println(obj.decodeString("2[abc]3[cd]ef"));
       System.out.println(obj.decodeString("3[a]2[bc]"));

    }
}