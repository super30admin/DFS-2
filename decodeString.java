**TC: O(length of the output string)**

**SC: O(number of opening brackets)**
class Solution {
    public String decodeString(String s) {
        if(s == null) return "";
        Stack<StringBuilder> stStr = new Stack<>();
        Stack<Integer> stNumb = new Stack<>();
        StringBuilder currString = new StringBuilder();
        int currNum = 0;
        
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum*10 + c - '0';
            }else if(c == '['){
                stStr.push(currString);
                stNumb.push(currNum);
                currString = new StringBuilder();
                currNum = 0;
            }else if(c == ']'){
                int n = stNumb.pop();
                StringBuilder temp = new StringBuilder();
                for(int j=0; j<n; j++){
                    temp.append(currString);
                }
                StringBuilder parent = stStr.pop();
                currString = parent.append(temp);
                
            }else{
                currString.append(c);
            }
        }
        return currString.toString();
    }
}
