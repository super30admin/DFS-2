Time Complexity: O(n)
Space Complexity: O(n)
Ran successfully on leetcode?: yes

class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '[' && s.charAt(i) != ']'){
                st.push(s.charAt(i));
            }
        }
        
        while(!st.isEmpty()){
            char ch = st.pop();
            
            if(Character.isDigit(ch)){
                int repeatation = Character.getNumericValue(ch);
                for(int j = 1; j < repeatation; j++){
                    result.append(result);
                }
            } else{
                StringBuilder temp = new StringBuilder(Character.toString(ch));
                result = temp.append(result);
            }
        }
        
        return result.toString();
    }
}
