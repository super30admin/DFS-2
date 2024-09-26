// Time Complexity : O(length of string)
// Space Complexity : O(length of string)

class Solution {
    public String decodeString(String s) {
        int i=0;
        StringBuilder result = new StringBuilder();
        Stack<String> st = new Stack<>();
        
        while(i<s.length()){
            Character ch = s.charAt(i);
            if(ch=='['){
                st.push(result.toString());
                result.setLength(0);
                i++;
            }else if(ch==']'){
                String tmpString = st.pop();
                int val = Integer.parseInt(st.pop());
                     for(int k=0;k<val;k++)
                        tmpString+=result.toString();
                     result.setLength(0);
                     result.append(tmpString);
                i++;
            }else if(Character.isDigit(ch)){
                String tmpString="";
                while(i<s.length() && Character.isDigit(s.charAt(i)))
                    tmpString+=s.charAt(i++);
                st.push(tmpString);
            }else{
                result.append(ch);
                i++;
            }
        }
        return result.toString();
    }
}
