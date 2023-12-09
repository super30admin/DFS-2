import java.util.Stack;

//TC = O(N*K) where K is multiplication of all numbers or length of returned String
//SC = O(N*K) where K is multiplication of all numbers or length of returned String
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
public class DecodeStrings {
    public String decodeString(String s) {
        // *****************DFS*******************
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        int curNum = 0;
        StringBuilder curStr = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curNum = curNum * 10 + c-'0';
            }else if( c =='['){
                strSt.push(curStr);
                numSt.push(curNum);
                curNum = 0;
                curStr = new StringBuilder();
            }else if(c ==']'){
                int cnt = numSt.pop();
                StringBuilder temp = new StringBuilder();
                for(int k = 0; k < cnt; k++){
                    temp.append(curStr);
                }
                curStr = strSt.pop();
                curStr.append(temp);

            }else{
                curStr.append(c);
            }
        }
        return curStr.toString();
    }

    //*****************Recursion********************
    int i = 0;
    public String decodeString1(String s) {

        int curNum = 0;
        StringBuilder curStr = new StringBuilder();

        while(i < s.length()){
            char c = s.charAt(i);
            i++;
            if(Character.isDigit(c)){
                curNum = curNum * 10 + c-'0';
            }else if( c =='['){
                //decode the baby
                String result = decodeString1(s);
                for(int k = 0; k < curNum; k++){
                    curStr.append(result);
                }
                curNum = 0;
            }else if(c ==']'){
                return curStr.toString();

            }else{
                curStr.append(c);
            }
        }
        return curStr.toString();
    }
}
