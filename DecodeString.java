//Time Complexity : O(N*k)
//Space Complexity : O() for recursion of all characters
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * dfs -> iterate and store non digits to a stringbuilder, when number is found,
 * apply decodestring on the string in []. then push this string k times to the
 * result.
 *
 */
class Solution {
	int index = 0;

	public String decodeString(String s) {
		StringBuilder res = new StringBuilder();
		while (index < s.length() && s.charAt(index) != ']') {
			if (!Character.isDigit(s.charAt(index))) {
				res.append(s.charAt(index++));
			} else {
				int k = 0;
				while (index < s.length() && Character.isDigit(s.charAt(index)))
					k = k * 10 + (s.charAt(index++) - '0');
				index++;
				String decoded = decodeString(s);
				index++;
				while (k-- > 0)
					res.append(decoded);
			}
		}
		return new String(res);
	}
}
