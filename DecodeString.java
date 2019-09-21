package dfs;

// Time Complexity : O(n)
// Space Complexity: O(n)
// All test cases passed on leetcode
//

// Approach is that we replace every 2[ab] or similar with abab or so recursively. We do this for inner bracket first. hence following DFS approach.
// number can be 2-3 digits hence first iterate until we get complete number
// if we get '[' then recurse with inner characters and once returned add it to current text
// if we get ']' then return with characters repeated
// if we get any character just store it 
// Recursive DFS solution.

public class DecodeString {

	int currentChar = 0;

	public String decodeString(String s) {

		return decode(s);
	}

	public String decode(String sr) {

		StringBuilder str = new StringBuilder();
		int number = 0;
		while (currentChar < sr.length()) {
			if (Character.isDigit(sr.charAt(currentChar))) {

				while (Character.isDigit(sr.charAt(currentChar))) {
					number = number * 10 + sr.charAt(currentChar) - '0';
					currentChar++;
				}
			} else if (sr.charAt(currentChar) == '[') {
				currentChar++;
				String res = decode(sr);

				for (int i = 0; i < number; i++) {
					str.append(res);
				}
				number = 0;

			} else if (sr.charAt(currentChar) == ']') {
				currentChar++;
				return str.toString();

			} else {
				str.append(sr.charAt(currentChar));
				currentChar++;
			}

		}
		return str.toString();
	}

	public static void main(String[] args) {
		String str = "3[b2[ca]]";
		// String str = "3[ab]";
		System.out.println(new DecodeString().decodeString(str));

	}

}