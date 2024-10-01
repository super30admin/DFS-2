// Time complexity = O(multiply all the numbers)
// Space complexity = O(n), , the length of the string in the recursion stack.
// The idea is to call the decodestring recursively and solve the subproblem.
class Solution {
    int index =0;// the index is the star here.// it needs to be global and keep on moving.
    public String decodeString(String s) {
        int currNum =0;
        String currStr = "";// this changes from child to parent.
        StringBuilder sb = new StringBuilder();
        while(index< s.length()) {
            char ch = s.charAt(index);
            if(Character.isDigit(ch)) {// takes care or 2 , 23, 234.
                currNum = currNum*10+ ch-'0';
                index++;
            } else if(ch=='[') {
                index++;
                String baby = decodeString(s);// we will call the baby here, since we have to solve for this.
                // multiply it as per the currNum
                StringBuilder decoded = new StringBuilder();
                for(int i=0;i< currNum;i++) {
                    decoded.append(baby);
                }
                // reset currNum to 0
                currNum =0;
                // append to the parent
                sb.append(decoded);
            } else if(ch==']') {
                // return to the parent, but increment index.
                index++;
                return sb.toString();// the baby is returned for the parent to process.
            } else {
                // append to the parent, and increment the index.
                sb.append(ch);
                index++;
            }
            
        }
        return sb.toString();
        
        
    }
}