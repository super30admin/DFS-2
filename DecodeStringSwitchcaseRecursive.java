//Time complexity :O(m*n)
//Space complexity:O(m*n)
// using switch case recursive stack
class Solution {
    int i;
    //         !
    //3[a]2[bc] .. currString = aaabcbc
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder currString = new StringBuilder();
        int num = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            //4 options
            switch(c) {
                case '[' :
                    i++;
                    String decodedString = decodeString(s);
                    StringBuilder newString = new StringBuilder();
                    for(int j = 0; j < num; j++) {
                        newString.append(decodedString);
                    }
                    currString.append(newString);
                    num = 0;
                    break;
                case ']':
                    i++;
                    return currString.toString();
                default :
                    if(Character.isDigit(c)) {
                        num = num * 10 + c - '0';
                        i++;
                        break;
                    }
                    currString.append(c);
                    i++;
            }
        }
        return currString.toString();
    }
}
