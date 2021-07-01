/**
 * @author Vishal Puri
 * // Time Complexity : O(max(k)*n)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class DecodeString {
    public String decodeString(String s) {
        Stack<StringBuilder> result = new Stack();
        Stack<Integer> counts = new Stack();
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = 0;
                while(Character.isDigit(s.charAt(i))){
                    num = num*10 + s.charAt(i)-'0';
                    i++;
                }
                counts.push(num);
            }
            else if(c=='['){
                result.push(new StringBuilder(res));
                i++;
                res.setLength(0);
            }else if(c==']'){
                StringBuilder temp = result.pop();
                int count = counts.pop();
                while(count-->0){
                    temp.append(res);
                }
                res = temp;
                i++;
            }else{
                res.append(c);
                i++;
            }
        }
        return res.toString();
    }
}

