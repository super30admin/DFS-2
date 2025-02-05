class Solution {
    // Time Complexity: O(n)
    public String decodeString(String s) {
        if (s.length() == 0){
            return "";
        }

       Stack<StringBuilder> strStack = new Stack <>();
       Stack<Integer> numStack = new Stack <>();

        StringBuilder sb = new StringBuilder();
        int curNum = 0;
      for (int i =0; i< s.length(); i++){
        char c = s.charAt(i);
        if(Character.isDigit(c)){
            curNum = curNum*10 + (c - '0');
        } else if (c == '['){
                strStack.push (sb);
                numStack.push (curNum);
                curNum = 0;
                sb = new StringBuilder();
        } else if (c == ']'){
              StringBuilder poppedString = strStack.pop();
              String strToAppend = sb.toString();
             int poppedNum = numStack.pop(); 
             for (int j =0;j < poppedNum;j++){
                poppedString.append(strToAppend);
             }  
             sb = poppedString;

        } else { 
            sb.append(c);
      } 

    }
    return sb.toString();
}
}
