import java.util.Stack;

public class DecodeString {
//Time Complexity: O(n)
//Space Complexity: O(n)
    public String decodeString(String s) {
        Stack<Integer> numStk=new Stack<>();
        Stack<StringBuilder> strStk=new Stack<>();
        StringBuilder currSt = new StringBuilder();
        int currNum = 0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0'; //'7' - '0' = 7
            } else if(c == '['){
                numStk.push(currNum);
                strStk.push(currSt);
                currSt=new StringBuilder();
                currNum=0;
            }
            else if(c == ']'){
                int count=numStk.pop();
                StringBuilder newString=new StringBuilder();
                for(int k=0;k<count;k++){
                    newString.append(currSt);
                }
                StringBuilder parent= strStk.pop();
                currSt=parent.append(newString);
            } else{
                currSt.append(c);
            }
        }
        return currSt.toString();
    }
}
