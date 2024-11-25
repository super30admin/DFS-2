// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem2 {
    public String decodeString(String s) {
        return decodeStringHelper(s);
    }

    //Time Complexity: O(maxK⋅n), where maxK is the maximum value of k and n
    //SC: O(maxK⋅n), where maxK is the maximum value of k and n
    public String decodeStringHelper(String s) {
        Stack<StringBuilder> stStack  = new Stack<>();
        Stack<Integer> numStack  = new Stack<>();

        int sl = s.length();
        int currentNum=0;
        StringBuilder currStr = new StringBuilder();
        for(int i=0;i<sl;i++){
            char c =  s.charAt(i);
            StringBuilder baby = new StringBuilder();
            if(Character.isDigit(c)){
                int num = c-'0';
                currentNum = currentNum*10 + num;
            }else if(c == '['){// we have to
                numStack.push(currentNum);
                stStack.push(currStr);
                currentNum= 0;
                currStr = new StringBuilder();
            }else if(c == ']'){
                int num = numStack.pop();
                baby = new StringBuilder();

                for(int j=0;j<num;j++){
                    baby.append(currStr);
                }
                StringBuilder parent = stStack.pop();
                parent.append(baby);
                currStr  = parent;
            }else{
                //normal characters
                currStr.append(c);

            }
        }
        return currStr.toString();
    }


}