//Time Complexity: O(n) – Each character in the input string s is processed exactly once.
// Space Complexity: O(n) – For the call stack and output string in the worst case (e.g., deep nesting or full repetition).

//Use recursion with a global index i to parse the input string character by character.
//On encountering '[', recursively decode the substring and repeat it currNum times.
//On encountering ']', return the built substring for the current recursion level.

class Solution {
    int i = 0;
    public String decodeString(String s) {
       
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        while(i < s.length()){ 
            char c = s.charAt(i);
            i++;

            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }else if(c == '['){
                String baby = decodeString(s);
                for(int k=0; k<currNum; k++){
                    currStr.append(baby);
                }

                currNum = 0;

            }else if(c == ']'){
                return currStr.toString();
            }else{
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}
