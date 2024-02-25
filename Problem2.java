// ## Problem2 (https://leetcode.com/problems/decode-string/)

// Time Complexity : Iterative - O(No of characters in output) or O(max(product of numbers in square brackets, max number))
// Space Complexity : Iterative - O(Number of brackets in input)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {

    // Time Complexity :  O(No of characters in output) or O(max(product of numbers in square brackets, max number))
    // Space Complexity :  O(Number of brackets in input)
    private String iterative(String s){
        // Stacks to keep track of number of times child is repated
        // and the parent
        Stack<Integer> count=new Stack<>();
        Stack<StringBuilder> parent=new Stack<>();

        // To keep track of progression of current child
        int currCount=0;
        StringBuilder currStr=new StringBuilder();

        // Iterate over input string
        for(int i=0;i<s.length();i++){
            // process current index
            Character c=s.charAt(i);

            if(Character.isDigit(c)){
                // A number, process and increment currCount
                currCount=currCount*10 + (c-'0');
            }else if(c=='['){
                // A new child begins, add currStr and currCount to stack(recursive call)
                count.add(currCount);
                parent.add(currStr);

                // Reset
                currCount=0;
                currStr=new StringBuilder();
            }else if(c==']'){
                // Current child processing is finished
                // Remove from stack(remove current child and return to parent recursively)
                int cnt=count.pop();
                StringBuilder prnt=parent.pop();

                // Append current child cnt times to parnet
                for(int j=0;j<cnt;j++){
                    prnt.append(currStr);
                }

                currStr=prnt;
            }else{
                // It is an alphabet
                // append to currStr or child
                currStr.append(c);
            }
        }

        return currStr.toString();
    }

    
    int i;
    private String recursive(String s){

        int currNum=0;
        StringBuilder currStr=new StringBuilder();
        while(i<s.length()){
            // Process current char
            Character c=s.charAt(i);

            if(Character.isDigit(c)){
                // Update currnum
                currNum=currNum*10+(c-'0');
                i++;
            }else if(c=='['){
                //New child begins, recursive call
                i++;
                String childOp=recursive(s);
                for(int j=0;j<currNum;j++){
                    currStr.append(childOp);
                }
                currNum=0;
            }else if(c==']'){
                // current child processing finishes, return from recursive call
                i++;
                return currStr.toString();
            }else{
                // alphabet, append to curr str
                currStr.append(c);
                i++;
            }
        }

        return currStr.toString();
    }

    public String decodeString(String s) {
        // null checks
        if(s==null||s.length()==0){
            return s;
        }

        //return iterative(s);

        this.i=0;
        return recursive(s);
    }
}