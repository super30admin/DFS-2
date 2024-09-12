// Time Complexity : O(NxLength of output string)N=length of input string. 
// Space Complexity :  O(N);
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code uses the DFS with two stacks, one for number and one for strings. Every time we have char '[]' we push to stacks. 
// every time we hit a ']' we pop and do the calculuation or concatenation of strings. 
//Success
//Details 
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Decode String.
//Memory Usage: 37.4 MB, less than 5.68% of Java online submissions for Decode String.

//O(NxM) for time
    //O(maxDepth) for space, O(n/2) then O(N);
 public String decodeString(String s) {
        Stack<String> stackStrings= new Stack<>();
        Stack<Integer> stackNumbers= new Stack<>();
        int currentNumber=0;
        StringBuilder currentString=new StringBuilder();
        
        for (int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if (Character.isDigit(c)){
                currentNumber=currentNumber * 10 + (c - '0');
            }else if (c=='['){
                stackNumbers.add(currentNumber);
                stackStrings.add(currentString.toString());
                currentNumber=0;
                currentString.setLength(0);
            }else if (c==']'){
                int times=stackNumbers.pop();
                StringBuilder process = new StringBuilder();
                for (int k=0;k<times;k++){
                    process.append(currentString);
                }
                currentString.setLength(0);
                currentString.append(stackStrings.pop()).append(process.toString());
            }else
                currentString.append(c);
        }
        return currentString.toString();
    }