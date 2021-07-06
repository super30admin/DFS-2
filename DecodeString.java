
//Iterative Approach
// Time Complexity : O(m*k) where k is max number in the string eg: 1115[a]
// Space Complexity : m*k
// Did this code successfully run on Leetcode : yes


public class DecodeString {
	    public String decodeString(String s) {
	        if(s == null || s.length() == 0) return s;
	        int num = 0;
	        Stack<Integer> numStack = new Stack<>();
	        Stack<StringBuilder> strStack = new Stack<>();
	        StringBuilder currStr = new StringBuilder();
	        
	        for(int i = 0; i< s.length(); i++){
	            char c = s.charAt(i);
	            if(Character.isDigit(c)){
	                num = num * 10 + c - '0';
	            }
	            else if(c == '['){
	                numStack.push(num);
	                strStack.push(currStr);
	                num = 0;
	                currStr = new StringBuilder();
	            }    
	            else if(c == ']'){
	                int times = numStack.pop();
	                StringBuilder newString = new StringBuilder();
	                for(int k = 0; k < times; k++){
	                    newString.append(currStr);
	                }
	                StringBuilder parent = strStack.pop();
	                currStr = parent.append(newString);
	            }else{
	                currStr.append(c);
	            }
	        }
	    return currStr.toString();
	    }
	}
