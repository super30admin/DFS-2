// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class DecodeStringRecursive {
    int i;
    public String decodeString(String s) {
        //Recursive Approach
        if(s.length() == 0  || s == null){
            return "";
        }

        StringBuilder curString = new StringBuilder();
        int num = 0;



        while(i < s.length()){
            char c = s.charAt(i);

            //4 Cases
            if(Character.isDigit(c)){ // digit

                num = num * 10 + Character.getNumericValue(c);
                i++;

            }else if(c == '['){//opening bracket
                i++;
                String decoded = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for(int j = 0; j < num; j++){
                    newStr.append(decoded);
                }
                curString.append(newStr);
                num = 0;

            }else if(c == ']'){// closing bracket
                i++;
                return curString.toString();

            }else{// alphabet
                curString.append(c);
                i++;
            }
        }

        return curString.toString();
    }
}
