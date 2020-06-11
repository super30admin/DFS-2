package LeetCode;

public class Program1 {/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 * 
	 * 
	 * T.C =  O(n)
	 * S.C =  O(n)
	 */
	class Solution{ 
		public String decodeString(String str) {
		        StringBuilder output = new StringBuilder();
		        decode(str, output, 0);
		        return output.toString();
		    }
		    
		    private int decode(String str, StringBuilder output, int index) {
		        while (index < str.length()) {   // run only until index is less than string length
		            char ch = str.charAt(index);
		            if (ch == ']') {
		                break;
		            }
		            if (Character.isDigit(ch)) {
		                int count = ch - '0';
		                while (Character.isDigit(str.charAt(index + 1))) {
		                    count *= 10;
		                    count += (str.charAt(index + 1) - '0');
		                    index++;
		                }
		                
		                StringBuilder pattern = new StringBuilder();
		                index = decode(str, pattern, index + 2);
		                
		                for (int j = 0; j < count; j++) {
		                    output.append(pattern);
		                }
		            } 
		            
		            else 
		               output.append(ch);
		            
		            index++;
		        }
		        return index;
		    }
		}