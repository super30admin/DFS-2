// Time Complexity: O(nL)
// Space Complexity: O(n+ L)
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> numSt = new Stack<>();

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }
            else if(c == '['){
                str.push(currStr);
                numSt.push(currNum);
                currNum = 0;
                currStr = new StringBuilder();

            }else if(c == ']'){
                int num = numSt.pop();
                StringBuilder temp = new StringBuilder();
                for(int k =0; k<num; k++){
                    temp.append(currStr);
                }

                currStr = str.pop();
                currStr.append(temp);
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();

    }
}