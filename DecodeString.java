/**Leetcode Question 394 - Decode String */
/**Algo - Iterative
 * Create a string stack and push the number and the curr string in it everytime an opening bracket is encountered
 * Pop from the stack when a closing becaket is encountered
 * Append the result to the current string
 */
/**TC - O(nk) - n = length of the string, k= max of the number
 * SC - O(nk)
 */
public class DecodeString {
    class Solution {
        public String decodeString(String s) {
            if(s==null || s.length() ==0){
                return s;
            }
            String curr = "";
            int num =0;
            Stack<String> d = new Stack<>();
            for(int i = 0; i<s.length(); i++){
                char ch = s.charAt(i);
                if(Character.isDigit(ch)){
                    num = num*10 + ch - '0';
                }
                else if(ch == '['){
                    d.push(curr);
                    d.push(String.valueOf(num));
                    num =0;
                    curr = "";
                }
                else if(ch == ']'){
                    int times = Integer.parseInt(d.pop());
                    StringBuilder sb = new StringBuilder();
                    for(int j =0; j<times; j++){
                        sb.append(curr);
                    }
                    curr = d.pop() + sb.toString();
                }
                else{
                    curr += ch;
                }
            }
           return curr; 
        }
    } 
}

/**Algo - Recursive */
class Solution {
    int i;
    public String decodeString(String s) {
        if(s==null || s.length() ==0){
            return s;
        }
        StringBuilder curr = new StringBuilder();
        int num =0;
        
        while(i<s.length()){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10 + ch - '0';
                i++;
            }
            else if(ch == '['){
                i++;
                String inner = decodeString(s);
                for(int j =0; j<num; j++){
                    curr.append(inner);
                }
                num =0;
            }
            else if(ch == ']'){
                i++;
                return curr.toString();
            }
            else{
                curr.append(ch);
                i++;
            }
        }
       return curr.toString(); 
    }
}
