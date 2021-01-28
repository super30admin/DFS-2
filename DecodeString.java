/*
TC: O(N) as we are iterating stirng in forward direction
SC: O(n * k ) n is for implicit stack and k is number of times we are running the loop to count the
inner string
 */

class DecodeString{

    int i = 0;
    public String decodeString(String s) {
        if (s == null|| s.length() == 0) return null;

        StringBuilder currStr = new StringBuilder();
        int num = 0;

        while(i < s.length()){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num = num * 10 + c-'0';
                i++;
            }
            else if (c == '['){
                i++;
                String newStr = decodeString(s);
                for (int k = 0; k < num; k++){
                    currStr.append(newStr);
                }
                num = 0;
            }
            else if (c == ']'){
                i++;
                return currStr.toString();
            }
            else {
                currStr.append(c);
                i++;
            }
        }
        return currStr.toString();
    }
}