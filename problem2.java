// Time Complexity :O(n+ sum of digits)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        Stack<Integer> stackInt= new Stack<>();//keeps track of Integer
        Stack<String> stackChar= new Stack<>();//Keeps track of Character seen so far
        
        int num=0;
        String output="";
        
        for(int i=0;i<s.length();i++){
            Character curr=s.charAt(i);
            if(Character.isDigit(curr)){
                num=num*10+(curr-'0');//calculating the number to be lultplied with
            }
            else if(curr=='['){//push everything as the braces start
                stackInt.push(num);
                stackChar.push(output);
                
                num=0;
                output="";
                
            }
            else if(curr==']'){//pop everythingg and calculate once we see end braces
                int lim=stackInt.pop();
                String a="";
                for(int j=0;j<lim;j++)
                    a+=output;
                output=stackChar.pop();
                output=output+a;
            }
            
            else{//if it alphabet
                output+=curr;
            }
        }
        return output;
    }
}