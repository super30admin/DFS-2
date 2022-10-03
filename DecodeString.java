
// Iterative Approach
public class DecodeStringItr {
    public String decodeString(String s) {
        Stack<StringBuilder> string_stack = new Stack<>();
        Stack<Integer> number_stack = new Stack<>();
        StringBuilder currString = new StringBuilder();
        int num=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10+ ch - '0';
            }else if(ch=='['){
                string_stack.push(currString);
                number_stack.push(num);
                currString = new StringBuilder();
                num=0;
            }else if(ch==']'){
                int k = number_stack.pop();
                StringBuilder temp = new StringBuilder();
                for(int j=0;j<k;j++){
                    temp.append(currString);    
                }
                StringBuilder parent = string_stack.pop();
                currString = parent.append(temp);
            }else{
                currString.append(ch);
            }
        }
        return currString.toString();
    }
}

// Time Complexity - length of output string
// Space Complexity - Number of opening brackets

public class DecodeStringRec {
    int i;
    public String decodeString(String s) {
        StringBuilder currString = new StringBuilder();
        int num=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10+ ch - '0';
                i++;
            }else if(ch=='['){
                i++;
                String decoded = decodeString(s);
                for(int j=0;j<num;j++){
                    currString.append(decoded);
                }
                num=0;
            }else if(ch==']'){
                i++;
                return currString.toString();
            }else{
                currString.append(ch);
                i++;
            }
        }
        return currString.toString();
    }
}
// Time Complexity - length of output string
// Space Complexity - Number of opening brackets