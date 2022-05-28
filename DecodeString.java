// Time Complexity : O(O(maxK⋅n)), maxK is the maximum value of kk and nn is the length of a given string ss
// Space Complexity : O(M+N), where mm is the number of letters(a-z) and nn is the number of digits(0-9)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class DecodeString {
    public String decodeString(String s)  {

        if(s ==  null || s.length() == 0)return "";
        StringBuilder  currStr = new StringBuilder("");
        int currNum =0;
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt=new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            } else if(c == '[') {
                strSt.push(currStr);
                numSt.push(currNum);
                currStr= new StringBuilder("");
                currNum = 0;
            } else if (c == ']') {
                int count = numSt.pop();
                StringBuilder subStr = new StringBuilder("");
                for(int k=0;  k<count; k++)
                    subStr.append(currStr);
                currStr =  strSt.pop().append( subStr);

            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
