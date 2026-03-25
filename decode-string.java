
// Solution -1
// Time Complexity: O(output length);
// Space Complexity : O(output length+ stack lengths )


class Solution {
    
    public String decodeString(String s) {
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> cntStack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currCount =0;
        for(int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                currCount = currCount*10 + ch - '0';

            } else if (ch == '[') {
                cntStack.add(currCount);
                strStack.push(currStr);
                currCount =0;
                currStr = new StringBuilder();

            } else if(ch == ']') {
                int k = cntStack.pop();
                StringBuilder baby = new StringBuilder();
                for(int j=0; j<k; j++) {
                    baby.append(currStr);
                }
                StringBuilder parent = strStack.pop();
                currStr = parent.append(baby);

            } else {
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}



// Solution -2 
// Time Complexity: O(output length);
// Space Complexity : O(output length+ maximum nseted brackets )


class Solution {
    int i; // class-level index
    
    public String decodeString(String s) {
        i = 0;
        StringBuilder sb = new StringBuilder();

        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                // parse the number before '['
                int start = i;
                while(Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int num = Integer.parseInt(s.substring(start, i));

                // now s.charAt(i) should be '['
                i++; // skip '['
                String str = builder(s, new StringBuilder());
                for (int j = 0; j < num; j++) {
                    sb.append(str);
                }
            } else {
                // append letters
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }

    private String builder(String s, StringBuilder newSB) {
        while (s.charAt(i) != ']') {
            if (Character.isDigit(s.charAt(i))) {
                int start = i;
                while (Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int localNum = Integer.parseInt(s.substring(start, i));
                i++; // skip '['
                String str = builder(s, new StringBuilder());
                for (int j = 0; j < localNum; j++) {
                    newSB.append(str);
                }
            } else {
                newSB.append(s.charAt(i));
                i++;
            }
        }

        i++; // skip the closing ']'
        return newSB.toString();
    }
}