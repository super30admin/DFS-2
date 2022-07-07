import java.util.Stack;

// TIme complexity: O(L) where L is the length of the output String
// Space Complexity: O(N) where N is the number of [ brackets in String
public class DecodeString {

    public String decodeString(String s) {
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            // If it is a digit
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            // If it is a [
            else if(c == '['){
                strSt.push(currStr);
                numSt.push(num);
                num = 0;
                currStr = new StringBuilder();
            }
            // If it is a ]
            else if(c == ']'){
                int k = numSt.pop();
                StringBuilder temp = new StringBuilder();
                for(int j=0; j<k; j++){
                    temp.append(currStr);
                }
                StringBuilder parent = strSt.pop();
                currStr = parent.append(temp);
            }
            //  If it is a letter
            else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
