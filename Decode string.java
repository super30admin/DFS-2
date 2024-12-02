// Time complexity 0(n)
// space complexity 0(n)
// code successfully executed in leetcode

class Solution {
    public String decodeString(String s) {
        Stack <Integer> num = new Stack<>();
        Stack <String> st = new Stack<>();
        int currNum =0;
        String currstr = "";
        for(int i=0;i<s.length();i++){
            char c  = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum *10 + c -'0';
            } else if (c == '[') {
                num.push(currNum);
                st.push(currstr);
                currNum =0;
                currstr = "";   
            } else if (c == ']'){
                StringBuilder newstr = new StringBuilder();
                int times = num.pop();
                for (int j=0; j<times;j++){
                    newstr.append(currstr);
                }
                 currstr = st.pop() + newstr;
                }      else   {
                     currstr += c;
                  }
           }  
          return currstr;
        }
        
        }