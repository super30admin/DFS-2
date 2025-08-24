// This solution uses a DFS approach where we recursively grab the string based on 4 conditions as explained below
class Solution {
    int index = 0;
    public String decodeString(String s) {
        return decode(s);
    }

    private String decode(String s) {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while(index<s.length()) {
            char c = s.charAt(index);
            // if its a digit, iteratively create the number
            if(Character.isDigit(c)) {
                num=num*10+(c-'0');
            // If its a letter append it to the stringbuilder
            } else if(Character.isLetter(c)) {
                sb.append(s.charAt(index));
            // If its an open bracket, increment the global index and recursively get the string from next level
            } else if(c=='['){
                // This is important as we have to start from the next character in the recursion
                index++;
                String temp = decode(s);
                for(int i=0;i<num;i++) {
                    sb=sb.append(temp);
                }
                num=0;
            } else {
            // If its a closed bracket just return the string created so far in this loop
                return sb.toString();
            }
            index++;
        }
        
        return sb.toString();
    }
}
