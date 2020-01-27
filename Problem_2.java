/* 
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */
import java.util.Stack;

public class Problem_2 {
	
public String decodeString(String s) {
        
        if(s == null || s.equals("") || s.length() == 0){
            return s;
        }
        
        String currentString = "";
        int currentNum = 0;
        Stack<String> charStack = new Stack<String>();
        Stack<Integer> numStack = new Stack<Integer>();
        
        for(Character ch : s.toCharArray()){
        
            if(Character.isDigit(ch)){
                currentNum = currentNum * 10 + ch - '0';
            }else if(ch == '['){
                charStack.push(currentString);
                numStack.push(currentNum);
                currentString = "";
                currentNum = 0;
            }else if(ch == ']'){
                int size = numStack.pop();
                StringBuilder temp = new StringBuilder();
                
                for(int i=0; i<size; i++){
                    temp.append(currentString);
                }
                
                currentString = charStack.pop() + temp;
            }else{
                currentString = currentString + ch;
            }
        }
        
        return currentString;
        
    }

}
