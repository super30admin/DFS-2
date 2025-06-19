//DFS using stack
//TC=O(n) where n is the length of the string
//SC=O(n) for the stack
class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>(); //character array or list of characters in python
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        int n = s.length();
        for (int i=0;i<n;i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + c - '0';
            } else if (c =='['){
                numSt.push(num);
                strSt.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            } else if (c == ']'){
                int cnt = numSt.pop();
                StringBuilder decodedStr = new StringBuilder();
                for(int k=0;k<cnt; k++){
                    decodedStr.append(currStr);
                }
                currStr = strSt.pop().append(decodedStr);
            } else { //if it's an alphabet
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}

// //DFS using recursion
// //TC=O(n) , SC=O(n)
// class Solution {
//     int i;
//     public String decodeString(String s) {
//         int num = 0;
//         StringBuilder currStr = new StringBuilder();
//         int n = s.length();
//         while(i<n) {
//             char c = s.charAt(i);
//             if(Character.isDigit(c)){
//                 num = num*10 + c - '0';
//                 i++;
//             } else if (c =='['){
//                 i++;
//                 String child = decodeString(s);
//                 StringBuilder decoded = new StringBuilder();
//                 for (int k=0;k<num;k++){
//                     decoded.append(child);
//                 }
//                 //add to parent
//                 currStr.append(decoded);
//                 num = 0;
//             } else if (c == ']'){
//                 i++;
//                 return currStr.toString();
//             } else { //if it's an alphabet
//                 currStr.append(c);
//                 i++;
//             }
//         }
//         return currStr.toString();
//     }
// }